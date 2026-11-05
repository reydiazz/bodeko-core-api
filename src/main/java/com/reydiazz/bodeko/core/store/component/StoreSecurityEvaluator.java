package com.reydiazz.bodeko.core.store.component;

import com.reydiazz.bodeko.core.store.repository.StoreRepository;
import com.reydiazz.bodeko.core.user.core.model.entity.User;
import com.reydiazz.bodeko.security.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component("storeSecurity")
@RequiredArgsConstructor
public class StoreSecurityEvaluator {

    private final StoreRepository storeRepository;
    private final AuthService authService;

    public boolean isOwner(UUID storeId) {
        User currentUser = authService.findAuthenticatedUser();
        return storeRepository.existsByIdAndOwnerId(storeId, currentUser.getId());
    }

}