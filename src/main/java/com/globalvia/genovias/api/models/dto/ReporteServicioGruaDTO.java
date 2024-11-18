package com.globalvia.genovias.api.models.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
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

  @JsonFormat(pattern = "dd/MM/yyyy")
  @DateTimeFormat(pattern = "dd/MM/yyyy")
  @NotNull
  private LocalDate fecha;

  @NotBlank
  private String vehiculoPlaca;

  @NotNull
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)

  private Short sitioDesengancheId;

  private String sitioDesengancheNombre;
  
  @NotNull
  @DateTimeFormat(pattern = "HH:mm:ss")
  @JsonFormat(pattern = "HH:mm:ss")
  private LocalTime hora;
}
