package com.Flapkap.VendingMachine.business.user.service.impl;

import com.Flapkap.VendingMachine.business.user.dto.UserDto;
import com.Flapkap.VendingMachine.business.user.dto.request.StoreUserRequest;
import com.Flapkap.VendingMachine.business.user.entity.Role;
import com.Flapkap.VendingMachine.business.user.entity.User;
import com.Flapkap.VendingMachine.business.user.service.UserMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapperImpl implements UserMapper {
    @Override
    public User map(StoreUserRequest request) {
        if ( request == null ) {
            return null;
        }
        User user = new User();
        user.setUserName( request.getUserName() );
        user.setPassword( request.getPassword() );
        if ( request.getRole() != null ) {
            user.setRole( Enum.valueOf( Role.class, request.getRole() ) );
        }
        return user;
    }

    @Override
    public List<UserDto> map(List<User> users) {
        if ( users == null ) {
            return null;
        }
        List<UserDto> list = new ArrayList<UserDto>( users.size() );
        for ( User user : users ) {
            list.add( map( user ) );
        }
        return list;
    }

    @Override
    public UserDto map(User user) {
        if ( user == null ) {
            return null;
        }
        UserDto res=new UserDto();
        res.setId(user.getId());
        res.setUserName(user.getUserName());
        res.setRole( user.getRole().toString());
        res.setDeposit( user.getDeposit());
        return res;
    }


}
