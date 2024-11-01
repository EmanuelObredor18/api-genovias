package com.globalvia.genovias.api.models.dto.simple;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VehiculoDTO {
  
  private Long id;

  private String placa;

  private Long conductorId;
}
