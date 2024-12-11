package com.globalvia.genovias.api.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import com.globalvia.genovias.api.validator.annotations.ValidTimeFormat;

public class TimeFormatValidator implements ConstraintValidator<ValidTimeFormat, LocalTime> {
  private String pattern;

  @Override
  public void initialize(ValidTimeFormat constraintAnnotation) {
    this.pattern = constraintAnnotation.pattern();
  }

  @Override
  public boolean isValid(LocalTime value, ConstraintValidatorContext context) {
    if (value == null) {
      return true; // Deja que @NotNull maneje la validación de null
    }

    try {
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
      value.format(formatter); // Intenta formatear para validar
      return true;
    } catch (DateTimeParseException e) {
      return false;
    }
  }
}
