package com.globalvia.genovias.api.validator;

import org.springframework.stereotype.Component;

import com.globalvia.genovias.api.models.entities.ReporteServicioAmbulancia;
import com.globalvia.genovias.api.repositories.ReporteServicioAmbulanciaRepository;
import com.globalvia.genovias.api.validator.base.ReporteValidator;

@Component
public class ReporteServicioAmbulanciaValidator extends ReporteValidator<ReporteServicioAmbulancia, Long> {

  public ReporteServicioAmbulanciaValidator(ReporteServicioAmbulanciaRepository repository) {
    super(repository);
  }

  @Override
  public void addCustomValidations(ReporteServicioAmbulancia reporteServicioAmbulancia, boolean isNew) {
    // Aquí puedes agregar validaciones específicas para ReporteServicioAmbulancia si es necesario
  }

  public void buildValidator(ReporteServicioAmbulancia reporteServicioAmbulancia, boolean isNew) {
    super.buildValidator(reporteServicioAmbulancia, reporteServicioAmbulancia.getFecha(), isNew);
  }
}
