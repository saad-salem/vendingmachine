package com.Flapkap.VendingMachine.config.exception;

import org.springframework.http.HttpStatus;

import java.util.Map;

public class BadRequestException extends BaseException {

    public BadRequestException(String message) {
        super(HttpStatus.BAD_REQUEST.value(), message);
    }

    public BadRequestException(String message, Map<String, Object> parameters) {
        super(HttpStatus.BAD_REQUEST.value(), message);
        for (Map.Entry<String, Object> entry : parameters.entrySet()) {
            addParam(entry.getKey(), entry.getValue());
        }
    }
    public BadRequestException(Long id,String message) {
        super(HttpStatus.BAD_REQUEST.value(), message);
    }
}
