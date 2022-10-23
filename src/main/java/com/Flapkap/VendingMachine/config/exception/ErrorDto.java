package com.Flapkap.VendingMachine.config.exception;

import java.util.Date;
import java.util.Map;

public class ErrorDto {
    private final Date timestamp;
    private final String exception;
    private final String message;
    private final Map<String, Object> params;
//    private final String stackTrace;

    public ErrorDto(String exception, String message, Map<String, Object> params, String stackTrace) {
        this.timestamp = new Date();
        this.exception = exception;
        this.message = message;
        this.params = params;
//        this.stackTrace = stackTrace;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getException() {
        return exception;
    }

    public String getMessage() {
        return message;
    }

    public Map<String, Object> getParams() {
        return params;
    }

//    public String getStackTrace() {
//        return stackTrace;
//    }
}
