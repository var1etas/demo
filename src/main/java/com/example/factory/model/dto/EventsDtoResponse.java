package com.example.factory.model.dto;

import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record EventsDtoResponse(
        String name,
        List<String> events) {
}
