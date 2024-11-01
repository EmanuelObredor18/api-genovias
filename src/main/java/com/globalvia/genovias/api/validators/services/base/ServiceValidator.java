package com.globalvia.genovias.api.validators.services.base;

public interface ServiceValidator<I> {
  void validate(I input, boolean isEditable);
}
