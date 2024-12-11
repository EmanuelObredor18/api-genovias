package com.globalvia.genovias.api.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import com.globalvia.genovias.api.validator.annotations.ValidDateFormat;

public class DateFormatValidator implements ConstraintValidator<ValidDateFormat, LocalDate> {
  private String pattern;

  @Override
  public void initialize(ValidDateFormat constraintAnnotation) {
    this.pattern = constraintAnnotation.pattern();
  }

  @Override
  public boolean isValid(LocalDate value, ConstraintValidatorContext context) {
    if (value == null) {
      return true;
    }

    try {
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
      value.format(formatter);
      return true;
    } catch (DateTimeParseException e) {
      return false;
    }
  }
}
