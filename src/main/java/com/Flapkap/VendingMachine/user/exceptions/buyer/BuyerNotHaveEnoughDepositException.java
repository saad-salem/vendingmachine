package com.Flapkap.VendingMachine.user.exceptions.buyer;

import com.Flapkap.VendingMachine.config.exception.BadRequestException;

import java.math.BigDecimal;

public class BuyerNotHaveEnoughDepositException extends BadRequestException {

    public BuyerNotHaveEnoughDepositException(Long buyerId, BigDecimal orderTotalPrice, BigDecimal buyerDeposit) {
        super("Buyer[" + buyerId + "] does not have enough deposit.");
        addParam("buyerId", buyerId);
        addParam("orderTotalPrice", orderTotalPrice);
        addParam("buyerDeposit", buyerDeposit);
    }
}
