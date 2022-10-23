package com.Flapkap.VendingMachine.user.service;

import com.Flapkap.VendingMachine.user.dto.UserDto;
import com.Flapkap.VendingMachine.user.dto.request.UpdateUserRequest;
import com.Flapkap.VendingMachine.user.entity.User;
import java.math.BigDecimal;
import java.util.List;

public interface UserService {

    User getUserById(Long id) ;
    List<UserDto> listUsers() ;
    void updateUser(Long id,UpdateUserRequest request) ;
    void deleteUser(Long id);

}
