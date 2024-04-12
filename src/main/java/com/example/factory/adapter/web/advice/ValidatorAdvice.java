package com.example.factory.adapter.web.advice;

import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

@RestControllerAdvice
@RequiredArgsConstructor
public class ValidatorAdvice extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception,
                                                                  HttpHeaders headers,
                                                                  HttpStatusCode status,
                                                                  WebRequest request) {
        List<ValidatorResponse> body = exception.getBindingResult().getFieldErrors().stream()
                .map(error -> new ValidatorResponse(null, error.getField(), error.getRejectedValue(), error.getDefaultMessage())).toList();
        return ResponseEntity.badRequest()
                .body(body);
    }
}