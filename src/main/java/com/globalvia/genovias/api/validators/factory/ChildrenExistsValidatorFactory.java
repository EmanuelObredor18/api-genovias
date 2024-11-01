package com.globalvia.genovias.api.validators.factory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.globalvia.genovias.api.models.dto.simple.ReporteAccidenteDTO;
import com.globalvia.genovias.api.repositories.DireccionRepository;
import com.globalvia.genovias.api.repositories.ReporteAccidenteRepository;
import com.globalvia.genovias.api.repositories.VehiculoRepository;
import com.globalvia.genovias.api.validators.services.ReporteAccidenteValidator;
import com.globalvia.genovias.api.validators.services.base.ServiceValidator;

@Configuration
public class ChildrenExistsValidatorFactory {

  @Bean
  ServiceValidator<ReporteAccidenteDTO> reporteAccidenteChildrenValidator(DireccionRepository direccionRepository, VehiculoRepository vehiculoRepository, ReporteAccidenteRepository reporteAccidenteRepository) {
    return new ReporteAccidenteValidator(direccionRepository, vehiculoRepository, reporteAccidenteRepository);
  }
  
}