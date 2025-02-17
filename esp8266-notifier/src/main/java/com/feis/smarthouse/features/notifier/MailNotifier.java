package com.feis.smarthouse.features.notifier;

import com.feis.smarthouse.common.config.MailSender;
import com.feis.smarthouse.features.notifier.interfaces.Notifier;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MailNotifier implements Notifier {
    private MailSender mailSender;

    @Override
    public void send(String recipient, String subject, String msg) throws Exception {
        mailSender.deliverMessage(recipient, subject, msg, msg, false);
    }
}
