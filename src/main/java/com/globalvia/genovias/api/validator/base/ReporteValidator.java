package com.globalvia.genovias.api.validator.base;

import java.time.LocalDate;
import java.time.LocalTime;

import com.globalvia.genovias.api.exceptions.EntityFoundException;
import com.globalvia.genovias.api.repositories.ReporteRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ReporteValidator<E, ID> extends Validator {

  private final ReporteRepository<E, ID> repository;

  public void validateFecha(LocalDate fecha, LocalTime hora) {
    if (repository.existsByFechaAndHora(fecha, hora)) {
      throw new EntityFoundException("Ya existe un reporte con la fecha dada");
    }
  }


}
