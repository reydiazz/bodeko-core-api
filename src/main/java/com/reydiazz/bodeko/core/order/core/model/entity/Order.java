package com.reydiazz.bodeko.core.order.core.model.entity;

import com.reydiazz.bodeko.core.order.core.model.enums.OrderStatus;
import com.reydiazz.bodeko.core.user.store.model.entity.Store;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Builder
@Entity
@Getter
@Table(name = "orders")
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Order {

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "client_email", nullable = false)
    private String clientEmail;

    @Column(name = "client_name", nullable = false)
    private String clientName;

    @Column(name = "total", nullable = false, precision = 10, scale = 2)
    private BigDecimal total;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 50)
    private OrderStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id", nullable = false)
    private Store store;

    @Column(name = "created_at")
    private OffsetDateTime createdAt;

    public void update(String name, String clientEmail, String clientName, BigDecimal total, OrderStatus status) {
        this.name = name;
        this.clientEmail = clientEmail;
        this.clientName = clientName;
        this.total = total;
        this.status = status;
    }

}
