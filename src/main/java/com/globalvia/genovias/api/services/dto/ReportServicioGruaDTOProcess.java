package com.globalvia.genovias.api.services.dto;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.globalvia.genovias.api.models.dto.ReporteServicioGruaDTO;
import com.globalvia.genovias.api.models.dto.VehiculoDTO;
import com.globalvia.genovias.api.models.entities.ReporteServicioGrua;
import com.globalvia.genovias.api.models.entities.Vehiculo;
import com.globalvia.genovias.api.services.base.BaseCrudService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ReportServicioGruaDTOProcess implements DTOProcessService<ReporteServicioGrua, ReporteServicioGruaDTO> {

  private final BaseCrudService<Vehiculo, VehiculoDTO, String> vehiculoBaseCrudService;
  private final ModelMapper modelMapper;

  @Override
  public ReporteServicioGrua postProcess(ReporteServicioGruaDTO input, boolean isNew) {
    Vehiculo vehiculo = vehiculoBaseCrudService.findEntityById(input.getVehiculoPlaca()).getBody();
    ReporteServicioGrua reporteServicioGrua = modelMapper.map(input, ReporteServicioGrua.class);
    return reporteServicioGrua.copyWith(ReporteServicioGrua.builder().vehiculo(vehiculo).build());
  }
  
}
