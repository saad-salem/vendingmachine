package com.Flapkap.VendingMachine.user.repo;

import com.Flapkap.VendingMachine.user.entity.RefreshToken;
import com.Flapkap.VendingMachine.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface RefreshTokenRepo extends JpaRepository<RefreshToken, Long> {
    Optional<RefreshToken> findByToken(String token);

    List<RefreshToken> findByUser(User user);

    void deleteByUserAndExpiryDateBefore(User user, LocalDateTime expiryDate);

    void deleteByUserId(Long userId);
}
