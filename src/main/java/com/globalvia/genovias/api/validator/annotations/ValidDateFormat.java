package com.globalvia.genovias.api.validator.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.globalvia.genovias.api.validator.DateFormatValidator;

@Constraint(validatedBy = DateFormatValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidDateFormat {
    String message() default "Invalid date format. Expected: {pattern}";
    String pattern(); // Formato esperado, e.g., "dd/MM/yyyy"
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
