package com.globalvia.genovias.api.services.dto;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.globalvia.genovias.api.models.dto.UsuarioConductorDTO;
import com.globalvia.genovias.api.models.dto.VehiculoDTO;
import com.globalvia.genovias.api.models.entities.UsuarioConductor;
import com.globalvia.genovias.api.models.entities.Vehiculo;
import com.globalvia.genovias.api.services.base.BaseCrudService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VehiculoDTOProcess implements DTOProcessService<Vehiculo, VehiculoDTO> {

  private final ModelMapper modelMapper;
  private final BaseCrudService<UsuarioConductor, UsuarioConductorDTO, Long> usuarioConductoCrudService;

  @Override
  public Vehiculo postProcess(VehiculoDTO input, boolean isNew) {
    UsuarioConductor usuarioConductor = usuarioConductoCrudService.findEntityById(input.getUsuarioConductorId()).getBody();

    Vehiculo vehiculo = modelMapper.map(input, Vehiculo.class);

    vehiculo.copyWith(Vehiculo.builder().usuarioConductor(usuarioConductor).build());

    return vehiculo;
  }
  
}
