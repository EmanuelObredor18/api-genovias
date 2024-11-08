package com.globalvia.genovias.api.services.dto;

import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.globalvia.genovias.api.models.dto.ReporteAccidenteDTO;
import com.globalvia.genovias.api.models.entities.ReporteAccidente;
import com.globalvia.genovias.api.models.entities.Vehiculo;
import com.globalvia.genovias.api.services.VehiculoService;
import com.globalvia.genovias.api.validator.ReporteAccidenteValidator;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReporteAccidenteDTOProcess implements DTOProcessService<ReporteAccidente, ReporteAccidenteDTO> {

  private final VehiculoService vehiculoService;
  private final ModelMapper modelMapper;
  private final ReporteAccidenteValidator validator;

  @Override
  public ReporteAccidente postProcess(ReporteAccidenteDTO input) {
    Set<Vehiculo> vehiculos = vehiculoService.getVehiculosByPlaca(input.getVehiculosPlacas());

    ReporteAccidente reporteAccidente = modelMapper.map(input, ReporteAccidente.class);

    validator.buildValidator(reporteAccidente).validate();

    return reporteAccidente
        .copyWith(ReporteAccidente.builder().vehiculos(vehiculos).build());
    
    
  }

}
