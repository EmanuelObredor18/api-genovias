package com.globalvia.genovias.api.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.globalvia.genovias.api.mapper.base.DetailsMapper;
import com.globalvia.genovias.api.models.dto.detailed.DireccionDetailsDTO;
import com.globalvia.genovias.api.models.dto.simple.PuntoReferenciaDTO;
import com.globalvia.genovias.api.models.entities.Direccion;

@Component
public class DireccionMapper implements DetailsMapper<Direccion, DireccionDetailsDTO, Byte> {

  @Autowired
  private ModelMapper modelMapper;

  @Override
  public DireccionDetailsDTO toDTO(Direccion entity) {
    DireccionDetailsDTO direccionDetailsDTO = modelMapper.map(entity, DireccionDetailsDTO.class);
    direccionDetailsDTO.setPuntoReferencia(modelMapper.map(entity.getPuntoReferencia(), PuntoReferenciaDTO.class));
    return direccionDetailsDTO;
  }

  @Override
  public Direccion toEntity(Byte id) {
    return Direccion.builder().id(id).build();
  }

  
}
