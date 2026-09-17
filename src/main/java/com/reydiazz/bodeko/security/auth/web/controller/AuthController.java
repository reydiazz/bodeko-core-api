package com.reydiazz.bodeko.security.auth.web.controller;


import com.reydiazz.bodeko.security.auth.service.AuthService;
import com.reydiazz.bodeko.security.auth.util.AuthRoutes;
import com.reydiazz.bodeko.security.auth.web.request.LoginRequest;
import com.reydiazz.bodeko.security.auth.web.response.AuthResponse;
import com.reydiazz.bodeko.security.auth.web.response.LoginResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(AuthRoutes.API_BASE)
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping(AuthRoutes.LOGIN)
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest request) {
        LoginResponse response = authService.login(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping(AuthRoutes.ME)
    public ResponseEntity<AuthResponse> me() {
        AuthResponse response = authService.getAuthenticatedUser();
        return ResponseEntity.ok(response);
    }

}