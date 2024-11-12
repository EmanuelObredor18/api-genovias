package com.globalvia.genovias.api.validator;

import org.springframework.stereotype.Component;

import com.globalvia.genovias.api.models.entities.ReporteAccidente;
import com.globalvia.genovias.api.repositories.ReporteAccidenteRepository;
import com.globalvia.genovias.api.validator.base.ReporteValidator;

@Component
public class ReporteAccidenteValidator extends ReporteValidator<ReporteAccidente, Long> {

  public ReporteAccidenteValidator(ReporteAccidenteRepository repository) {
    super(repository);
  }

  @Override
  public void addCustomValidations(ReporteAccidente reporteAccidente, boolean isNew) {
    // Aquí puedes agregar validaciones específicas para ReporteAccidente si es necesario
  }

  public void buildValidator(ReporteAccidente reporteAccidente, boolean isNew) {
    super.buildValidator(reporteAccidente, reporteAccidente.getFecha(), isNew);
  }
}
