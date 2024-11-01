package com.globalvia.genovias.api.models.dto.simple;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PuntoReferenciaDTO {
  
  private Byte id;

  private String nombre;

}
