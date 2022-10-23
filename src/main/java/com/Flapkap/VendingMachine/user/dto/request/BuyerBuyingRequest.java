package com.Flapkap.VendingMachine.user.dto.request;

import lombok.Getter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
public class BuyerBuyingRequest {

    @NotNull
    @Positive
    private Long productId;

    @NotNull
    @Positive
    private Integer amount;
}
