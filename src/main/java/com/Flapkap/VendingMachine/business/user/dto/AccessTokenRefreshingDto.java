package com.Flapkap.VendingMachine.business.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AccessTokenRefreshingDto {
    private String accessToken;
    private String refreshToken;
}
