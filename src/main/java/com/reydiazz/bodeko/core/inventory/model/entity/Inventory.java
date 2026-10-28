package com.reydiazz.bodeko.core.inventory.model.entity;

import com.reydiazz.bodeko.core.product.model.entity.Product;
import jakarta.persistence.*;
import lombok.*;

import java.time.OffsetDateTime;
import java.util.UUID;

@Builder
@Entity
@Getter
@Table(name = "inventory")
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Inventory {

    @Id
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_id", nullable = false, unique = true)
    private Product product;

    @Builder.Default
    @Column(name = "quantity", nullable = false)
    private int quantity = 0;

    @Builder.Default
    @Column(name = "low_stock_threshold",nullable = false)
    private Integer lowStockThreshold = 5;

    @Column(name = "updated_at",nullable = false,insertable = false,updatable = false)
    private OffsetDateTime updatedAt;

}
