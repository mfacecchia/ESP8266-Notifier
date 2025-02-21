package com.feis.smarthouse.common.interfaces;

import io.javalin.Javalin;

public interface EndpointsRegister {
    void registerEndpoints(Javalin app);
}
