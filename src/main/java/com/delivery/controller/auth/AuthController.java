package com.delivery.controller.auth;

import com.delivery.DTO.login.LoginDTO;
import com.delivery.DTO.refresh_token.RefreshTokenRequest;
import com.delivery.DTO.register.RegisterDTO;
import com.delivery.service.auth.IAuthService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    private final IAuthService authService;

    public AuthController(IAuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody RegisterDTO registerDTO){
        return authService.register(registerDTO);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login (@RequestBody LoginDTO loginDTO){

        return authService.login(loginDTO);
    }

    @PostMapping("/refresh-token")
    public ResponseEntity<?> refreshToken(@Valid @RequestBody RefreshTokenRequest refreshTokenRequest){
        return authService.refreshToken(refreshTokenRequest.getRefreshToken());
    }

    @GetMapping("/logout/{user_id}")
    public ResponseEntity<?> logout(@Valid @PathVariable Long user_id){

        return authService.logout(user_id);
    }
}
