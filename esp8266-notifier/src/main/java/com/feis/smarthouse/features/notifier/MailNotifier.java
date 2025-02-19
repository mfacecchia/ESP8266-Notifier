package com.feis.smarthouse.features.notifier;

import com.feis.smarthouse.common.config.MailSender;
import com.feis.smarthouse.features.notifier.interfaces.Notifier;

// TODO: Set recipient as instance attribute
public class MailNotifier implements Notifier {
    private final MailSender mailSender;

    public MailNotifier() {
        mailSender = MailSender.getInstance();
    }

    @Override
    public void send(String recipient, String subject, String msg) throws Exception {
        mailSender.deliverMessage(recipient, subject, msg, msg, false);
    }
}
