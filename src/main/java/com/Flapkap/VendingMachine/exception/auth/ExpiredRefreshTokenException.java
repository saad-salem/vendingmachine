package com.Flapkap.VendingMachine.exception.auth;

import com.Flapkap.VendingMachine.exception.BadRequestException;

public class ExpiredRefreshTokenException extends BadRequestException {
    public ExpiredRefreshTokenException() {
        super("Refresh token was expired. Please make a new sign-in request.");
    }
}
