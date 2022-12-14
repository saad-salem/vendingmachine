package com.Flapkap.VendingMachine.business.user.dto.request;

import lombok.Data;
import lombok.Getter;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

@Validated
@Data
@Getter
public class StoreUserRequest {

    @NotBlank(message = "userName cannot be null")
    private String userName;

    @NotBlank(message = "password cannot be null")
    private String password;

    @NotBlank(message = "role cannot be null")
    private String role;
}
