package com.Flapkap.VendingMachine.user.exceptions.buyer;

import com.Flapkap.VendingMachine.config.exception.BadRequestException;

import java.math.BigDecimal;
import java.util.List;

public class WrongDepositAmountException extends BadRequestException {
    public WrongDepositAmountException(BigDecimal requestedAmount, List<BigDecimal> allowedDepositAmounts) {
        super("Wrong deposit amount for buyer");
        addParam("requestedAmount", requestedAmount);
        addParam("allowedDepositAmounts", allowedDepositAmounts);
    }
}
