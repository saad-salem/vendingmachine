package com.Flapkap.VendingMachine.config.exception.auth;

import com.Flapkap.VendingMachine.config.exception.NotFoundException;

public class RefreshTokenNotFoundException extends NotFoundException {
    public RefreshTokenNotFoundException() {
        super("Refresh token is not in database!");
    }
}
