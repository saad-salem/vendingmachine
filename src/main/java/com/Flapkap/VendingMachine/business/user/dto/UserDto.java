package com.Flapkap.VendingMachine.business.user.dto;

import lombok.*;

import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long id;

    private String userName;

    private String role;

    private BigDecimal deposit;

}

