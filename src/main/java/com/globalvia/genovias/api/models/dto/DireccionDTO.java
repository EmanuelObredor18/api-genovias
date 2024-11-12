package com.globalvia.genovias.api.models.dto;

import com.globalvia.genovias.api.models.base.Identificable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DireccionDTO implements Identificable<Byte> {
  
  private Byte id;

  private String calle;

  private String carrera;

  private Byte puntoReferenciaId;
}
