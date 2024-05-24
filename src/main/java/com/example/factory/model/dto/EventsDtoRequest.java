package com.example.factory.model.dto;


import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record EventsDtoRequest(
        @NotBlank
        String name,
        List<@NotBlank String> events) {
}
