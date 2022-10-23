package com.Flapkap.VendingMachine.user.service.impl;

import com.Flapkap.VendingMachine.config.exception.BadRequestException;
import com.Flapkap.VendingMachine.config.exception.BaseException;
import com.Flapkap.VendingMachine.user.dto.ResponseWithLongId;
import com.Flapkap.VendingMachine.user.dto.UserDetailsDto;
import com.Flapkap.VendingMachine.user.dto.UserDto;
import com.Flapkap.VendingMachine.user.dto.request.StoreUserRequest;
import com.Flapkap.VendingMachine.user.dto.request.UpdateUserRequest;
import com.Flapkap.VendingMachine.user.entity.Role;
import com.Flapkap.VendingMachine.user.entity.User;
import com.Flapkap.VendingMachine.user.exceptions.UserAlreadyExistException;
import com.Flapkap.VendingMachine.user.exceptions.UserNotFoundException;
import com.Flapkap.VendingMachine.user.repo.RefreshTokenRepo;
import com.Flapkap.VendingMachine.user.repo.UserRepository;
import com.Flapkap.VendingMachine.user.service.UserMapper;
import com.Flapkap.VendingMachine.user.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Autowired @Lazy
    PasswordEncoder passwordEncoder;
    @Autowired
    RefreshTokenRepo refreshTokenRepo;
    @Autowired
    UserMapper userMapper ;

    public boolean isUserNameUnique(String userName){
        Optional<User> userWithUserName=userRepository.findByUserName(userName);
        return userWithUserName.isEmpty();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }


    @Override
    public List<UserDto> listUsers() {
        return userMapper.map(userRepository.findAll());
    }

    @Override
    public void updateUser(Long id,UpdateUserRequest request) {
        User entity=userRepository.findById(id).orElseThrow(UserNotFoundException::new);
        entity.setUserName(request.getUserName());
        entity.setPassword(request.getPassword());
        userRepository.save(entity);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User entity = userRepository.findByUserName(username).orElseThrow(UserNotFoundException::new);
        return new UserDetailsDto(entity);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        userRepository.findById(id).orElseThrow(UserNotFoundException::new);
        refreshTokenRepo.deleteByUserId(id);
        userRepository.deleteById(id);
    }
}
