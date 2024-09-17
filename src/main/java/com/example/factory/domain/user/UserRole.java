package com.example.factory.domain.user;

import org.springframework.security.core.GrantedAuthority;

public enum UserRole implements GrantedAuthority {
    ROLE_ADMIN,
    ROLE_SUPPORT;

    @Override
    public String getAuthority() {
        return this.name();
    }
}
