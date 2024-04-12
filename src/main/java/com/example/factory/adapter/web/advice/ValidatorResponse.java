package com.example.factory.adapter.web.advice;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ValidatorResponse(String error, String field, Object value, String message) {

    public ValidatorResponse {
        if (error == null) error = "Validation error";
    }
}
