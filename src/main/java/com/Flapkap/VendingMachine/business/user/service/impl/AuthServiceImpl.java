package com.Flapkap.VendingMachine.business.user.service.impl;

import com.Flapkap.VendingMachine.business.user.service.UserMapper;
import com.Flapkap.VendingMachine.exception.BadRequestException;
import com.Flapkap.VendingMachine.exception.auth.ExpiredRefreshTokenException;
import com.Flapkap.VendingMachine.exception.auth.RefreshTokenNotFoundException;
import com.Flapkap.VendingMachine.business.user.dto.*;
import com.Flapkap.VendingMachine.business.user.dto.request.AccessTokenRefreshingRequest;
import com.Flapkap.VendingMachine.business.user.dto.request.LoginUserRequest;
import com.Flapkap.VendingMachine.business.user.dto.request.StoreUserRequest;
import com.Flapkap.VendingMachine.business.user.entity.RefreshToken;
import com.Flapkap.VendingMachine.business.user.entity.Role;
import com.Flapkap.VendingMachine.business.user.entity.User;
import com.Flapkap.VendingMachine.business.user.exceptions.UserAlreadyExistException;
import com.Flapkap.VendingMachine.business.user.exceptions.UserNotFoundException;
import com.Flapkap.VendingMachine.business.user.repo.RefreshTokenRepo;
import com.Flapkap.VendingMachine.business.user.repo.UserRepository;
import com.Flapkap.VendingMachine.security.jwt.JwtUtils;
import com.Flapkap.VendingMachine.business.user.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class AuthServiceImpl implements AuthService {
    @Value("${sa3d01.app.jwtRefreshExpirationMs}")
    private Long refreshTokenDurationMs;
    private final RefreshTokenRepo refreshTokenRepo;
    private final JwtUtils jwtUtils;
    private final AuthenticationManager authenticationManager;

    @Autowired
    public AuthServiceImpl(RefreshTokenRepo refreshTokenRepo,
                           JwtUtils jwtUtils,
                           AuthenticationManager authenticationManager) {
        this.refreshTokenRepo = refreshTokenRepo;
        this.jwtUtils = jwtUtils;
        this.authenticationManager = authenticationManager;
    }
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public ResponseWithLongId register(StoreUserRequest request) {
        if (userRepository.findByUserName(request.getUserName()).isPresent()){
            throw new UserAlreadyExistException(request.getUserName());
        }
        if (Arrays.stream(Role.values()).noneMatch(r-> Objects.equals(r.toString(), request.getRole()))){
            throw new BadRequestException("you should choose valid role") ;
        }
        User user = new User();
        user.setUserName( request.getUserName() );
        user.setPassword( request.getPassword() );
        if ( request.getRole() != null ) {
            user.setRole( Enum.valueOf( Role.class, request.getRole() ) );
        }
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        return new ResponseWithLongId(userRepository.save(user).getId());
    }

    @Override
    @Transactional
    public LoginDto login(LoginUserRequest request) {
        if (userRepository.findByUserName(request.getUserName()).isEmpty()) {
            throw new UserNotFoundException(request.getUserName());
        }
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUserName(), request.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetailsDto userDetails = (UserDetailsDto) authentication.getPrincipal();
        String authToken = jwtUtils.generateJwtToken(authentication);
        User user = new User(userDetails.getId());
        refreshTokenRepo.deleteByUserAndExpiryDateBefore(user, LocalDateTime.now());
        RefreshToken refreshToken = getRefreshToken(user);
        return new LoginDto(userDetails.getId(), userDetails.getUsername(), userDetails.getRole().toString(), authToken, refreshToken.getToken());
    }

    private RefreshToken getRefreshToken(User user) {
        List<RefreshToken> refreshTokens = refreshTokenRepo.findByUser(user);
        if (refreshTokens.size() > 0) {
            return refreshTokens.get(0);
        } else {
            return createRefreshToken(user.getId());
        }
    }
    private RefreshToken createRefreshToken(Long userId) {
        RefreshToken refreshToken = new RefreshToken();
        refreshToken.setUser(new User(userId));
        refreshToken.setExpiryDate(LocalDateTime.now().plusSeconds((refreshTokenDurationMs / 1000)));
        refreshToken.setToken(UUID.randomUUID().toString());
        return refreshTokenRepo.save(refreshToken);
    }

    @Override
    public AccessTokenRefreshingDto refreshToken(AccessTokenRefreshingRequest request) {

        String requestRefreshToken = request.getRefreshToken();

        return refreshTokenRepo.findByToken(requestRefreshToken)
                .map(this::verifyExpiration)
                .map(RefreshToken::getUser)
                .map(user -> {
                    String token = jwtUtils.generateTokenFromUsername(user.getUserName());
                    return new AccessTokenRefreshingDto(token, requestRefreshToken);
                })
                .orElseThrow(RefreshTokenNotFoundException::new);
    }

    public RefreshToken verifyExpiration(RefreshToken token) {
        if (token.getExpiryDate().compareTo(LocalDateTime.now()) < 0) {
            refreshTokenRepo.delete(token);
            throw new ExpiredRefreshTokenException();
        }
        return token;
    }
}
