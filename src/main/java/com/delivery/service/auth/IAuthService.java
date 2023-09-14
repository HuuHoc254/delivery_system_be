package com.delivery.service.auth;

import com.delivery.DTO.login.LoginDTO;
import com.delivery.DTO.register.RegisterDTO;
import org.springframework.http.ResponseEntity;

public interface IAuthService {
    ResponseEntity<?> login(LoginDTO loginDTO);
    ResponseEntity<?> register(RegisterDTO registerDTO);
    ResponseEntity<?> refreshToken(String refreshToken);
    ResponseEntity<?> logout(Long user_id);
}
