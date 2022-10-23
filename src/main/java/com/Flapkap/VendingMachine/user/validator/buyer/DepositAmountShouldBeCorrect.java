package com.Flapkap.VendingMachine.user.validator.buyer;

import com.Flapkap.VendingMachine.config.exception.BaseException;
import com.Flapkap.VendingMachine.user.exceptions.buyer.WrongDepositAmountException;
import com.Flapkap.VendingMachine.user.validator.BaseValidator;
import java.math.BigDecimal;
import java.util.List;

public class DepositAmountShouldBeCorrect implements BaseValidator {
    private final List<BigDecimal> allowedDepositAmounts = List.of(
            BigDecimal.valueOf(5),
            BigDecimal.valueOf(10),
            BigDecimal.valueOf(20),
            BigDecimal.valueOf(50),
            BigDecimal.valueOf(100));
    private final BigDecimal requestedAmount;

    public DepositAmountShouldBeCorrect( BigDecimal requestedAmount) {
        this.requestedAmount = requestedAmount;
    }

    @Override
    public void validateOrThrow() throws BaseException {
        if (!allowedDepositAmounts.contains(requestedAmount)) {
            throw new WrongDepositAmountException( requestedAmount, allowedDepositAmounts);
        }
    }
}
