package com.example.factory.adapter.web.dto;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public record Response(String login,
                       Collection<? extends GrantedAuthority> roles) {
}
