package com.Flapkap.VendingMachine.config.exception;

import org.springframework.http.HttpStatus;

public class ForbiddenException extends BaseException {

    public ForbiddenException(String message) {
        super(HttpStatus.FORBIDDEN.value(), message);
    }

    public ForbiddenException() {
        super(HttpStatus.FORBIDDEN.value(),"you don't have this product");
    }
}
