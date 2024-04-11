package com.example.factory.model.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.Setter;

import java.util.List;

public record EventsDto(
        @NotBlank
        String name,
        @NotBlank
        List<String> events) {
}
