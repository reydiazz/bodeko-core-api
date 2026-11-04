package com.reydiazz.bodeko.core.user.core.service;

import com.github.f4b6a3.uuid.UuidCreator;
import com.reydiazz.bodeko.core.user.core.component.UserMapper;
import com.reydiazz.bodeko.core.user.core.exception.UserErrorCode;
import com.reydiazz.bodeko.core.user.core.model.entity.User;
import com.reydiazz.bodeko.core.user.core.model.enums.UserDocumentType;
import com.reydiazz.bodeko.core.user.core.model.enums.UserRole;
import com.reydiazz.bodeko.core.user.core.repository.UserRepository;
import com.reydiazz.bodeko.core.user.core.web.request.CreateUserRequest;
import com.reydiazz.bodeko.core.user.core.web.response.UserResponse;
import com.reydiazz.bodeko.shared.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private  final UserMapper userMapper;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public UserResponse create(CreateUserRequest request) {

        validateEmailIsAvailable(request.email());
        validateDocument(request);

        String passwordHash = passwordEncoder.encode(request.password());
        User user = User.builder()
                .id(UuidCreator.getTimeOrderedEpoch())
                .email(request.email())
                .password(passwordHash)
                .fullName(request.fullName())
                .documentType(request.documentType())
                .documentNumber(request.documentNumber())
                .role(UserRole.CUSTOMER)
                .createdAt(OffsetDateTime.now())
                .build();
        User savedUser = userRepository.save(user);
        return userMapper.toResponse(savedUser);
    }

    private void validateEmailIsAvailable(String email) {
        if(userRepository.findByEmail(email).isPresent()){
            throw  new BusinessException(UserErrorCode.EMAIL_ALREADY_IN_USE);
        }
    }

    private void validateDocument(CreateUserRequest request) {
        UserDocumentType type = request.documentType();
        String number = request.documentNumber();

        boolean hasType = type != null;
        boolean hasNumber = number != null && !number.isBlank();

        if (!hasType && !hasNumber) {
            return;
        }

        if (hasType != hasNumber) {
            throw new BusinessException(UserErrorCode.DOCUMENT_INCOMPLETE);
        }

        if (type == UserDocumentType.DNI && !number.matches("\\d{8}")) {
            throw new BusinessException(UserErrorCode.INVALID_DOCUMENT_NUMBER);
        }
    }
}
