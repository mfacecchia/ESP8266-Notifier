package com.feis.smarthouse.common.exceptions;

public class NotificationSendingException extends AppException {
    private final static int STATUS_CODE = 400;

    public NotificationSendingException(String message) {
        super(STATUS_CODE, message);
    }

    public NotificationSendingException(String message, Throwable cause) {
        super(STATUS_CODE, message, cause);
    }
}
