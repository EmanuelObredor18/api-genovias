package com.globalvia.genovias.api.models.entities;

import java.time.LocalDateTime;

import com.globalvia.genovias.api.models.base.Copyable;
import com.globalvia.genovias.api.models.base.Identificable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "REPORTES_DIARIOS")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ReporteDiario implements Identificable<Long>, Copyable<ReporteDiario, Long> {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(nullable = false)
  private Camioneta camioneta;
  
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(nullable = false)
  private Responsable responsable;

  @Column(nullable = false)
  private int kilometrajeEntrada;

  @Column(nullable = false)
  private int kilometrajeSalida;

  @Column(nullable = false)
  private int nivelCombustibleEntrada;

  @Column(nullable = false)
  private int nivelCombustibleSalida;

  @Column(nullable = false)
  private LocalDateTime fecha;

  @Override
  public ReporteDiario copyWith(ReporteDiario copy) {
    return ReporteDiario.builder()
      .id(copy.id != null ? copy.id : id)
      .camioneta(copy.camioneta != null ? copy.camioneta.copyWith(camioneta) : camioneta)
      .responsable(copy.responsable != null ? copy.responsable.copyWith(responsable) : responsable)
      .kilometrajeEntrada(copy.kilometrajeEntrada != 0 ? copy.kilometrajeEntrada : kilometrajeEntrada)
      .kilometrajeSalida(copy.kilometrajeSalida != 0 ? copy.kilometrajeSalida : kilometrajeSalida)
      .nivelCombustibleEntrada(copy.nivelCombustibleEntrada != 0 ? copy.nivelCombustibleEntrada : nivelCombustibleEntrada)
      .nivelCombustibleSalida(copy.nivelCombustibleSalida != 0 ? copy.nivelCombustibleSalida : nivelCombustibleSalida)
      .fecha(copy.fecha != null ? copy.fecha : fecha) 
      .build();

  }

  @Override
  public ReporteDiario copyId(Long id) {
    return copyWith(ReporteDiario.builder().id(id).build());
  }
}
