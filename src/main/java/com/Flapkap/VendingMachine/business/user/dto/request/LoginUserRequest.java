package com.Flapkap.VendingMachine.business.user.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

@Validated
@Data
@NoArgsConstructor
public class LoginUserRequest {

    @NotBlank(message = "userName cannot be null")
    private String userName;

    @NotBlank(message = "password cannot be null")
    private String password;

}
