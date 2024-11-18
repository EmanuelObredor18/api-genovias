package com.globalvia.genovias.api.models.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.globalvia.genovias.api.models.base.Dateable;
import com.globalvia.genovias.api.models.base.Identificable;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ReporteServicioAmbulanciaDTO implements Identificable<Long>, Dateable {

  private Long id;

  @JsonFormat(pattern = "dd/MM/yyyy")
  @DateTimeFormat(pattern = "dd/MM/yyyy")
  @NotNull
  private LocalDate fecha;

  private String vehiculoPlaca;

  @NotNull
  @DateTimeFormat(pattern = "HH:mm:ss")
  @JsonFormat(pattern = "HH:mm:ss")
  private LocalTime hora;
}
