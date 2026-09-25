package com.reydiazz.bodeko.core.product.core.service;

import com.reydiazz.bodeko.core.product.core.model.entity.Product;
import com.reydiazz.bodeko.core.product.core.web.request.CreateProductRequest;
import com.reydiazz.bodeko.core.product.core.web.request.UpdateProductRequest;
import com.reydiazz.bodeko.core.product.core.web.response.ProductResponse;

import java.util.UUID;

public interface ProductService {

    Product findEntityById(UUID id);

    ProductResponse create (UUID storeId,CreateProductRequest request);

    ProductResponse update (UUID id, UpdateProductRequest request);

    void delete (UUID id);
}
