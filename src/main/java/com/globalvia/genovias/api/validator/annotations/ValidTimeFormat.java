package com.globalvia.genovias.api.validator.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.globalvia.genovias.api.validator.TimeFormatValidator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = TimeFormatValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidTimeFormat {
    String message() default "Invalid time format. Expected: {pattern}";
    String pattern(); 
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
