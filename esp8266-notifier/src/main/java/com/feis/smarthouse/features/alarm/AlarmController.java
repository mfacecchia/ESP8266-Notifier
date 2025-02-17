package com.feis.smarthouse.features.alarm;

import com.feis.smarthouse.common.interfaces.EndpointsRegister;

import io.javalin.Javalin;
import kotlin.NotImplementedError;

public class AlarmController implements EndpointsRegister {
    @Override
    public void registerEndpoints(Javalin app) {
        // TODO: move "/api/v1" prefix outta here for reusability
        app.get("/api/v1/alarm", (ctx) -> {
            throw new NotImplementedError("Not yet implemented");
        });
    }
}
