package com.globalvia.genovias.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.globalvia.genovias.api.models.entities.ReporteAccidente;
import com.globalvia.genovias.api.models.entities.ReporteAuxilioVial;
import com.globalvia.genovias.api.models.entities.ReporteDiario;
import com.globalvia.genovias.api.models.entities.ReporteServicioAmbulancia;
import com.globalvia.genovias.api.models.entities.ReporteServicioGrua;
import com.globalvia.genovias.api.repositories.ReporteAccidenteRepository;
import com.globalvia.genovias.api.repositories.ReporteAuxilioVialRepository;
import com.globalvia.genovias.api.repositories.ReporteDiarioRepository;
import com.globalvia.genovias.api.repositories.ReporteServicioAmbulanciaRepository;
import com.globalvia.genovias.api.repositories.ReporteServicioGruaRepository;
import com.globalvia.genovias.api.validator.base.ReporteValidator;

@Configuration
public class ReporteValidatorConfig {
  
  @Bean
  ReporteValidator<ReporteDiario, Long> reporteDiarioValidator(ReporteDiarioRepository repository) {
    return new ReporteValidator<>(repository);
  }
  @Bean
  ReporteValidator<ReporteServicioAmbulancia, Long> reporteAmbulanciaValidator(ReporteServicioAmbulanciaRepository repository) {
    return new ReporteValidator<>(repository);
  }
  
  @Bean
  ReporteValidator<ReporteServicioGrua, Long> reporteServicioGruaValidator(ReporteServicioGruaRepository repository) {
    return new ReporteValidator<>(repository);
  }
  
  @Bean
  ReporteValidator<ReporteAccidente, Long> reporteAccidenteValidator(ReporteAccidenteRepository repository) {
    return new ReporteValidator<>(repository);
  }

  @Bean
  ReporteValidator<ReporteAuxilioVial, Long> reporteAuxilioVialValidator(ReporteAuxilioVialRepository repository) {
    return new ReporteValidator<>(repository);
  }
}
