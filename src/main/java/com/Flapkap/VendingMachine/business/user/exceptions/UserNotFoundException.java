package com.Flapkap.VendingMachine.business.user.exceptions;

import com.Flapkap.VendingMachine.exception.NotFoundException;

public class UserNotFoundException extends NotFoundException {
    public UserNotFoundException(String username) {
        super("User not found by username.", "userId", username);
    }
    public UserNotFoundException() {
        super("User not found ");
    }

}
