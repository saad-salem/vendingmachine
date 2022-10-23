package com.Flapkap.VendingMachine.business.user.dto.request;

import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class AccessTokenRefreshingRequest {
    @NotNull
    private String refreshToken;
}
