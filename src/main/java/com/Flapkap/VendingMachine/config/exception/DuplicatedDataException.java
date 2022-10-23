package com.Flapkap.VendingMachine.config.exception;

import org.springframework.http.HttpStatus;

public class DuplicatedDataException extends BaseException {
    public DuplicatedDataException(String message) {
        super(HttpStatus.BAD_REQUEST.value(), message);
    }
}
