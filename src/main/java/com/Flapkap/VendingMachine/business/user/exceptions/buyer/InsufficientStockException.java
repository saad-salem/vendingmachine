package com.Flapkap.VendingMachine.business.user.exceptions.buyer;

import com.Flapkap.VendingMachine.exception.BadRequestException;

public class InsufficientStockException extends BadRequestException {
    public InsufficientStockException(Long productId, Integer requestedAmount, Integer dbProductAmount) {
        super("Insufficient stock for product[" + productId + "].");
        addParam("productId", productId);
        addParam("requestedAmount", requestedAmount);
        addParam("dbProductAmount", dbProductAmount);
    }
}
