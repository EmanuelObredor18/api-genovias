package com.globalvia.genovias.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.globalvia.genovias.api.models.entities.Direccion;
import com.globalvia.genovias.api.models.entities.ReporteAccidente;
import com.globalvia.genovias.api.models.entities.UsuarioConductor;
import com.globalvia.genovias.api.models.entities.Vehiculo;
import com.globalvia.genovias.api.repositories.DireccionRepository;
import com.globalvia.genovias.api.repositories.ReporteAccidenteRepository;
import com.globalvia.genovias.api.repositories.UsuarioConductorRepository;
import com.globalvia.genovias.api.repositories.VehiculoRepository;
import com.globalvia.genovias.api.validator.base.Validator;

@Configuration
public class ValidatorConfig {
  @Bean
  Validator<ReporteAccidente, Long> reporteAccidenteBaseValidator(ReporteAccidenteRepository repository) {
    return new Validator<>(repository);
  }

  @Bean
  Validator<Direccion, Byte> direccionBaseValidator(DireccionRepository repository) {
    return new Validator<>(repository);
  }

  @Bean
  Validator<UsuarioConductor, Long> usuarioConductorBaseValidator(UsuarioConductorRepository repository) {
    return new Validator<>(repository);
  }

  @Bean
  Validator<Vehiculo, String> vehiculoBaseValidator(VehiculoRepository repository) {
    return new Validator<>(repository);
  }
}
