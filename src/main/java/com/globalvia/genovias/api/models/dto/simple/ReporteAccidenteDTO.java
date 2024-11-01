package com.globalvia.genovias.api.models.dto.simple;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.globalvia.genovias.api.models.base.Reporte;
import com.globalvia.genovias.api.response.enums.Estado;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ReporteAccidenteDTO implements Reporte {
  
  private Long id;

  @NotNull(message = "No puede estar vacía")
  @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
  @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
  private LocalDateTime fecha;

  @NotEmpty(message = "Debe haber mínimo un vehículo accidentado")
  @Builder.Default
  private Set<Long> vehiculosId = new HashSet<>();

  @NotNull(message = "No puede estar vacío")
  private Byte direccionId;

  @JsonIgnore
  private Estado estado;

}
