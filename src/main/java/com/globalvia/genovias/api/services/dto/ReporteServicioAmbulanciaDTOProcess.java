package com.globalvia.genovias.api.services.dto;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.globalvia.genovias.api.models.dto.ReporteServicioAmbulanciaDTO;
import com.globalvia.genovias.api.models.dto.VehiculoDTO;
import com.globalvia.genovias.api.models.entities.ReporteServicioAmbulancia;
import com.globalvia.genovias.api.models.entities.Vehiculo;
import com.globalvia.genovias.api.services.base.interfaces.BaseService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ReporteServicioAmbulanciaDTOProcess implements DTOProcessService<ReporteServicioAmbulancia, ReporteServicioAmbulanciaDTO> {

  private final BaseService<Vehiculo, VehiculoDTO, String> vehiculoCrudService; 
  private final ModelMapper modelMapper;

  @Override
  public ReporteServicioAmbulancia postProcess(ReporteServicioAmbulanciaDTO input, boolean isNew) {
    Vehiculo vehiculo = vehiculoCrudService.findEntityById(input.getVehiculoPlaca()).getBody();
    ReporteServicioAmbulancia reporteServicioAmbulancia = modelMapper.map(input, ReporteServicioAmbulancia.class);
    return reporteServicioAmbulancia.copyWith(ReporteServicioAmbulancia.builder().vehiculo(vehiculo).build());

  }
  
}
