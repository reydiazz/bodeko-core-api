package com.reydiazz.bodeko.core.product.categories.component;

import com.reydiazz.bodeko.core.product.categories.entity.Category;
import com.reydiazz.bodeko.core.product.categories.web.response.CategoryResponse;

public class CategoryMapper {

    public CategoryResponse toResponse (Category category) {
        return new CategoryResponse(
                category.getId(),
                category.getName()
        );
    }
}
