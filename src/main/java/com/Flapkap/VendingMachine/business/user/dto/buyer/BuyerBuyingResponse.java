package com.Flapkap.VendingMachine.business.user.dto.buyer;

import lombok.Getter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class BuyerBuyingResponse {
    private final BigDecimal totalSpent;
    private final Long productId;
    private final Map<String, Integer> change;

    public BuyerBuyingResponse(BigDecimal totalSpent, Long productId, BigDecimal userDeposit) {
        this.totalSpent = totalSpent;
        this.productId = productId;
        this.change = getChangeAmount(userDeposit);
    }

    private Map<String, Integer> getChangeAmount(BigDecimal userDeposit) {
        List<Integer> coins = List.of(100, 50, 20, 10, 5);
        Map<String, Integer> output = new HashMap<>();
        BigDecimal remaining = userDeposit;
        for (int coin : coins) {
            int coinChange = remaining.divide(BigDecimal.valueOf(coin), RoundingMode.DOWN).intValue();
            output.put(coin + "_cents", coinChange);
            remaining = remaining.subtract(BigDecimal.valueOf(coinChange));
        }
        return output;
    }
}
