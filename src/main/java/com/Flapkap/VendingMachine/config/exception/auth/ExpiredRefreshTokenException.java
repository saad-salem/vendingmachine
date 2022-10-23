package com.Flapkap.VendingMachine.config.exception.auth;

import com.Flapkap.VendingMachine.config.exception.BadRequestException;

public class ExpiredRefreshTokenException extends BadRequestException {
    public ExpiredRefreshTokenException() {
        super("Refresh token was expired. Please make a new sign-in request.");
    }
}
