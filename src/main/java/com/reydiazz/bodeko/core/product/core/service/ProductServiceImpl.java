package com.reydiazz.bodeko.core.product.core.service;

import com.reydiazz.bodeko.core.product.core.component.ProductMapper;
import com.reydiazz.bodeko.core.product.core.exception.ProductNotFoundException;
import com.reydiazz.bodeko.core.product.core.model.entity.Product;
import com.reydiazz.bodeko.core.product.core.repository.ProductRepository;
import com.reydiazz.bodeko.core.product.core.web.request.CreateProductRequest;
import com.reydiazz.bodeko.core.product.core.web.request.UpdateProductRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    @Transactional(readOnly = true)
    public Product findEntityById (UUID id){
        return productRepository.findById(id).
                orElseThrow(() -> new ProductNotFoundException(id));
    }

    @Override
    @Transactional
    public Product create(CreateProductRequest request) {

        return null;
    }

    @Override
    public Product update(UUID id, UpdateProductRequest request) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }
}
