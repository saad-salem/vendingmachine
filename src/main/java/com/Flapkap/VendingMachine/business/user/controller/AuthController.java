package com.Flapkap.VendingMachine.business.user.controller;

import com.Flapkap.VendingMachine.business.user.dto.AccessTokenRefreshingDto;
import com.Flapkap.VendingMachine.business.user.dto.LoginDto;
import com.Flapkap.VendingMachine.business.user.dto.ResponseWithLongId;
import com.Flapkap.VendingMachine.business.user.dto.request.AccessTokenRefreshingRequest;
import com.Flapkap.VendingMachine.business.user.dto.request.LoginUserRequest;
import com.Flapkap.VendingMachine.business.user.dto.request.StoreUserRequest;
import com.Flapkap.VendingMachine.business.user.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    @Autowired
    AuthService authService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseWithLongId register(@Validated @RequestBody StoreUserRequest request) {
        return authService.register(request);
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public LoginDto login(@Validated @RequestBody LoginUserRequest request) {
        return authService.login(request);
    }


    @PostMapping("/refresh-token")
    @ResponseStatus(HttpStatus.OK)
    public AccessTokenRefreshingDto refreshToken(@Validated @RequestBody AccessTokenRefreshingRequest request) {
        return authService.refreshToken(request);
    }
}
