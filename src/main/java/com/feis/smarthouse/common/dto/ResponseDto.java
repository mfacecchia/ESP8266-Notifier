package com.feis.smarthouse.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Response class for a consistent response body content.
 * Includes a {@code statusCode}, a custom {@code message} and optional
 * {@code data} field (used mainly to send data possibly fetched from a database
 * or as a result of some data processing).
 */
@Data
@AllArgsConstructor
public class ResponseDto<T> {
    private final int status;
    private final String message;
    private final T data;
}
