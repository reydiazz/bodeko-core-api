package com.reydiazz.bodeko.core.user.store.repository;

import com.reydiazz.bodeko.core.user.store.model.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StoreRepository extends JpaRepository<Store, UUID> {

}
