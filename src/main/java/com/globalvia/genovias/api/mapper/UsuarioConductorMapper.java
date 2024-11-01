package com.globalvia.genovias.api.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.globalvia.genovias.api.mapper.base.SimpleMapper;
import com.globalvia.genovias.api.models.dto.simple.UsuarioConductorDTO;
import com.globalvia.genovias.api.models.entities.UsuarioConductor;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class UsuarioConductorMapper implements SimpleMapper<UsuarioConductor, UsuarioConductorDTO> {

  private final ModelMapper modelMapper;

  @Override
  public UsuarioConductorDTO toDTO(UsuarioConductor entity) {
    return modelMapper.map(entity, UsuarioConductorDTO.class);
  }

  @Override
  public UsuarioConductor toEntity(UsuarioConductorDTO dto) {
    return modelMapper.map(dto, UsuarioConductor.class);
  }
  
}
