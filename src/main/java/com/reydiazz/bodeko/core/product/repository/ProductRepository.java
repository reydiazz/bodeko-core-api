package com.reydiazz.bodeko.core.product.repository;

import com.reydiazz.bodeko.core.product.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
}
