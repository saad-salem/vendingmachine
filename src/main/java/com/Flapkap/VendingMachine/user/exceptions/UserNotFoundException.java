package com.Flapkap.VendingMachine.user.exceptions;

import com.Flapkap.VendingMachine.config.exception.NotFoundException;

public class UserNotFoundException extends NotFoundException {
    public UserNotFoundException(String username) {
        super("User not found by username.", "userId", username);
    }
    public UserNotFoundException() {
        super("User not found ");
    }

}
