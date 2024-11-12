package com.globalvia.genovias.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.globalvia.genovias.api.models.dto.CamionetaDTO;
import com.globalvia.genovias.api.models.dto.DireccionDTO;
import com.globalvia.genovias.api.models.dto.ReporteAccidenteDTO;
import com.globalvia.genovias.api.models.dto.ReporteServicioAmbulanciaDTO;
import com.globalvia.genovias.api.models.dto.ReporteServicioGruaDTO;
import com.globalvia.genovias.api.models.dto.ResponsableDTO;
import com.globalvia.genovias.api.models.dto.TipoAccidenteDTO;
import com.globalvia.genovias.api.models.dto.UsuarioConductorDTO;
import com.globalvia.genovias.api.models.dto.VehiculoDTO;
import com.globalvia.genovias.api.models.entities.Camioneta;
import com.globalvia.genovias.api.models.entities.Direccion;
import com.globalvia.genovias.api.models.entities.ReporteAccidente;
import com.globalvia.genovias.api.models.entities.ReporteServicioAmbulancia;
import com.globalvia.genovias.api.models.entities.ReporteServicioGrua;
import com.globalvia.genovias.api.models.entities.Responsable;
import com.globalvia.genovias.api.models.entities.TipoAccidente;
import com.globalvia.genovias.api.models.entities.UsuarioConductor;
import com.globalvia.genovias.api.models.entities.Vehiculo;
import com.globalvia.genovias.api.models.factory.EntityFactory;
import com.globalvia.genovias.api.services.base.BaseCrudService;
import com.globalvia.genovias.api.services.dto.DTOProcessService;

@Configuration
public class BaseServiceConfig {

  @Bean
  BaseCrudService<ReporteAccidente, ReporteAccidenteDTO, Long> reporteAccidenteBaseService(
      EntityFactory<ReporteAccidente, Long> entityFactory,
      DTOProcessService<ReporteAccidente, ReporteAccidenteDTO> dtoProcessService
  ) {

    return new BaseCrudService<>(entityFactory, dtoProcessService);
  }

  @Bean
  BaseCrudService<Vehiculo, VehiculoDTO, String> vehiculoBaseService (
    EntityFactory<Vehiculo, String> entityFactory,
    DTOProcessService<Vehiculo, VehiculoDTO> dtoProcessService
  ) {
    return new BaseCrudService<>(entityFactory, dtoProcessService);
  }

  @Bean
  BaseCrudService<UsuarioConductor, UsuarioConductorDTO, Long> usuarioConductorBaseService(
    EntityFactory<UsuarioConductor, Long> entityFactory
  ) {
    return new BaseCrudService<>(entityFactory, null);
  }

  // TODO: Agregar procesador de dto
  @Bean
  BaseCrudService<TipoAccidente, TipoAccidenteDTO, Short> tipoAccidenteBaseService(
    EntityFactory<TipoAccidente, Short> entityFactory
  ) {
    return new BaseCrudService<>(entityFactory, null);
  }

  // TODO: Agregar procesador de dto
  @Bean
  BaseCrudService<Camioneta, CamionetaDTO, String> camionetaBaseService(EntityFactory<Camioneta, String> entityFactory) {
    return new BaseCrudService<>(entityFactory, null);
  }

  @Bean
  BaseCrudService<Direccion, DireccionDTO, Byte> direccionBaseService(
    EntityFactory<Direccion, Byte> entityFactory
  ) {
    return new BaseCrudService<>(entityFactory, null);
  }

  @Bean
  BaseCrudService<Responsable, ResponsableDTO, Short> responsableBaseService(EntityFactory<Responsable, Short> entityFactory) {
    return new BaseCrudService<>(entityFactory, null);
  }

  @Bean
  BaseCrudService<ReporteServicioGrua, ReporteServicioGruaDTO, Long> reporteServicioGruaBaseService(EntityFactory<ReporteServicioGrua, Long> entityFactory, DTOProcessService<ReporteServicioGrua, ReporteServicioGruaDTO> dtoProcessService) {
    return new BaseCrudService<>(entityFactory, dtoProcessService);
  }

  @Bean
  BaseCrudService<ReporteServicioAmbulancia, ReporteServicioAmbulanciaDTO, Long> reporteServicioAmbulanciaBaseService(
    EntityFactory<ReporteServicioAmbulancia, Long> entityFactory,
    DTOProcessService<ReporteServicioAmbulancia, ReporteServicioAmbulanciaDTO> dtoProcessService) {
    return new BaseCrudService<>(entityFactory, dtoProcessService);
  }

}
