package com.Flapkap.VendingMachine.unit.service;

import com.Flapkap.VendingMachine.business.user.dto.ResponseWithLongId;
import com.Flapkap.VendingMachine.business.user.dto.request.StoreUserRequest;
import com.Flapkap.VendingMachine.business.user.entity.Role;
import com.Flapkap.VendingMachine.business.user.entity.User;
import com.Flapkap.VendingMachine.business.user.repo.UserRepository;
import com.Flapkap.VendingMachine.business.user.service.impl.AuthServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertNotNull;
@ExtendWith(MockitoExtension.class)
public class AuthServiceTest {
    @Mock
    private UserRepository userRepository;
    @Mock
    private PasswordEncoder passwordEncoder;
    @InjectMocks
    private AuthServiceImpl authService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void whenSaveUser_shouldReturnId() {
        User user=new User();
        user.setId(99L);
        user.setUserName("sa3d01");
        user.setPassword("123456");
        user.setRole(Role.BUYER);

        Mockito.when(userRepository.findByUserName(user.getUserName())).thenReturn(Optional.empty());
        Mockito.when(passwordEncoder.encode(user.getPassword())).thenReturn("123456-dqdq-2342332c-fwrf");
        Mockito.when(userRepository.save(any(User.class))).thenReturn(user);


        StoreUserRequest request=new StoreUserRequest();
        request.setUserName("sa3d01");
        request.setPassword("123456");
        request.setRole("BUYER");

        ResponseWithLongId res = authService.register(request);

        assertNotNull(res.getId());
    }
}
