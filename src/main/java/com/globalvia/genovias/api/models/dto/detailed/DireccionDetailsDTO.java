package com.globalvia.genovias.api.models.dto.detailed;

import com.globalvia.genovias.api.models.dto.simple.PuntoReferenciaDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DireccionDetailsDTO {
  
  private Byte id;

  private String calle;

  private String carrera;

  private PuntoReferenciaDTO puntoReferencia;
}
