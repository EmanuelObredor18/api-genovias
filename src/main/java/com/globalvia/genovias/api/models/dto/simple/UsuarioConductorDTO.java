package com.globalvia.genovias.api.models.dto.simple;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioConductorDTO {
  private Long id;

  private String nombre;

  private String apellido;

  private String cedula;
}
