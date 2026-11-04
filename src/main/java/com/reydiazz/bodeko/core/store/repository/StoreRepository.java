package com.reydiazz.bodeko.core.store.repository;

import com.reydiazz.bodeko.core.store.model.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StoreRepository extends JpaRepository<Store, UUID> {
}
