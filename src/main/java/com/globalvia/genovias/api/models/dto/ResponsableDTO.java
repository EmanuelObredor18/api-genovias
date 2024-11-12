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
public class ResponsableDTO implements Identificable<Short> {
  
  private Short id;

  private String nombre;

  private String apellido;
}
