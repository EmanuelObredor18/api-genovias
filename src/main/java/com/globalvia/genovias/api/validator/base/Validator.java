package com.globalvia.genovias.api.validator.base;

import java.util.LinkedList;
import java.util.List;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
// TODO: Refactorizar para evitar la repetición
public class Validator {

  private final List<VoidCallback> validators = new LinkedList<>();

  public final void validate() {
    validators.forEach(callBack -> callBack.apply());
  };

  public void validateUniqueFields(Object... fields) {}

  public Validator addValidation(VoidCallback callback) {
    validators.add(callback);
    return this;
  }
}
