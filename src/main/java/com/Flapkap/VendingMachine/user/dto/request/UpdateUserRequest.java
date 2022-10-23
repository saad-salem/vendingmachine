package com.Flapkap.VendingMachine.user.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Validated
@Data
@NoArgsConstructor
public class UpdateUserRequest {

    @NotBlank(message = "userName cannot be null")
    private String userName;

    @NotBlank(message = "password cannot be null")
    private String password;


}
