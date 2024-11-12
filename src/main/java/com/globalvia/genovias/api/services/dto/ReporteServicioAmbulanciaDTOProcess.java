package com.globalvia.genovias.api.services.dto;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.globalvia.genovias.api.models.dto.ReporteServicioAmbulanciaDTO;
import com.globalvia.genovias.api.models.dto.VehiculoDTO;
import com.globalvia.genovias.api.models.entities.ReporteServicioAmbulancia;
import com.globalvia.genovias.api.models.entities.Vehiculo;
import com.globalvia.genovias.api.services.base.BaseCrudService;
import com.globalvia.genovias.api.validator.ReporteServicioAmbulanciaValidator;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ReporteServicioAmbulanciaDTOProcess implements DTOProcessService<ReporteServicioAmbulancia, ReporteServicioAmbulanciaDTO> {

  private final BaseCrudService<Vehiculo, VehiculoDTO, String> vehiculoCrudService; 
  private final ModelMapper modelMapper;
  private final ReporteServicioAmbulanciaValidator validator;

  @Override
  public ReporteServicioAmbulancia postProcess(ReporteServicioAmbulanciaDTO input, boolean isNew) {
    
    Vehiculo vehiculo = vehiculoCrudService.findEntityById(input.getVehiculoPlaca()).getBody();

    ReporteServicioAmbulancia reporteServicioAmbulancia = modelMapper.map(input, ReporteServicioAmbulancia.class);

    validator.buildValidator(reporteServicioAmbulancia, isNew);

    return reporteServicioAmbulancia.copyWith(ReporteServicioAmbulancia.builder().vehiculo(vehiculo).build());

  }
  
}
