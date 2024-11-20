package com.globalvia.genovias.api.models.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.globalvia.genovias.api.models.base.Dateable;
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
public class ReporteAccidenteDTO implements Identificable<Long>, Dateable {

    @Schema(description = "ID of the report", accessMode = Schema.AccessMode.READ_ONLY, example = "123")
    private Long id;

    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate fecha;

    @NotNull
    @JsonFormat(pattern = "HH:mm:ss")
    @DateTimeFormat(pattern = "HH:mm:ss")
    private LocalTime hora;

    @NotEmpty
    @Builder.Default
    private Set<String> vehiculosPlacas = new HashSet<>();

    @NotNull
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Short responsableId;

    @NotNull
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Short tipoAccidenteId;

    @NotNull
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Byte direccionId;

    @JsonProperty("calle")
    private String direccionCalle;

    @JsonProperty("carrera")
    private String direccionCarrera;

    @JsonProperty("puntoDeReferencia")
    private String direccionPuntoReferenciaNombre;

    private String responsableNombre;

    private String responsableApellido;

    @JsonProperty("tipoAccidente")
    private String tipoAccidenteTipo;
}
