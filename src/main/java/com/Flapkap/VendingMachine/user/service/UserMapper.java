package com.Flapkap.VendingMachine.user.service;

import com.Flapkap.VendingMachine.user.dto.LoginDto;
import com.Flapkap.VendingMachine.user.dto.UserDto;
import com.Flapkap.VendingMachine.user.dto.request.StoreUserRequest;
import com.Flapkap.VendingMachine.user.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

//@Mapper
@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User map(StoreUserRequest request);

    List<UserDto> map(List<User> users);

    UserDto map(User user);

}
