package com.globalvia.genovias.api.models.dto.detailed;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.globalvia.genovias.api.models.base.Reporte;
import com.globalvia.genovias.api.response.enums.Estado;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ReporteAccidenteDetailsDTO implements Reporte {

  private Long id;

  @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
  private LocalDateTime fecha;

  @Builder.Default
  private Set<VehiculoDetailsDTO> vehiculos = new HashSet<>();

  private DireccionDetailsDTO direccion;

  @JsonIgnore
  private Estado estado;
}
