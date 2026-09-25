package com.reydiazz.bodeko.core.product.categories.service;

import com.github.f4b6a3.uuid.UuidCreator;
import com.reydiazz.bodeko.core.product.categories.component.CategoryMapper;
import com.reydiazz.bodeko.core.product.categories.entity.Category;
import com.reydiazz.bodeko.core.product.categories.exception.CategoryNotFoundException;
import com.reydiazz.bodeko.core.product.categories.repository.CategoryRepository;
import com.reydiazz.bodeko.core.product.categories.web.request.CreateCategoryRequest;
import com.reydiazz.bodeko.core.product.categories.web.request.UpdateCategoryRequest;
import com.reydiazz.bodeko.core.product.categories.web.response.CategoryResponse;
import com.reydiazz.bodeko.core.user.store.model.entity.Store;
import com.reydiazz.bodeko.core.user.store.service.StoreService;
import com.reydiazz.bodeko.security.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService  {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    private final StoreService storeService;

    @Override
    @Transactional(readOnly = true)
    public Category findEntityById(UUID id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException(id));
    }

    @Override
    @Transactional
    public CategoryResponse create(UUID storeId,CreateCategoryRequest request) {
        Store store = storeService.findEntityById(storeId);
        Category category = Category.builder()
                .id(UuidCreator.getTimeOrderedEpoch())
                .name(request.name())
                .store(store)
                .build();
        Category savedCategory = categoryRepository.save(category);
        return categoryMapper.toResponse(savedCategory);
    }

    @Override
    @Transactional
    public CategoryResponse update(UUID id, UpdateCategoryRequest request) {

        Category category = findEntityById(id);

        category.update(
                request.name()
        );
        return categoryMapper.toResponse(category);
    }

    @Override
    public void delete(UUID id) {
        Category category = findEntityById(id);

        categoryRepository.delete(category);

    }
}
