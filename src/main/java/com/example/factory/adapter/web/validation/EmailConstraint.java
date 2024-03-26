package com.example.factory.adapter.web.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EmailValidator.class)
@Target(ElementType.FIELD)
public @interface EmailConstraint {

    String message() default "Email must have '@' inside";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
