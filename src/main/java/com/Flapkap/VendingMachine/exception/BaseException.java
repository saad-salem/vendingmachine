package com.Flapkap.VendingMachine.exception;


import java.util.HashMap;
import java.util.Map;

public abstract class BaseException extends RuntimeException {

    private int status;
    private String exception;
    private String message;
    private Map<String, Object> params;

    public BaseException(String message) {
        super(message);
    }

    public BaseException(int status, String message) {
        this(message);
        this.status = status;
        this.exception = getClass().getSimpleName();
        this.message = message;
        this.params = new HashMap<>();
    }

    public ErrorDto toErrorDto(String stackTrace) {
        return new ErrorDto(
                this.exception,
                this.message,
                this.params,
                stackTrace
        );
    }

    public int getStatus() {
        return status;
    }

    public String getException() {
        return exception;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    public void addParam(String key, Object value) {
        this.params.put(key, value);
    }
}
