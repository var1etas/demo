package com.example.factory.adapter.web.errors;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class JsonControllerAdvice {
    @ExceptionHandler
    public ErrorResponse methodNotAllowed(MethodNotAllowedException ex) {
        return new ErrorResponse(ex.getCode(), ex.getMessage());
    }
}
