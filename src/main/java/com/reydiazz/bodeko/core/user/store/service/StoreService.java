package com.reydiazz.bodeko.core.user.store.service;

import com.reydiazz.bodeko.core.user.store.model.entity.Store;
import com.reydiazz.bodeko.core.user.store.web.request.CreateStoreRequest;
import com.reydiazz.bodeko.core.user.store.web.request.UpdateStoreRequest;
import com.reydiazz.bodeko.core.user.store.web.response.StoreResponse;

import java.util.UUID;

public interface StoreService {

    Store findEntityById(UUID id);

    StoreResponse getById(UUID id);

    StoreResponse create(CreateStoreRequest request);

    StoreResponse update(UUID id, UpdateStoreRequest request);
}

