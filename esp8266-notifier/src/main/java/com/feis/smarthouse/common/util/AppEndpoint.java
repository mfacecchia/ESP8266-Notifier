package com.feis.smarthouse.common.util;

public enum AppEndpoint {
    BASE_V1_ENDPOINT("/api/v1"),
    ALARM("/alarm");

    private final String url;

    private AppEndpoint(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
