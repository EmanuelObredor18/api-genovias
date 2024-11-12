package com.globalvia.genovias.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.globalvia.genovias.api.models.dto.CamionetaDTO;
import com.globalvia.genovias.api.models.dto.DireccionDTO;
import com.globalvia.genovias.api.models.dto.ReporteAccidenteDTO;
import com.globalvia.genovias.api.models.dto.ReporteAuxilioVialDTO;
import com.globalvia.genovias.api.models.dto.ReporteDiarioDTO;
import com.globalvia.genovias.api.models.dto.ReporteServicioAmbulanciaDTO;
import com.globalvia.genovias.api.models.dto.ReporteServicioGruaDTO;
import com.globalvia.genovias.api.models.dto.ResponsableDTO;
import com.globalvia.genovias.api.models.dto.SitioDesengancheDTO;
import com.globalvia.genovias.api.models.dto.TipoAccidenteDTO;
import com.globalvia.genovias.api.models.dto.UsuarioConductorDTO;
import com.globalvia.genovias.api.models.dto.VehiculoDTO;
import com.globalvia.genovias.api.models.entities.Camioneta;
import com.globalvia.genovias.api.models.entities.Direccion;
import com.globalvia.genovias.api.models.entities.ReporteAccidente;
import com.globalvia.genovias.api.models.entities.ReporteAuxilioVial;
import com.globalvia.genovias.api.models.entities.ReporteDiario;
import com.globalvia.genovias.api.models.entities.ReporteServicioAmbulancia;
import com.globalvia.genovias.api.models.entities.ReporteServicioGrua;
import com.globalvia.genovias.api.models.entities.Responsable;
import com.globalvia.genovias.api.models.entities.SitioDesenganche;
import com.globalvia.genovias.api.models.entities.TipoAccidente;
import com.globalvia.genovias.api.models.entities.UsuarioConductor;
import com.globalvia.genovias.api.models.entities.Vehiculo;
import com.globalvia.genovias.api.models.factory.EntityFactory;
import com.globalvia.genovias.api.services.base.BaseCrudService;
import com.globalvia.genovias.api.services.base.ReporteBaseCrudService;
import com.globalvia.genovias.api.services.base.interfaces.BaseService;
import com.globalvia.genovias.api.services.dto.DTOProcessService;
import com.globalvia.genovias.api.validator.base.ReporteValidator;

@Configuration
public class BaseServiceConfig {

  @Bean
  BaseService<ReporteAccidente, ReporteAccidenteDTO, Long> reporteAccidenteBaseService(
      EntityFactory<ReporteAccidente, Long> entityFactory,
      DTOProcessService<ReporteAccidente, ReporteAccidenteDTO> dtoProcessService,
      ReporteValidator<ReporteAccidente, Long> validator) {

    return new ReporteBaseCrudService<>(entityFactory, dtoProcessService, validator);
  }

  @Bean
  BaseService<Vehiculo, VehiculoDTO, String> vehiculoBaseService(
      EntityFactory<Vehiculo, String> entityFactory,
      DTOProcessService<Vehiculo, VehiculoDTO> dtoProcessService) {
    return new BaseCrudService<>(entityFactory, dtoProcessService);
  }

  @Bean
  BaseService<SitioDesenganche, SitioDesengancheDTO, Short> sitioDesengancheBaseService(EntityFactory<SitioDesenganche, Short> entityFactory) {
    return new BaseCrudService<>(entityFactory, null);
  }

  @Bean
  BaseService<UsuarioConductor, UsuarioConductorDTO, Long> usuarioConductorBaseService(
      EntityFactory<UsuarioConductor, Long> entityFactory) {
    return new BaseCrudService<>(entityFactory, null);
  }

  // TODO: Agregar procesador de dto
  @Bean
  BaseService<TipoAccidente, TipoAccidenteDTO, Short> tipoAccidenteBaseService(
      EntityFactory<TipoAccidente, Short> entityFactory) {
    return new BaseCrudService<>(entityFactory, null);
  }

  // TODO: Agregar procesador de dto
  @Bean
  BaseService<Camioneta, CamionetaDTO, String> camionetaBaseService(
      EntityFactory<Camioneta, String> entityFactory) {
    return new BaseCrudService<>(entityFactory, null);
  }

  @Bean
  BaseService<Direccion, DireccionDTO, Byte> direccionBaseService(
      EntityFactory<Direccion, Byte> entityFactory) {
    return new BaseCrudService<>(entityFactory, null);
  }

  @Bean
  BaseService<Responsable, ResponsableDTO, Short> responsableBaseService(
      EntityFactory<Responsable, Short> entityFactory) {
    return new BaseCrudService<>(entityFactory, null);
  }

  @Bean
  BaseService<ReporteServicioGrua, ReporteServicioGruaDTO, Long> reporteServicioGruaBaseService(
      EntityFactory<ReporteServicioGrua, Long> entityFactory,
      DTOProcessService<ReporteServicioGrua, ReporteServicioGruaDTO> dtoProcessService,
      ReporteValidator<ReporteServicioGrua, Long> validator) {
    return new ReporteBaseCrudService<>(entityFactory, dtoProcessService, validator);
  }

  @Bean
  BaseService<ReporteServicioAmbulancia, ReporteServicioAmbulanciaDTO, Long> reporteServicioAmbulanciaBaseService(
      EntityFactory<ReporteServicioAmbulancia, Long> entityFactory,
      DTOProcessService<ReporteServicioAmbulancia, ReporteServicioAmbulanciaDTO> dtoProcessService,
      ReporteValidator<ReporteServicioAmbulancia,Long> validator) {
    return new ReporteBaseCrudService<>(entityFactory, dtoProcessService, validator);
  }

  @Bean
  BaseService<ReporteAuxilioVial, ReporteAuxilioVialDTO, Long> reporteAuxilioVialBaseService(
      EntityFactory<ReporteAuxilioVial, Long> entityFactory,
      DTOProcessService<ReporteAuxilioVial, ReporteAuxilioVialDTO> dtoProcessService,
      ReporteValidator<ReporteAuxilioVial, Long> validator) {
    return new ReporteBaseCrudService<>(entityFactory, dtoProcessService, validator);
  }

  @Bean
  BaseService<ReporteDiario, ReporteDiarioDTO, Long> reporteDiarioBaseService(
      EntityFactory<ReporteDiario, Long> entityFactory,
      DTOProcessService<ReporteDiario, ReporteDiarioDTO> dtoProcessService,
      ReporteValidator<ReporteDiario, Long> validator) {
    return new ReporteBaseCrudService<>(entityFactory, dtoProcessService, validator);
  }
}
