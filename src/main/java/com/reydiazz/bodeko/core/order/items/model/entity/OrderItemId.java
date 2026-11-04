package com.reydiazz.bodeko.core.order.items.model.entity;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class OrderItemId {

    private UUID orderId;
    private UUID productId;

}
