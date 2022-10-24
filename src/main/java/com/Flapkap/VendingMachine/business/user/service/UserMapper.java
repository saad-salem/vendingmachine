package com.Flapkap.VendingMachine.business.user.service;

import com.Flapkap.VendingMachine.business.user.dto.UserDto;
import com.Flapkap.VendingMachine.business.user.dto.request.StoreUserRequest;
import com.Flapkap.VendingMachine.business.user.entity.User;


import java.util.List;


public interface UserMapper {

    User map(StoreUserRequest request);

    List<UserDto> map(List<User> users);

    UserDto map(User user);

}
