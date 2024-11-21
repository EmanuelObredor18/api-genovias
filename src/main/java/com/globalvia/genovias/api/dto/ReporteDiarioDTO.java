package com.globalvia.genovias.api.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Pattern;

import java.math.BigDecimal;

import com.globalvia.genovias.api.annotations.validation.ValidNivelCombustible;

public class ReporteDiarioDTO {

  @NotNull
  @Size(min = 1, max = 255)
  private String direccion; // Dirección del reporte

  @NotNull
  @Size(min = 1, max = 255)
  private String puntoReferencia; // Punto de referencia

  @NotNull
  @Pattern(regexp = "^([0-2][0-9]|[3][0-1])/(0[1-9]|1[0-2])/(\\d{4})$", message = "La fecha debe estar en el formato dd/MM/yyyy")
  private String fecha; // Fecha del reporte

  @NotNull
  @Pattern(regexp = "^([01][0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])$", message = "La hora debe estar en el formato HH:mm:ss")
  private String hora; // Hora del reporte

  @NotNull
  @ValidNivelCombustible
  private Integer nivelCombustibleEntrada; // Nivel de combustible al inicio

  @NotNull
  @ValidNivelCombustible
  private Integer nivelCombustibleSalida; // Nivel de combustible al final

  @NotNull
  @DecimalMin(value = "0.0", inclusive = false)
  private BigDecimal kilometrajeEntrada; // Kilometraje al inicio

  @NotNull
  @DecimalMin(value = "0.0", inclusive = false)
  private BigDecimal kilometrajeSalida; // Kilometraje al final

  @NotNull
  private Long responsableId; // ID del responsable que generó el reporte

  @NotNull
  private String camionetaPlaca; // Placa de la camioneta asociada al reporte

  // Getters y Setters
}
