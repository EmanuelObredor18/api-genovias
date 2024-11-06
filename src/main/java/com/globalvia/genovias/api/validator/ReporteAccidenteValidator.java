package com.globalvia.genovias.api.validator;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.globalvia.genovias.api.exceptions.EntityFoundException;
import com.globalvia.genovias.api.models.entities.ReporteAccidente;
import com.globalvia.genovias.api.repositories.ReporteAccidenteRepository;

@Component
public class ReporteAccidenteValidator extends Validator<ReporteAccidente, Long> {

  private final ReporteAccidenteRepository repository;

  public ReporteAccidenteValidator(ReporteAccidenteRepository repository) {
    super(repository);
    this.repository = repository;
  }

  @Override
  public void validateUniqueFields(Object... fields) {

    if (fields[0] instanceof LocalDateTime) {
      if (repository.existsByFecha((LocalDateTime) fields[0])) {
        throw new EntityFoundException("Ya existe un reporte de accidente con la fecha dada");  
      }
    }

  }

}
