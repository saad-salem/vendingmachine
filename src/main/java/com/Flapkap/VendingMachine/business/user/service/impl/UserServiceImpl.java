package com.Flapkap.VendingMachine.business.user.service.impl;

import com.Flapkap.VendingMachine.business.user.dto.UserDetailsDto;
import com.Flapkap.VendingMachine.business.user.dto.UserDto;
import com.Flapkap.VendingMachine.business.user.dto.request.UpdateUserRequest;
import com.Flapkap.VendingMachine.business.user.entity.User;
import com.Flapkap.VendingMachine.business.user.exceptions.UserNotFoundException;
import com.Flapkap.VendingMachine.business.user.repo.RefreshTokenRepo;
import com.Flapkap.VendingMachine.business.user.repo.UserRepository;
import com.Flapkap.VendingMachine.business.user.service.UserMapper;
import com.Flapkap.VendingMachine.business.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    @Lazy
    PasswordEncoder passwordEncoder;
    @Autowired
    RefreshTokenRepo refreshTokenRepo;
    @Autowired
    UserMapper userMapper;


    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }


    @Override
    public List<UserDto> listUsers() {
        return userMapper.map(userRepository.findAll());
    }

    @Override
    public void updateUser(Long id, UpdateUserRequest request) {
        User entity = userRepository.findById(id).orElseThrow(UserNotFoundException::new);
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
