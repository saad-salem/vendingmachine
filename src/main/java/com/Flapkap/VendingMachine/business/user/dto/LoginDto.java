package com.Flapkap.VendingMachine.business.user.dto;

import lombok.*;

@Setter
@Getter
//@AllArgsConstructor
public class LoginDto {
    private Long id;
    private String userName;
    private String role;
    private String accessToken;
    private String refreshToken;

    public LoginDto(Long id,String userName,String role,String accessToken,String refreshToken) {
        this.id=id;
        this.userName=userName;
        this.role=role;
        this.accessToken=accessToken;
        this.refreshToken=refreshToken;
    }
}

