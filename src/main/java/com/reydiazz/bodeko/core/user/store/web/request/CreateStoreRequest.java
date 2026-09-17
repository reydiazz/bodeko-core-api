package com.reydiazz.bodeko.core.user.store.web.request;

import jakarta.validation.constraints.NotNull;

public record CreateStoreRequest (
        String name,
        String subdomain
){
}
