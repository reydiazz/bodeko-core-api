package com.reydiazz.bodeko.core.product.core.model.entity;


import com.reydiazz.bodeko.core.product.core.model.enums.ProductStatus;
import com.reydiazz.bodeko.core.user.store.model.entity.Store;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Builder
@Entity
@Getter
@Table(name = "products")
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Product {

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description",columnDefinition = "TEXT")
    private String description;

    @Column(name = "price",nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "stock",nullable = false)
    private Integer stock;

    @Column(name = "imagen_url",columnDefinition = "TEXT")
    private String imagenUrl;

    @Enumerated(EnumType.STRING)
    @Column(length = 50)
    private ProductStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id", nullable = false)
    private Store store;

    public  void  update(String name,String description,BigDecimal price,Integer stock) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
    }


}
