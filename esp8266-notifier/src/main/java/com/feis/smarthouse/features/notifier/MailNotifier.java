package com.feis.smarthouse.features.notifier;

import com.feis.smarthouse.features.notifier.interfaces.Notifier;

import kotlin.NotImplementedError;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MailNotifier implements Notifier {
    private String recipient;

    @Override
    public void send() {
        throw new NotImplementedError("Not yet implemented");
    }
}
