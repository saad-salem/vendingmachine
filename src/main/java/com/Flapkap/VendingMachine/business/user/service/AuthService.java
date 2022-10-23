package com.Flapkap.VendingMachine.business.user.service;

import com.Flapkap.VendingMachine.business.user.dto.AccessTokenRefreshingDto;
import com.Flapkap.VendingMachine.business.user.dto.LoginDto;
import com.Flapkap.VendingMachine.business.user.dto.ResponseWithLongId;
import com.Flapkap.VendingMachine.business.user.dto.request.AccessTokenRefreshingRequest;
import com.Flapkap.VendingMachine.business.user.dto.request.LoginUserRequest;
import com.Flapkap.VendingMachine.business.user.dto.request.StoreUserRequest;

public interface AuthService {

    ResponseWithLongId register(StoreUserRequest request);
    LoginDto login(LoginUserRequest request);
    AccessTokenRefreshingDto refreshToken(AccessTokenRefreshingRequest request);

}
