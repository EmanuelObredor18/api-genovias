package com.globalvia.genovias.api.mapper;

import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.globalvia.genovias.api.mapper.base.DetailsMapper;
import com.globalvia.genovias.api.models.dto.detailed.ReporteAccidenteDetailsDTO;
import com.globalvia.genovias.api.models.dto.simple.ReporteAccidenteDTO;
import com.globalvia.genovias.api.models.entities.ReporteAccidente;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class ReporteAccidenteMapper
    implements DetailsMapper<ReporteAccidente, ReporteAccidenteDetailsDTO, ReporteAccidenteDTO> {

  private final ModelMapper modelMapper;

  private final VehiculoMapper vehiculoMapper;

  private final DireccionMapper direccionMapper;

  @Override
  public ReporteAccidenteDetailsDTO toDTO(ReporteAccidente entity) {
    ReporteAccidenteDetailsDTO reporte = modelMapper.map(entity, ReporteAccidenteDetailsDTO.class);
    reporte.setVehiculos(entity.getVehiculos().stream().map(vehiculoMapper::toDTO).collect(Collectors.toSet()));
    reporte.setDireccion(direccionMapper.toDTO(entity.getDireccion()));
    return reporte;
  }

  @Override
  public ReporteAccidente toEntity(ReporteAccidenteDTO dto) {
    ReporteAccidente reporteAccidente = modelMapper.map(dto, ReporteAccidente.class);
    reporteAccidente.setDireccion(direccionMapper.toEntity(reporteAccidente.getDireccion().getId()));
    reporteAccidente.setVehiculos(dto.getVehiculosId().stream().map(vehiculoMapper::toEntity).collect(Collectors.toSet()));
    return reporteAccidente;
  }

}
