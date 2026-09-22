package com.reydiazz.bodeko.core.user.store.service;

import com.github.f4b6a3.uuid.UuidCreator;
import com.reydiazz.bodeko.core.user.core.model.entity.User;
import com.reydiazz.bodeko.core.user.store.component.StoreMapper;
import com.reydiazz.bodeko.core.user.store.exception.StoreNotFoundException;
import com.reydiazz.bodeko.core.user.store.model.entity.Store;
import com.reydiazz.bodeko.core.user.store.repository.StoreRepository;
import com.reydiazz.bodeko.core.user.store.web.request.CreateStoreRequest;
import com.reydiazz.bodeko.core.user.store.web.request.UpdateStoreRequest;
import com.reydiazz.bodeko.core.user.store.web.response.StoreResponse;
import com.reydiazz.bodeko.security.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StoreServiceImpl implements StoreService {

    private final StoreRepository storeRepository;
    private final StoreMapper storeMapper;
    private final AuthService authService;

    @Override
    @Transactional(readOnly = true)
    public Store findEntityById(UUID id) {
        return storeRepository.findById(id)
                .orElseThrow(() -> new StoreNotFoundException(id));
    }

    @Override
    @Transactional(readOnly = true)
    public StoreResponse getById(UUID id) {
        Store store = findEntityById(id);

        return storeMapper.toResponse(store);
    }

    @Override
    @Transactional
    public StoreResponse create(CreateStoreRequest request) {

        User user = authService.findAuthenticatedUser();

        Store store = Store.builder()
                .id(UuidCreator.getTimeOrderedEpoch())
                .name(request.name())
                .user(user)
                .build();

        Store savedStore = storeRepository.save(store);

        return storeMapper.toResponse(savedStore);
    }

    @Override
    @Transactional
    public StoreResponse update(UUID id, UpdateStoreRequest request) {

        Store store = findEntityById(id);

        store.update(
                request.name()
        );

        return storeMapper.toResponse(store);
    }
}

