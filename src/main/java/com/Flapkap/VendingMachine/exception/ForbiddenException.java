package com.Flapkap.VendingMachine.exception;

import org.springframework.http.HttpStatus;

public class ForbiddenException extends BaseException {

    public ForbiddenException() {
        super(HttpStatus.FORBIDDEN.value(),"you don't have this product");
    }
}
