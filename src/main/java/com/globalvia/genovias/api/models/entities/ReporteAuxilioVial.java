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
@Table(name = "REPORTE_AUXILIOS_VIALES")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ReporteAuxilioVial implements Identificable<Long>, Copyable<ReporteAuxilioVial, Long> {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private LocalDateTime fecha;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(nullable = false)
  private Vehiculo vehiculo;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(nullable = false)
  private Direccion direccion;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(nullable = false)
  private Responsable responsable;

  @Override
  public ReporteAuxilioVial copyWith(ReporteAuxilioVial copy) {
    return ReporteAuxilioVial.builder()
      .id(copy.id != null ? copy.id : id)
      .fecha(copy.fecha != null ? copy.fecha : fecha)
      .vehiculo(copy.vehiculo != null ? vehiculo.copyWith(copy.vehiculo) : vehiculo)
      .direccion(copy.direccion != null ? direccion.copyWith(copy.direccion) : direccion)
      .responsable(copy.responsable != null ? responsable.copyWith(copy.responsable) : responsable)
      .build();
  }

  @Override
  public ReporteAuxilioVial copyId(Long id) {
    return copyWith(ReporteAuxilioVial.builder().id(id).build());
  }
  
}
