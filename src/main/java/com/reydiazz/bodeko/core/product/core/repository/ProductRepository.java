package com.reydiazz.bodeko.core.product.core.repository;

import com.reydiazz.bodeko.core.product.core.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
}
