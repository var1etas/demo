package com.example.factory.adapter.web.dto;

import com.example.factory.domain.user.UserRole;

import java.util.List;

public record Request(String login,
                      String password,
                      List<UserRole> roles) {
}
