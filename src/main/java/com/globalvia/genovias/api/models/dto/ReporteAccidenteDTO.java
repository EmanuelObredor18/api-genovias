package com.globalvia.genovias.api.models.dto;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.globalvia.genovias.api.models.base.Identificable;

import io.swagger.v3.oas.annotations.media.Schema;
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
public class ReporteAccidenteDTO implements Identificable<Long>{
  
  @Schema(description = "ID of the entity", accessMode = Schema.AccessMode.READ_ONLY)
  private Long id;

  @NotNull
  @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
  @DateTimeFormat(pattern = "dd/MM/yyyy HH::mm:ss")
  private LocalDateTime fecha;

  @NotEmpty
  @Builder.Default
  private Set<String> vehiculosPlacas = new HashSet<>();
  
  @NotNull
  private Byte direccionId;
}
