package com.feis.smarthouse.common.config;

import java.util.Arrays;
import java.util.Map;
import java.util.Properties;

import com.feis.smarthouse.common.util.Environment;

import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

/**
 * Singleton class used to send emails through SMTP.
 *
 * @see jakarta.mail.Message
 * @see jakarta.mail.Transport
 */
public class MailSender {
    private static MailSender instance = null;
    private static final Map<String, String> configValues = Environment
            .getEnvironmentVariables(Arrays.asList("SMTP_HOST", "SMTP_PORT", "USER_EMAIL", "USER_PASSWORD"));
    private final String fromName;
    private final Properties props;
    private final Session session;
    final String DEFAULT_HTML_HEAD = "<head>"
            + "<meta name=\"color-scheme\" content = \"light only\">"
            + "<meta name = \"supported-color-schemes\" content = \"light only\">"
            + "<meta charset = 'UTF-8'>"
            + "</head>";

    private MailSender(String fromName) {
        this.fromName = fromName.strip();

        props = new Properties();
        props.put("mail.smtp.host", configValues.get("SMTP_HOST"));
        props.put("mail.smtp.port", configValues.get("SMTP_PORT"));
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        session = Session.getInstance(
                props,
                new MailAuthenticator(configValues.get("USER_EMAIL"),
                        configValues.get("USER_PASSWORD")));
    }

    public static MailSender getInstance() {
        if (instance == null) {
            instance = new MailSender("Smart House Mailing System");
        }
        return instance;
    }

    public String getFromName() {
        return fromName;
    }

    /**
     * Delivers an email to the specified {@code recipient}. It is possible to send
     * the Email as plaintext, HTML-formatted message, or both (depending on
     * receiver's email client)
     *
     * @param recipient    The email address of the recipient
     * @param subject      The subject line of the email
     * @param plainText    The plain text content of the email (also used as
     *                     fallback in case html-version message is not available
     *                     for user's client)
     * @param htmlContent  The HTML content of the email (can be either set to
     *                     {@code Null}
     *                     or {@code ""} to disable the feature)
     * @param allowReplies Whether to allow replies to the email
     * @throws EmailSendingException If there is an error sending the email
     */
    public void deliverMessage(String recipient, String subject, String plainText, String htmlContent,
            boolean allowReplies) throws Exception {
        try {
            Message msg = buildMessage(recipient, subject, htmlContent, htmlContent, allowReplies);
            Transport.send(msg);
        } catch (MessagingException e) {
            throw new Exception("Could not send email", e);
            // throw new EmailSendingException("Could not send email", e);
        }
    }

    /**
     * Builds a message ready to be sent to the defined {@code recipient}
     * 
     * @param recipient    the email address to send the message to
     * @param subject      the message subject
     * @param textContent  the message plaintext message (also used as fallback in
     *                     case html-version message is not available for user's
     *                     client)
     * @param htmlContent  HTML version of email (can be either set to {@code Null}
     *                     or {@code ""} to disable the feature)
     * @param allowReplies allow the user whetever to reply to the message or not
     * @return the {@code MimeMessage} ready to be sent through a
     *         {@link Transport}
     * @throws MessagingException The base class for all exceptions thrown by the
     *                            Messaging classes
     *                            ({@see jakarta.mail.MessagingException})
     */
    private MimeMessage buildMessage(String recipient, String subject, String textContent, String htmlContent,
            boolean allowReplies) throws Exception {
        try {

            MimeMessage msg = new MimeMessage(session);
            msg.setRecipients(Message.RecipientType.TO, recipient);
            msg.setFrom(fromName + "<" + configValues.get("USER_EMAIL") + ">");
            msg.setSubject(subject);
            msg.setText(textContent);
            if (!("".equals(htmlContent)) && htmlContent != null)
                msg.setContent(
                        "<!DOCTYPE html>"
                                + "<html lang = \"en\">"
                                + DEFAULT_HTML_HEAD
                                + "<body>"
                                + htmlContent
                                + "</body>"
                                + "</html>",
                        "text/html");
            if (allowReplies) {
                msg.setReplyTo(InternetAddress.parse(configValues.get("USER_EMAIL")));
            }
            return msg;
        } catch (MessagingException e) {
            throw new Exception("Error while sending email", e);
            // throw new EmailSendingException("Error while building email", e);
        }
    }
}
