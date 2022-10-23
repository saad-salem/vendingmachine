package com.Flapkap.VendingMachine.user.validator;


import com.Flapkap.VendingMachine.config.exception.BaseException;

public interface BaseValidator {
    void validateOrThrow() throws BaseException;
}
