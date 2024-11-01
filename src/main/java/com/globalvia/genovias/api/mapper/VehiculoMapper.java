package com.globalvia.genovias.api.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.globalvia.genovias.api.mapper.base.DetailsMapper;
import com.globalvia.genovias.api.models.dto.detailed.VehiculoDetailsDTO;
import com.globalvia.genovias.api.models.entities.Vehiculo;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class VehiculoMapper implements DetailsMapper<Vehiculo, VehiculoDetailsDTO, Long> {

  private final ModelMapper modelMapper;

  private final UsuarioConductorMapper usuarioConductorMapper; 

  @Override
  public VehiculoDetailsDTO toDTO(Vehiculo entity) {
    VehiculoDetailsDTO vehiculoDetailsDTO = modelMapper.map(entity, VehiculoDetailsDTO.class);
    vehiculoDetailsDTO.setUsuarioConductor(usuarioConductorMapper.toDTO(entity.getUsuarioConductor())); 
    return vehiculoDetailsDTO;
  }

  @Override
  public Vehiculo toEntity(Long id) {
    return Vehiculo.builder().id(id).build();
  }
  
}
