package com.globalvia.genovias.api.validators;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;

@Component
public class CustomValidator {

  @Autowired
  private Validator validator;

  public <T> void validate(T entity) {
    Set<ConstraintViolation<T>> violations = validator.validate(entity);
    if (!violations.isEmpty()) {
      throw new ConstraintViolationException(violations);
    }
  }
}
