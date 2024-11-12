package com.globalvia.genovias.api.models.dto;

import com.globalvia.genovias.api.models.base.Identificable;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CamionetaDTO implements Identificable<String> {

  private String placa;

  private int kilometraje;

  @Override
  public String getId() {
    return this.placa;
  }

}
