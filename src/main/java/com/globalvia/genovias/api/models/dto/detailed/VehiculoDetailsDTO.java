package com.globalvia.genovias.api.models.dto.detailed;

import com.globalvia.genovias.api.models.dto.simple.UsuarioConductorDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VehiculoDetailsDTO {

  private Long id;

  private String placa;

  private UsuarioConductorDTO usuarioConductor;

}
