package com.reydiazz.bodeko.core.inventory.repository;

import com.reydiazz.bodeko.core.inventory.model.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface InventoryRepository extends JpaRepository<Inventory, UUID> {
}
