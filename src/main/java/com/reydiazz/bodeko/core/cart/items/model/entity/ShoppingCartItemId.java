package com.reydiazz.bodeko.core.cart.items.model.entity;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ShoppingCartItemId {

    private UUID cartId;
    private UUID productId;
}
