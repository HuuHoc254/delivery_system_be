package com.delivery.security.impl;

import com.delivery.entity.UserEntity;
import com.delivery.repository.RefreshTokenRepository;
import com.delivery.repository.UserRepository;
import com.delivery.util.JWTProvider;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Service
public class LogoutHandlerImpl implements LogoutHandler {
    private final UserRepository userRepository;
    private final RefreshTokenRepository refreshTokenRepository;
    private final JWTProvider jwtProvider;

    public LogoutHandlerImpl(UserRepository userRepository,
                             RefreshTokenRepository refreshTokenRepository,
                             JWTProvider jwtProvider) {
        this.userRepository = userRepository;
        this.refreshTokenRepository = refreshTokenRepository;
        this.jwtProvider = jwtProvider;
    }

    @Override
    @Transactional
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        String userName = jwtProvider.getUserNameFromJwtToken(parseJwt(request));
        UserEntity userEntity = userRepository.findByUserName(userName)
                .orElseThrow(() -> new RuntimeException("User not found"));
        refreshTokenRepository.deleteByUser(userEntity);
        SecurityContextHolder.clearContext();
    }

    private String parseJwt(HttpServletRequest request) {
        String headerAuth = request.getHeader("Authorization");

        if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer ")) {
            return headerAuth.substring(7);
        }

        return null;
    }
}
