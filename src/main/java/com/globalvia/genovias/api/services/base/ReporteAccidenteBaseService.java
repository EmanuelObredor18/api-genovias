package com.globalvia.genovias.api.services.base;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.globalvia.genovias.api.models.dto.ReporteAccidenteDTO;
import com.globalvia.genovias.api.models.entities.ReporteAccidente;
import com.globalvia.genovias.api.models.entities.Vehiculo;
import com.globalvia.genovias.api.models.factory.EntityFactory;
import com.globalvia.genovias.api.services.dto.DTOProcessService;
import com.globalvia.genovias.api.validator.base.ReporteValidator;

@Service
public class ReporteAccidenteBaseService extends ReporteBaseCrudService<ReporteAccidente, ReporteAccidenteDTO, Long> {
  
  ReporteAccidenteBaseService( EntityFactory<ReporteAccidente, Long> entityFactory,
      DTOProcessService<ReporteAccidente, ReporteAccidenteDTO> dtoProcessService,
      ReporteValidator<ReporteAccidente, Long> validator) {
    super(entityFactory, dtoProcessService, ReporteAccidenteDTO.class, validator);
  }

  @Override
  public ReporteAccidenteDTO mapper(ReporteAccidente entity) {
    ReporteAccidenteDTO reporteAccidenteDTO = modelMapper.map(entity, ReporteAccidenteDTO.class);
    Set<String> vehiculoPlacas = entity.getVehiculos().stream().map(Vehiculo::getPlaca).collect(Collectors.toSet());
    reporteAccidenteDTO.setVehiculosPlacas(vehiculoPlacas);
    return reporteAccidenteDTO;
  }

  

}
