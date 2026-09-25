package com.reydiazz.bodeko.core.product.categories.web.controller;

import com.reydiazz.bodeko.core.product.categories.service.CategoryService;
import com.reydiazz.bodeko.core.product.categories.web.request.CreateCategoryRequest;
import com.reydiazz.bodeko.core.product.categories.web.request.UpdateCategoryRequest;
import com.reydiazz.bodeko.core.product.categories.web.response.CategoryResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping("/store/{storeId}")
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryResponse create(
            @PathVariable UUID storeId,
            @Valid @RequestBody CreateCategoryRequest request
    ) {
        return categoryService.create(storeId, request);
    }

    @PutMapping("/{id}")
    public CategoryResponse update(
            @PathVariable UUID id,
            @Valid @RequestBody UpdateCategoryRequest request
    ) {
        return categoryService.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(
            @PathVariable UUID id
    ) {
        categoryService.delete(id);
    }
}