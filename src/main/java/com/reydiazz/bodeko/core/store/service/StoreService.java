package com.reydiazz.bodeko.core.store.service;

import com.reydiazz.bodeko.core.store.model.entity.Store;

import java.util.UUID;

public interface StoreService {

    Store getReferenceById(UUID id);
}
