package com.Flapkap.VendingMachine.exception.auth;

import com.Flapkap.VendingMachine.exception.NotFoundException;

public class RefreshTokenNotFoundException extends NotFoundException {
    public RefreshTokenNotFoundException() {
        super("Refresh token is not in database!");
    }
}
