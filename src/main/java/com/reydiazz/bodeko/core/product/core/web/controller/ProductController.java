package com.reydiazz.bodeko.core.product.core.web.controller;

import com.reydiazz.bodeko.core.product.core.service.ProductService;
import com.reydiazz.bodeko.core.product.core.web.request.CreateProductRequest;
import com.reydiazz.bodeko.core.product.core.web.request.UpdateProductRequest;
import com.reydiazz.bodeko.core.product.core.web.response.ProductResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/store/{storeId}")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse create(
            @PathVariable UUID storeId,
            @Valid @RequestBody CreateProductRequest request
    ) {
        return productService.create(storeId, request);
    }

    @PutMapping("/{id}")
    public ProductResponse update(
            @PathVariable UUID id,
            @Valid @RequestBody UpdateProductRequest request
    ) {
        return productService.update(id, request);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(
            @PathVariable UUID id
    ) {
        productService.delete(id);
    }
}