package com.example.factory.adapter.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Order(
        @JsonProperty("id") Long orderId,
        String composite) {
}
