package com.example.factory.adapter.web.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<EmailConstraint, String> {

    @Override
    public boolean isValid(String name, ConstraintValidatorContext context) {
        return name.contains("@");
    }
}