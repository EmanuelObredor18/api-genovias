package com.globalvia.genovias.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
import com.globalvia.genovias.api.repositories.CamionetaRepository;
import com.globalvia.genovias.api.repositories.DireccionRepository;
import com.globalvia.genovias.api.repositories.ReporteAccidenteRepository;
import com.globalvia.genovias.api.repositories.ReporteAuxilioVialRepository;
import com.globalvia.genovias.api.repositories.ReporteDiarioRepository;
import com.globalvia.genovias.api.repositories.ReporteServicioAmbulanciaRepository;
import com.globalvia.genovias.api.repositories.ReporteServicioGruaRepository;
import com.globalvia.genovias.api.repositories.ResponsableRepository;
import com.globalvia.genovias.api.repositories.SitioDesengancheRepository;
import com.globalvia.genovias.api.repositories.TipoAccidenteRepository;
import com.globalvia.genovias.api.repositories.UsuarioConductorRepository;
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

  @Bean
  EntityFactory<UsuarioConductor, Long> usuarioConductorEntityFactory(UsuarioConductorRepository repository) {
    return new EntityFactory<>(repository, UsuarioConductor.class);
  }

  @Bean
  EntityFactory<TipoAccidente, Short> tipoAccidenteEntityFactory(TipoAccidenteRepository repository) {
    return new EntityFactory<>(repository, TipoAccidente.class);
  }

  @Bean
  EntityFactory<Responsable, Short> responsableEntityFactory(ResponsableRepository repository) {
    return new EntityFactory<>(repository, Responsable.class);
  }

  @Bean
  EntityFactory<Direccion, Byte> direccionEntityFactory(DireccionRepository repository) {
    return new EntityFactory<>(repository, Direccion.class); 
  }

  @Bean
  EntityFactory<ReporteServicioGrua, Long> reporteServicioGruaFactory(ReporteServicioGruaRepository repository) {
    return new EntityFactory<>(repository, ReporteServicioGrua.class);
  }

  @Bean
  EntityFactory<ReporteServicioAmbulancia, Long> reporteServicioAmbulanciaFactory(ReporteServicioAmbulanciaRepository repository) {
    return new EntityFactory<>(repository, ReporteServicioAmbulancia.class);
  }

  @Bean
  EntityFactory<ReporteDiario, Long> reporteDiarioFactory(ReporteDiarioRepository repository) {
    return new EntityFactory<>(repository, ReporteDiario.class);
  }

  @Bean
  EntityFactory<Camioneta, String> camionetaFactory(CamionetaRepository repository) {
    return new EntityFactory<>(repository, Camioneta.class);
  }

  @Bean
  EntityFactory<ReporteAuxilioVial, Long> reporteAuxilioVialFactory(ReporteAuxilioVialRepository repository) {
    return new EntityFactory<>(repository, ReporteAuxilioVial.class);
  }

  @Bean
  EntityFactory<SitioDesenganche, Short> sitioDesenganche(SitioDesengancheRepository repository) {
    return new EntityFactory<>(repository, SitioDesenganche.class);
  }
}
