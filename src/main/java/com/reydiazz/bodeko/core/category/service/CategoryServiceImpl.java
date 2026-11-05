package com.reydiazz.bodeko.core.category.service;

import com.github.f4b6a3.uuid.UuidCreator;
import com.reydiazz.bodeko.core.category.component.CategoryMapper;
import com.reydiazz.bodeko.core.category.exception.CategoryNameExistsException;
import com.reydiazz.bodeko.core.category.exception.CategoryNotFoundException;
import com.reydiazz.bodeko.core.category.model.Category;
import com.reydiazz.bodeko.core.category.repository.CategoryRepository;
import com.reydiazz.bodeko.core.category.web.request.CreateCategoryRequest;
import com.reydiazz.bodeko.core.category.web.request.EditCategoryRequest;
import com.reydiazz.bodeko.core.category.web.response.CategoryResponse;
import com.reydiazz.bodeko.core.store.model.entity.Store;
import com.reydiazz.bodeko.core.store.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    private final StoreService storeService;

    @Transactional(readOnly = true)
    public List<CategoryResponse> getAll(UUID storeId) {
        return categoryRepository.findAllByStoreId(storeId).stream()
                .map(categoryMapper::toResponse)
                .toList();
    }

    @Override
    @Transactional
    public CategoryResponse create(UUID storeId, CreateCategoryRequest request) {
        String sanitizedName = request.name().trim();
        verifyName(storeId, sanitizedName);
        Store store = storeService.getReferenceById(storeId);
        Category category = Category.builder()
                .id(UuidCreator.getTimeOrderedEpoch())
                .store(store)
                .name(sanitizedName)
                .build();
        Category categorySaved = categoryRepository.save(category);
        return categoryMapper.toResponse(categorySaved);
    }

    @Override
    @Transactional
    public CategoryResponse update(UUID id, UUID storeId, EditCategoryRequest request) {
        String sanitizedName = request.name().trim();
        verifyName(id, storeId, sanitizedName);
        Category category = findEntityById(storeId, id);
        category.update(sanitizedName);
        return categoryMapper.toResponse(category);
    }

    @Override
    @Transactional
    public void delete(UUID id, UUID storeId) {
        Category category = findEntityById(storeId,id);
        categoryRepository.delete(category);
    }

    @Override
    @Transactional(readOnly = true)
    public Category findEntityById(UUID storeId, UUID categoryId) {
        return categoryRepository.findByIdAndStoreId(categoryId, storeId)
                .orElseThrow(CategoryNotFoundException::new);
    }

    private void verifyName(UUID storeId, String name) {
        if (categoryRepository.existsByStoreIdAndNameIgnoreCase(storeId, name)) {
            throw new CategoryNameExistsException();
        }
    }

    private void verifyName(UUID categoryId, UUID storeId, String name) {
        if (categoryRepository.existsByStoreIdAndNameIgnoreCaseAndIdNot(storeId, name, categoryId)) {
            throw new CategoryNameExistsException();
        }
    }
}
