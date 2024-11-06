package com.globalvia.genovias.api.models.dto;

import com.globalvia.genovias.api.models.base.Identificable;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VehiculoDTO implements Identificable<String> {

  @NotEmpty
  private String placa;

  @NotNull
  private Long usuarioConductorId;

  @Override
  public String getId() {
    return this.placa;
  }
}
