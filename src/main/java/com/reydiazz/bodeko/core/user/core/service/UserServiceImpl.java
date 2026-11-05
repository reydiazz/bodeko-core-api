package com.reydiazz.bodeko.core.user.core.service;

import com.github.f4b6a3.uuid.UuidCreator;
import com.reydiazz.bodeko.core.user.core.exception.UserErrorCode;
import com.reydiazz.bodeko.core.user.core.model.entity.User;
import com.reydiazz.bodeko.core.user.core.model.enums.UserRole;
import com.reydiazz.bodeko.core.user.core.repository.UserRepository;
import com.reydiazz.bodeko.security.auth.web.request.RegisterCustomerRequest;
import com.reydiazz.bodeko.security.auth.web.request.RegisterOwnerRequest;
import com.reydiazz.bodeko.shared.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public User createCustomerEntity(RegisterCustomerRequest request) {
        validateEmailIsAvailable(request.email());
        String passwordHash = passwordEncoder.encode(request.password());
        User user = User.builder()
                .id(UuidCreator.getTimeOrderedEpoch())
                .email(request.email())
                .password(passwordHash)
                .fullName(request.fullName())
                .role(UserRole.CUSTOMER)
                .createdAt(OffsetDateTime.now())
                .build();
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public User createOwnerEntity(RegisterOwnerRequest request) {
        validateEmailIsAvailable(request.email());
        String passwordHash = passwordEncoder.encode(request.password());
        User user = User.builder()
                .id(UuidCreator.getTimeOrderedEpoch())
                .email(request.email())
                .password(passwordHash)
                .fullName(request.fullName())
                .role(UserRole.ADMIN)
                .phoneNumber(request.phoneNumber())
                .createdAt(OffsetDateTime.now())
                .build();
        return userRepository.save(user);
    }

    private void validateEmailIsAvailable(String email) {
        if (userRepository.findByEmail(email).isPresent()) {
            throw new BusinessException(UserErrorCode.EMAIL_ALREADY_IN_USE);
        }
    }

}
