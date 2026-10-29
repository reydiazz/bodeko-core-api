package com.reydiazz.bodeko.core.shopping.cart.repository;

import com.reydiazz.bodeko.core.shopping.cart.model.entity.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, UUID> {
}
