package online.aldomar.api.controller;

import lombok.RequiredArgsConstructor;
import online.aldomar.api.config.JwtTokenUtil;
import online.aldomar.api.dto.AuthResponse;
import online.aldomar.api.dto.LoginRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
  private final AuthenticationManager authManager;
  private final JwtTokenUtil tokenUtil;

  @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
        Authentication auth = authManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                request.getUsername(),
                request.getPassword()
            )
        );

        String token = tokenUtil.generateToken(auth.getName());
        return ResponseEntity.ok(new AuthResponse(token));
    }
}