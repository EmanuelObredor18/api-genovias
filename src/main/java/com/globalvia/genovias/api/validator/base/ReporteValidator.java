package com.globalvia.genovias.api.validator.base;

import java.time.LocalDateTime;

import com.globalvia.genovias.api.exceptions.EntityFoundException;
import com.globalvia.genovias.api.repositories.ReporteRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class ReporteValidator<E, ID> extends Validator {

  private final ReporteRepository<E, ID> repository;

  public void validateFecha(LocalDateTime fecha) {
    if (repository.existsByFecha(fecha)) {
      throw new EntityFoundException("Ya existe un reporte con la fecha dada");
    }
  }

  // Método generalizado para construir la validación, se puede sobrescribir para casos específicos
  public void buildValidator(E entity, LocalDateTime fecha, boolean isNew) {
    if (isNew) {
      addValidation(() -> validateFecha(fecha)).validate();
    }
  }

  // Método abstracto para agregar validaciones específicas de cada entidad
  protected abstract void addCustomValidations(E entity, boolean isNew);
}
