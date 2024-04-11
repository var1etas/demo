package com.example.factory.adapter.web.dto;

import lombok.Setter;

import java.util.Map;

public record Headers(Map<String, String> headers) {
}
