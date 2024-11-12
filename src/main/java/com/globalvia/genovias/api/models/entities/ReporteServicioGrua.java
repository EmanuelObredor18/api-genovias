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
@Table(name = "REPORTES_SERVICIOS_GRUAS")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ReporteServicioGrua implements Identificable<Long>, Copyable<ReporteServicioGrua, Long> {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private LocalDateTime fecha;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(nullable = false)
  private Vehiculo vehiculo;

  @Override
  public ReporteServicioGrua copyWith(ReporteServicioGrua copy) {
    return ReporteServicioGrua.builder()
      .id(copy.id != null ? copy.id : this.id)
      .vehiculo(copy.vehiculo != null ? copy.vehiculo.copyWith(copy.vehiculo) : vehiculo)
      .fecha(copy.fecha != null ? copy.fecha : this.fecha)
      .build();
  }

  @Override
  public ReporteServicioGrua copyId(Long id) {
    return copyWith(ReporteServicioGrua.builder().id(id).build());
  }

}
