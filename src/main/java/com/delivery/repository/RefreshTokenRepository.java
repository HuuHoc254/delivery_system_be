package com.delivery.repository;

import com.delivery.entity.RefreshTokenEntity;
import com.delivery.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshTokenEntity, Long> {
    Optional<RefreshTokenEntity> findByRefreshToken(String refreshToken);

    void deleteByUser(UserEntity user);
    void deleteByRefreshToken(String refreshToken);
}
