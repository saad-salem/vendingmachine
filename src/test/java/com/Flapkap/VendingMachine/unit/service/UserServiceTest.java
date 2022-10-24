package com.Flapkap.VendingMachine.unit.service;

import com.Flapkap.VendingMachine.business.user.dto.UserDto;
import com.Flapkap.VendingMachine.business.user.dto.request.UpdateUserRequest;
import com.Flapkap.VendingMachine.business.user.entity.User;
import com.Flapkap.VendingMachine.business.user.repo.RefreshTokenRepo;
import com.Flapkap.VendingMachine.business.user.repo.UserRepository;
import com.Flapkap.VendingMachine.business.user.service.UserMapper;
import com.Flapkap.VendingMachine.business.user.service.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    private UserRepository userRepository;
    @Mock
    private UserMapper userMapper;
    @InjectMocks
    private UserServiceImpl userService;
    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void whenGivenId_shouldReturnUser_ifFound() {
        User user = new User();
        user.setId(89L);
        Mockito.when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));
        User expected = userService.getUserById(user.getId());
        assertThat(expected).isSameAs(user);
        verify(userRepository).findById(user.getId());
    }
    @Test
    public void shouldReturnAllUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User());
        List<UserDto> Dtos = new ArrayList<>();
        Dtos.add(new UserDto());
        given(userRepository.findAll()).willReturn(users);
        given(userMapper.map(users)).willReturn(Dtos);
        List<UserDto> expected = userService.listUsers();
        assertEquals(expected, Dtos);
        verify(userRepository).findAll();
    }
}
