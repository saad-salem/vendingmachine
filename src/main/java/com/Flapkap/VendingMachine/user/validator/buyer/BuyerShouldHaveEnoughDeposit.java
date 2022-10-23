package com.Flapkap.VendingMachine.user.validator.buyer;

import com.Flapkap.VendingMachine.config.exception.BaseException;
import com.Flapkap.VendingMachine.product.entity.Product;
import com.Flapkap.VendingMachine.user.dto.request.BuyerBuyingRequest;
import com.Flapkap.VendingMachine.user.entity.User;
import com.Flapkap.VendingMachine.user.exceptions.buyer.BuyerNotHaveEnoughDepositException;
import com.Flapkap.VendingMachine.user.validator.BaseValidator;
import java.math.BigDecimal;

public class BuyerShouldHaveEnoughDeposit implements BaseValidator {

    private final Integer requestedProductAmount;
    private final Double productCost;
    private final Long buyerId;
    private final BigDecimal buyerDeposit;

    public BuyerShouldHaveEnoughDeposit(BuyerBuyingRequest request, Product product, User user) {
        this.requestedProductAmount = request.getAmount();
        this.productCost = product.getCost();
        this.buyerId = user.getId();
        this.buyerDeposit = user.getDeposit();
    }

    @Override
    public void validateOrThrow() throws BaseException {
        BigDecimal orderTotalPrice = BigDecimal.valueOf(requestedProductAmount * productCost);
        if (orderTotalPrice.compareTo(buyerDeposit) > 0) {
            throw new BuyerNotHaveEnoughDepositException(buyerId, orderTotalPrice, buyerDeposit);
        }
    }
}
