package com.Flapkap.VendingMachine.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AccessTokenRefreshingDto {
    private String accessToken;
    private String refreshToken;
}
