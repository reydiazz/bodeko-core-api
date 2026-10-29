package com.reydiazz.bodeko.core.cart.items.repository;

import com.reydiazz.bodeko.core.cart.items.model.entity.ShoppingCartItem;
import com.reydiazz.bodeko.core.cart.items.model.entity.ShoppingCartItemId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartItemRepository extends JpaRepository<ShoppingCartItem, ShoppingCartItemId> {
}
