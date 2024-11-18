package com.globalvia.genovias.api.models.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.globalvia.genovias.api.models.base.Dateable;
import com.globalvia.genovias.api.models.base.Identificable;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ReporteAuxilioVialDTO implements Identificable<Long>, Dateable {
  
  private Long id;

  @JsonFormat(pattern = "dd/MM/yyyy")
  @DateTimeFormat(pattern = "dd/MM/yyyy")
  @NotNull
  private LocalDate fecha;

  @NotEmpty
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private String vehiculoPlaca;

  @NotEmpty
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private Byte direccionId;

  @NotNull
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private Short responsableId;

  @JsonProperty("calle")
  private String direccionCalle;

  @JsonProperty("carrera")
  private String direccionCarrera;

  @JsonProperty("puntoDeReferencia")
  private String direccionPuntoReferenciaNombre;

  private String responsableNombre;

  private String responsableApellido;

  @NotNull
  @DateTimeFormat(pattern = "HH:mm:ss")
  @JsonFormat(pattern = "HH:mm:ss")
  private LocalTime hora;

}
