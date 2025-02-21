package com.feis.smarthouse.common.config;

import jakarta.mail.Authenticator;
import jakarta.mail.PasswordAuthentication;

/**
 * Class used to authenticate the SMTP client and enable it to send
 * Emails.
 *
 * @see Authenticator
 */
public final class MailAuthenticator extends Authenticator {
    private final String email;
    private final String password;

    public MailAuthenticator(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(email, password);
    }
}
