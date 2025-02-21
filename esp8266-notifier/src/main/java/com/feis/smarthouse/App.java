package com.feis.smarthouse;

import java.util.Arrays;

import com.feis.smarthouse.common.config.AppBuilder;

public class App {
    public static void main(String[] args) throws Exception {
        AppBuilder appBuilder = new AppBuilder(Arrays.asList());
        appBuilder.configureEndpoints(true);
        appBuilder.start();
    }
}
