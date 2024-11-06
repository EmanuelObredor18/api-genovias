package com.globalvia.genovias.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.globalvia.genovias.api.models.entities.ReporteAccidente;
import com.globalvia.genovias.api.models.entities.Vehiculo;
import com.globalvia.genovias.api.models.factory.EntityFactory;
import com.globalvia.genovias.api.repositories.ReporteAccidenteRepository;
import com.globalvia.genovias.api.repositories.VehiculoRepository;

@Configuration
public class EntityFactoryConfig {
  
  @Bean
  EntityFactory<Vehiculo, String> vehiculoEntityFactory(VehiculoRepository repository) {
    return new EntityFactory<>(repository, Vehiculo.class);
  }

  @Bean
  EntityFactory<ReporteAccidente, Long> reporteAccidenteEntityFactory(ReporteAccidenteRepository repository) {
    return new EntityFactory<>(repository, ReporteAccidente.class);
  }

}
