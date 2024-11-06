package com.globalvia.genovias.api.services.dto;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.globalvia.genovias.api.models.dto.VehiculoDTO;
import com.globalvia.genovias.api.models.entities.UsuarioConductor;
import com.globalvia.genovias.api.models.entities.Vehiculo;
import com.globalvia.genovias.api.services.UsuarioConductorService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VehiculoDTOProcess implements DTOProcessService<Vehiculo, VehiculoDTO> {

  private final ModelMapper modelMapper;
  private final UsuarioConductorService usuarioConductorService;

  @Override
  public Vehiculo postProcess(VehiculoDTO input) {
    UsuarioConductor usuarioConductor = usuarioConductorService.getUsuarioConductorById(input.getUsuarioConductorId());

    Vehiculo vehiculo = modelMapper.map(input, Vehiculo.class);

    vehiculo.copyWith(Vehiculo.builder().usuarioConductor(usuarioConductor).build());

    return vehiculo;
  }
  
}
