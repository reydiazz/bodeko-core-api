package com.reydiazz.bodeko.core.product.core.service;

import com.github.f4b6a3.uuid.UuidCreator;
import com.reydiazz.bodeko.core.product.categories.entity.Category;
import com.reydiazz.bodeko.core.product.categories.service.CategoryService;
import com.reydiazz.bodeko.core.product.core.component.ProductMapper;
import com.reydiazz.bodeko.core.product.core.exception.ProductNotFoundException;
import com.reydiazz.bodeko.core.product.core.model.entity.Product;
import com.reydiazz.bodeko.core.product.core.model.enums.ProductStatus;
import com.reydiazz.bodeko.core.product.core.repository.ProductRepository;
import com.reydiazz.bodeko.core.product.core.web.request.CreateProductRequest;
import com.reydiazz.bodeko.core.product.core.web.request.UpdateProductRequest;
import com.reydiazz.bodeko.core.product.core.web.response.ProductResponse;
import com.reydiazz.bodeko.core.user.store.model.entity.Store;
import com.reydiazz.bodeko.core.user.store.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    private final CategoryService categoryService;
    private final StoreService storeService;


    @Override
    @Transactional(readOnly = true)
    public Product findEntityById(UUID id) {

        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

    @Override
    @Transactional
    public ProductResponse create(UUID storeId, CreateProductRequest request) {

        Store store = storeService.findEntityById(storeId);
        Category category = categoryService.findEntityById(request.categoryId());
        Product product = Product.builder()
                .id(UuidCreator.getTimeOrderedEpoch())
                .name(request.name())
                .description(request.description())
                .price(request.price())
                .stock(request.stock())
                .status(ProductStatus.AVAILABLE)
                .store(store)
                .category(category)
                .build();
        Product savedProduct =
                productRepository.save(product);
        return productMapper.toResponse(savedProduct);
    }


    @Override
    @Transactional
    public ProductResponse update(UUID id, UpdateProductRequest request) {
        Product product = findEntityById(id);
        Category category = categoryService.findEntityById(request.categoryId());
        product.update(
                request.name(),
                request.description(),
                request.price(),
                request.stock(),
                category
        );
        return productMapper.toResponse(product);
    }

    @Override
    @Transactional
    public void delete(UUID id) {

        Product product = findEntityById(id);

        productRepository.delete(product);
    }
}