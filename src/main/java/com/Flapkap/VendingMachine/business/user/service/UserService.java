package com.Flapkap.VendingMachine.business.user.service;

import com.Flapkap.VendingMachine.business.user.dto.UserDto;
import com.Flapkap.VendingMachine.business.user.dto.request.UpdateUserRequest;
import com.Flapkap.VendingMachine.business.user.entity.User;

import java.util.List;

public interface UserService {

    User getUserById(Long id) ;
    List<UserDto> listUsers() ;
    void updateUser(Long id,UpdateUserRequest request) ;
    void deleteUser(Long id);

}
