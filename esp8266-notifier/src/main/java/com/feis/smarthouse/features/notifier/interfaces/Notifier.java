package com.feis.smarthouse.features.notifier.interfaces;

public interface Notifier {
    // TODO: Update signature to throw custom app exception
    // TODO: Add custom options map as method property (should allow
    // useful options such as "allow answers" from a mail notifier implementation,
    // etc...)
    void send(String recipient, String subject, String msg) throws Exception;
}