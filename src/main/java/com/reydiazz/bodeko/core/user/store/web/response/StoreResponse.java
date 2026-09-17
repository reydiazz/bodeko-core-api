package com.reydiazz.bodeko.core.user.store.web.response;

import java.util.UUID;

public record StoreResponse(
        UUID id,
        String name,
        String subdomain
) {
}
