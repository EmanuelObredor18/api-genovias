package com.globalvia.genovias.api.models;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "reportes_diarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReporteDiario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "punto_referencia_id", nullable = false)
    private PuntoReferencia puntoReferencia; // Relación con PuntoReferencia (que tiene la dirección)

    @NotNull
    private String fecha; // Fecha del reporte

    @NotNull
    private String hora; // Hora del reporte

    @NotNull
    @Column(name = "nivel_combustible_entrada")
    private Integer nivelCombustibleEntrada; // Nivel de combustible al inicio

    @NotNull
    @Column(name = "nivel_combustible_salida")
    private Integer nivelCombustibleSalida; // Nivel de combustible al final

    @DecimalMin(value = "0.0", inclusive = false)
    @Column(name = "kilometraje_entrada")
    private BigDecimal kilometrajeEntrada; // Kilometraje al inicio

    @DecimalMin(value = "0.0", inclusive = false)
    @Column(name = "kilometraje_salida")
    private BigDecimal kilometrajeSalida; // Kilometraje al final

    @ManyToOne
    @JoinColumn(name = "responsable_id", nullable = false)
    private Responsable responsable; // Relación con el responsable del reporte

    @ManyToOne
    @JoinColumn(name = "camioneta_placa", nullable = false)
    private Camioneta camioneta; // Relación con la camioneta del reporte
}

