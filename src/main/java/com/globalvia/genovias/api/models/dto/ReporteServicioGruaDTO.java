package com.globalvia.genovias.api.models.dto;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.globalvia.genovias.api.models.base.Dateable;
import com.globalvia.genovias.api.models.base.Identificable;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ReporteServicioGruaDTO implements Identificable<Long>, Dateable {
  
  private Long id;

  @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
  @DateTimeFormat(pattern = "dd/MM/yyyy HH::mm:ss")
  @NotNull
  private LocalDateTime fecha;

  @NotBlank
  private String vehiculoPlaca;

  @NotNull
  private Short sitioDesengancheId;
}
