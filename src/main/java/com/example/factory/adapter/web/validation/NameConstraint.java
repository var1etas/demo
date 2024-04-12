package com.example.factory.adapter.web.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {})
@NotNull(message = "Name must be specified")
@Length(min = 2, message = "Name must have length more than 1 symbol")
public @interface NameConstraint {
    String message() default "Name not available";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
