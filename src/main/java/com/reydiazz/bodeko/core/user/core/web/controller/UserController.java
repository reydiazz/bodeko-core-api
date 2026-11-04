package com.reydiazz.bodeko.core.user.core.web.controller;

import com.reydiazz.bodeko.core.user.core.service.UserService;
import com.reydiazz.bodeko.core.user.core.web.request.CreateUserRequest;
import com.reydiazz.bodeko.core.user.core.web.response.UserResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponse> create(@RequestBody @Valid CreateUserRequest request) {
        UserResponse userResponse = userService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponse);
    }

}

