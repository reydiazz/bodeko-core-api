package com.reydiazz.bodeko.security.auth.web.response;

import java.time.OffsetDateTime;
import java.util.UUID;

public record AuthResponse(
        UUID id,
        String name,
        String email,
        OffsetDateTime subscriptionLimit
) {
}
