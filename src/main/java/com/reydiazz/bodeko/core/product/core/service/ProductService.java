package com.reydiazz.bodeko.core.product.core.service;

import com.reydiazz.bodeko.core.product.core.model.entity.Product;
import com.reydiazz.bodeko.core.product.core.web.request.CreateProductRequest;
import com.reydiazz.bodeko.core.product.core.web.request.UpdateProductRequest;

import java.util.UUID;

public interface ProductService {

    Product findEntityById(UUID id);

    Product create (CreateProductRequest request);

    Product update (UUID id, UpdateProductRequest request);

    void delete (UUID id);
}
