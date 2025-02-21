package com.feis.smarthouse;

import java.util.Arrays;

import com.feis.smarthouse.common.config.AppBuilder;
import com.feis.smarthouse.features.alarm.AlarmController;

public class App {
    public static void main(String[] args) throws Exception {
        AppBuilder appBuilder = new AppBuilder(Arrays.asList(new AlarmController()));
        appBuilder.configureEndpoints(true);
        appBuilder.start();
    }
}
