package com.Flapkap.VendingMachine.business.user.validator.buyer;

import com.Flapkap.VendingMachine.exception.BaseException;
import com.Flapkap.VendingMachine.business.product.entity.Product;
import com.Flapkap.VendingMachine.business.user.dto.request.BuyerBuyingRequest;
import com.Flapkap.VendingMachine.business.user.exceptions.buyer.InsufficientStockException;
import com.Flapkap.VendingMachine.business.user.validator.BaseValidator;


public class ProductShouldHaveSufficientStock implements BaseValidator {

    private final Long productId;
    private final Integer requestedAmount;
    private final Integer dbProductAmount;

    public ProductShouldHaveSufficientStock(BuyerBuyingRequest request, Product product) {
        this.productId = product.getId();
        this.requestedAmount = request.getAmount();
        this.dbProductAmount = product.getAmountAvailable();
    }

    @Override
    public void validateOrThrow() throws BaseException {
        if (requestedAmount > dbProductAmount) {
            throw new InsufficientStockException(productId, requestedAmount, dbProductAmount);
        }
    }
}
