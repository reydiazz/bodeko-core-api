package com.reydiazz.bodeko.core.product.model.entity;

import com.reydiazz.bodeko.core.category.model.Category;
import com.reydiazz.bodeko.core.product.model.enums.ProductStatus;
import com.reydiazz.bodeko.core.store.model.entity.Store;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Builder
@Entity
@Getter
@Table(
        name = "products",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uq_products_id_store",
                        columnNames = {"id", "store_id"}
                )
        }
)
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Product {

    @Id
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "store_id", nullable = false)
    private Store store;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(
                    name = "category_id",
                    referencedColumnName = "id"
            ),
            @JoinColumn(
                    name = "store_id",
                    referencedColumnName = "store_id",
                    insertable = false,
                    updatable = false
            )
    })
    private Category category;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "base_price",nullable = false)
    private BigDecimal basePrice;

    @Column(name = "imagen_url",nullable = false)
    private String imageUrl;

    @Builder.Default
    @Column(name = "is_tax_exempt", nullable = false)
    private boolean isTaxExempt = false;

    @Builder.Default
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private ProductStatus status = ProductStatus.DRAFT;

    @Column(name = "created_at", nullable = false, updatable = false, insertable = false)
    private OffsetDateTime createdAt;

}
