package com.globalvia.genovias.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.globalvia.genovias.api.models.dto.ReporteAccidenteDTO;
import com.globalvia.genovias.api.models.dto.VehiculoDTO;
import com.globalvia.genovias.api.models.entities.ReporteAccidente;
import com.globalvia.genovias.api.models.entities.Vehiculo;
import com.globalvia.genovias.api.models.factory.EntityFactory;
import com.globalvia.genovias.api.services.BaseService;
import com.globalvia.genovias.api.services.dto.DTOProcessService;
import com.globalvia.genovias.api.validator.base.Validator;

@Configuration
public class BaseServiceConfig {

  @Bean
  BaseService<ReporteAccidente, ReporteAccidenteDTO, Long> reporteAccidenteBaseService(
      EntityFactory<ReporteAccidente, Long> entityFactory,
      DTOProcessService<ReporteAccidente, ReporteAccidenteDTO> dtoProcessService,
      Validator<ReporteAccidente, Long> validator) {

    return new BaseService<>(entityFactory, dtoProcessService, validator);
  }

  @Bean
  BaseService<Vehiculo, VehiculoDTO, String> vehiculoBaseService (
    EntityFactory<Vehiculo, String> entityFactory,
    DTOProcessService<Vehiculo, VehiculoDTO> dtoProcessService,
    Validator<Vehiculo, String> validator
  ) {
    return new BaseService<>(entityFactory, dtoProcessService, validator);
  }
}
