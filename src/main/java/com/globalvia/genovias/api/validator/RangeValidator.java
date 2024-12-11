package com.globalvia.genovias.api.validator;

import java.util.Set;

import com.globalvia.genovias.api.validator.annotations.Range;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class RangeValidator implements ConstraintValidator<Range, Integer> {
  private final Set<Integer> valoresPermitidos = Set.of(0, 25, 50, 75, 100);

  @Override
  public boolean isValid(Integer value, ConstraintValidatorContext context) {
    if (value == null) {
      return true;
    }
    return valoresPermitidos.contains(value);
  }
}
