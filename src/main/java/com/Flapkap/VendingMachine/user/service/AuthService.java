package com.Flapkap.VendingMachine.user.service;

import com.Flapkap.VendingMachine.user.dto.AccessTokenRefreshingDto;
import com.Flapkap.VendingMachine.user.dto.LoginDto;
import com.Flapkap.VendingMachine.user.dto.ResponseWithLongId;
import com.Flapkap.VendingMachine.user.dto.UserDto;
import com.Flapkap.VendingMachine.user.dto.request.AccessTokenRefreshingRequest;
import com.Flapkap.VendingMachine.user.dto.request.LoginUserRequest;
import com.Flapkap.VendingMachine.user.dto.request.StoreUserRequest;

public interface AuthService {

    ResponseWithLongId register(StoreUserRequest request);
    LoginDto login(LoginUserRequest request);
    AccessTokenRefreshingDto refreshToken(AccessTokenRefreshingRequest request);

}
