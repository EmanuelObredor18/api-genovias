package com.globalvia.genovias.api.validator.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.globalvia.genovias.api.validator.RangeValidator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = RangeValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface Range {
  String message() default "El valor debe ser uno de los siguientes: 0, 25, 50, 75, 100.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
