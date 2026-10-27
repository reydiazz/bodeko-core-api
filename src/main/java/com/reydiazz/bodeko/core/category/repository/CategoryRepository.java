package com.reydiazz.bodeko.core.category.repository;

import com.reydiazz.bodeko.core.category.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, UUID> {
}
