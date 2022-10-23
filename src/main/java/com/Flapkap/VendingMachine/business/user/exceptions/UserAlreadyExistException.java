package com.Flapkap.VendingMachine.business.user.exceptions;

import com.Flapkap.VendingMachine.exception.DuplicatedDataException;

public class UserAlreadyExistException extends DuplicatedDataException {

    public UserAlreadyExistException(String message) {
        super("User already exists with username "+ message);
    }
}
