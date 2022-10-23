package com.Flapkap.VendingMachine.user.dto.request;

import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class AccessTokenRefreshingRequest {
    @NotNull
    private String refreshToken;
}
