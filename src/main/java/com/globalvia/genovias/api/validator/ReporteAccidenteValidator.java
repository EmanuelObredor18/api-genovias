package com.globalvia.genovias.api.validator;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.globalvia.genovias.api.exceptions.EntityFoundException;
import com.globalvia.genovias.api.models.entities.Direccion;
import com.globalvia.genovias.api.models.entities.ReporteAccidente;
import com.globalvia.genovias.api.repositories.ReporteAccidenteRepository;
import com.globalvia.genovias.api.validator.base.Validator;

@Component
public class ReporteAccidenteValidator {

  private final ReporteAccidenteRepository repository;
  private final Validator<ReporteAccidente, Long> validator;
  private final Validator<Direccion, Byte> direccionValidator;

  public ReporteAccidenteValidator(
    ReporteAccidenteRepository repository, 
    Validator<ReporteAccidente, Long> validator,
    Validator<Direccion, Byte> direccionValidator) {
    // super(repository);
    this.repository = repository;
    this.validator = validator;
    this.direccionValidator = direccionValidator;
  }

  private void validateFecha(LocalDateTime fecha) {

    if (repository.existsByFecha(fecha)) {
      throw new EntityFoundException("Ya existe un reporte de accidente con la fecha dada");
    }

  }

  public Validator<ReporteAccidente, Long> buildValidator(ReporteAccidente reporteAccidente) {
    return validator
      .addValidation(() -> validateFecha(reporteAccidente.getFecha()))
      .addValidation(() -> direccionValidator.validateExistence(reporteAccidente.getDireccion().getId(), false));
  }

}
