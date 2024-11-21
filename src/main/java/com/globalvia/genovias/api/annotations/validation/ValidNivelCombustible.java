package com.globalvia.genovias.api.annotations.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.globalvia.genovias.api.validators.NivelCombustibleValidator;

@Constraint(validatedBy = NivelCombustibleValidator.class)
@Target({ ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidNivelCombustible {
    String message() default "Nivel de combustible no válido. Debe ser 25, 50, 75 o 100.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

