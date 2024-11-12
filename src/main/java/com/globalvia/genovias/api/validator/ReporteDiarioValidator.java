package com.globalvia.genovias.api.validator;

import org.springframework.stereotype.Service;

import com.globalvia.genovias.api.models.entities.ReporteDiario;
import com.globalvia.genovias.api.repositories.ReporteDiarioRepository;
import com.globalvia.genovias.api.validator.base.ReporteValidator;

@Service
public class ReporteDiarioValidator extends ReporteValidator<ReporteDiario, Long> {

  public ReporteDiarioValidator(ReporteDiarioRepository repository) {
    super(repository);
  }

  @Override
  protected void addCustomValidations(ReporteDiario entity, boolean isNew) {}
  
  public void buildValidator(ReporteDiario reporteDiario, boolean isNew) {
    super.buildValidator(reporteDiario, reporteDiario.getFecha(), isNew);
  }
}
