package com.Flapkap.VendingMachine.config.exception;

import org.springframework.http.HttpStatus;

public class NotFoundException extends BaseException {
    public NotFoundException(String message) {
        super(HttpStatus.NOT_FOUND.value(), message);
    }

    public NotFoundException(String message, String field, Object value) {
        super(HttpStatus.NOT_FOUND.value(), message);
        addParam(field, value);
    }
}
