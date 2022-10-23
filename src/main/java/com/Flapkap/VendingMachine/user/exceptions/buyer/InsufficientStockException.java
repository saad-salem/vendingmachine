package com.Flapkap.VendingMachine.user.exceptions.buyer;

import com.Flapkap.VendingMachine.config.exception.BadRequestException;

public class InsufficientStockException extends BadRequestException {
    public InsufficientStockException(Long productId, Integer requestedAmount, Integer dbProductAmount) {
        super("Insufficient stock for product[" + productId + "].");
        addParam("productId", productId);
        addParam("requestedAmount", requestedAmount);
        addParam("dbProductAmount", dbProductAmount);
    }
}
