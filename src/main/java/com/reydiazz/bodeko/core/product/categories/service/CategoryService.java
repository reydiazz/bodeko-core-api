package com.reydiazz.bodeko.core.product.categories.service;

import com.reydiazz.bodeko.core.product.categories.entity.Category;
import com.reydiazz.bodeko.core.product.categories.web.request.CreateCategoryRequest;
import com.reydiazz.bodeko.core.product.categories.web.request.UpdateCategoryRequest;
import com.reydiazz.bodeko.core.product.categories.web.response.CategoryResponse;

import java.util.UUID;

public interface CategoryService {

    Category findEntityById(UUID id);

    CategoryResponse create (UUID storeId,CreateCategoryRequest request);

    CategoryResponse update (UUID id, UpdateCategoryRequest request);

    void delete (UUID id);
}
