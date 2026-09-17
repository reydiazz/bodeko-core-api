package com.reydiazz.bodeko.security.auth.service;

import com.reydiazz.bodeko.core.user.core.model.entity.User;
import com.reydiazz.bodeko.security.auth.component.AuthMapper;
import com.reydiazz.bodeko.security.auth.web.request.LoginRequest;
import com.reydiazz.bodeko.security.auth.web.response.AuthResponse;
import com.reydiazz.bodeko.security.auth.web.response.LoginResponse;
import com.reydiazz.bodeko.security.config.UserPrincipal;
import com.reydiazz.bodeko.security.jwt.JwtService;
import com.reydiazz.bodeko.security.util.SecurityContextFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthMapper authMapper;
    private final JwtService jwtService;
    private final SecurityContextFacade securityContext;
    private final AuthenticationManager authenticationManager;

    @Override
    public LoginResponse login(LoginRequest request) {
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(request.email(), request.password());
        Authentication auth = authenticationManager.authenticate(authToken);
        UserPrincipal userPrincipal = securityContext.extractPrincipal(auth);
        String token = jwtService.generateToken(userPrincipal);
        return authMapper.toLoginResponse(token);
    }

    @Override
    public AuthResponse getAuthenticatedUser() {
        User user = findAuthenticatedUser();
        return authMapper.toResponse(user);
    }

    @Override
    public User findAuthenticatedUser() {
        return securityContext.getCurrentUserEntity();
    }

}