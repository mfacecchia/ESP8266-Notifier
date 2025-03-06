package com.feis.smarthouse.features.alarm;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.feis.smarthouse.common.dto.ResponseDto;
import com.feis.smarthouse.common.interfaces.EndpointsRegister;
import com.feis.smarthouse.common.util.AppEndpoint;
import com.feis.smarthouse.common.util.Environment;
import com.feis.smarthouse.features.notifier.MailNotifier;
import com.feis.smarthouse.features.notifier.interfaces.Notifier;

import io.javalin.Javalin;
import io.javalin.http.Handler;

public class AlarmController implements EndpointsRegister {
    private final String BASE_URL = AppEndpoint.BASE_V1_ENDPOINT.getUrl() + AppEndpoint.ALARM.getUrl();

    @Override
    public void registerEndpoints(Javalin app) {
        app.get(BASE_URL, triggeredAlarm());
    }

    // TODO: REFACTOR
    private Handler triggeredAlarm() {
        return (ctx) -> {
            // TODO: Make offset parsing dynamic based on client's tz (currently
            // server-based)
            OffsetDateTime triggeredAt = Instant.now().atOffset(ZoneOffset.ofHours(1));
            String formatted = triggeredAt.format(DateTimeFormatter.ofPattern("dd/MM/yyy 'at' kk:mm:ss O"));
            List<Notifier> notifiers = new ArrayList<>(Arrays.asList(new MailNotifier()));
            Map<String, String> notificationOptions = Environment
                    .getEnvironmentVariables(Arrays.asList("EMAIL_NOTIFY_TO"));
            for (Notifier notifier : notifiers) {
                notifier.send(notificationOptions.get("EMAIL_NOTIFY_TO"), "Alarm Triggered",
                        String.format("A motion was detected on %s", formatted));
            }
            final int STATUS_CODE = 200;
            ResponseDto<?> response = new ResponseDto<>(STATUS_CODE, "Notification sent", null);
            ctx.status(STATUS_CODE).json(response);
        };
    }
}
