package com.Flapkap.VendingMachine.business.user.validator;


import com.Flapkap.VendingMachine.exception.BaseException;

public interface BaseValidator {
    void validateOrThrow() throws BaseException;
}
