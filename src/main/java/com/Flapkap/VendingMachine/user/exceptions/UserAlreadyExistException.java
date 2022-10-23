package com.Flapkap.VendingMachine.user.exceptions;

import com.Flapkap.VendingMachine.config.exception.DuplicatedDataException;

public class UserAlreadyExistException extends DuplicatedDataException {

    public UserAlreadyExistException(String message) {
        super("User already exists with username "+ message);
    }
}
