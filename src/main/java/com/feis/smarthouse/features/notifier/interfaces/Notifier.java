package com.feis.smarthouse.features.notifier.interfaces;

import com.feis.smarthouse.common.exceptions.NotificationSendingException;

public interface Notifier {
    // TODO: Add custom options map as method property (should allow
    // useful options such as "allow answers" from a mail notifier implementation,
    // etc...)
    void send(String recipient, String subject, String msg) throws NotificationSendingException;
}