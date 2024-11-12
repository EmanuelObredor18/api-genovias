package com.globalvia.genovias.api.models.dto;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.globalvia.genovias.api.models.base.Dateable;
import com.globalvia.genovias.api.models.base.Identificable;

import jakarta.validation.constraints.Min;
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
public class ReporteDiarioDTO implements Identificable<Long>, Dateable {
  
  private Long id;

  @NotEmpty
  private String camionetaPlaca;
  
  @NotNull
  private Short responsableId;

  @Min(value = 1)
  private int kilometrajeEntrada;

  @Min(value = 1)
  private int kilometrajeSalida;

  @Min(value = 1)
  private int nivelCombustibleEntrada;

  @Min(value = 1)
  private int nivelCombustibleSalida;

  @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
  @DateTimeFormat(pattern = "dd/MM/yyyy HH::mm:ss")
  @NotNull
  private LocalDateTime fecha;

}
