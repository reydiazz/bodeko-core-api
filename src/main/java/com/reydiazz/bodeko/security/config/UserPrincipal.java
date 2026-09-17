package com.reydiazz.bodeko.security.config;

import com.reydiazz.bodeko.core.user.core.model.entity.User;
import lombok.NonNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public record UserPrincipal(User user) implements UserDetails {

    @Override
    @NonNull
    public String getUsername() {
        return user.getEmail();
    }

    @Override
    @NonNull
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    @NonNull
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }

    @Override
    public boolean isEnabled() {
        return user.isAccess();
    }

}