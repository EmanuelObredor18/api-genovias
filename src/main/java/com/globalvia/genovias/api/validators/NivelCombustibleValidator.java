package com.globalvia.genovias.api.validators;

import com.globalvia.genovias.api.annotations.validation.ValidNivelCombustible;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NivelCombustibleValidator implements ConstraintValidator<ValidNivelCombustible, Integer> {

    private static final Integer[] ALLOWED_VALUES = {25, 50, 75, 100};

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        if (value == null) {
            return true; // @NotNull ya se encarga de verificar si es nulo
        }
        for (Integer allowedValue : ALLOWED_VALUES) {
            if (allowedValue.equals(value)) {
                return true;
            }
        }
        return false;
    }
}
