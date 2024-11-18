package com.globalvia.genovias.api.models.entities;

import java.time.LocalDate;
import java.time.LocalTime;

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
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "REPORTES_SERVICIOS_GRUAS", uniqueConstraints = @UniqueConstraint(columnNames = {"fecha", "hora"}))
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ReporteServicioGrua implements Identificable<Long>, Copyable<ReporteServicioGrua, Long> {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private LocalDate fecha;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(nullable = false)
  private Vehiculo vehiculo;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(nullable = false)
  private SitioDesenganche sitioDesenganche;

  @Column(nullable = false)
  private LocalTime hora;

  @Override
  public ReporteServicioGrua copyWith(ReporteServicioGrua copy) {
    return ReporteServicioGrua.builder()
      .id(copy.id != null ? copy.id : this.id)
      .vehiculo(copy.vehiculo != null ? copy.vehiculo.copyWith(copy.vehiculo) : vehiculo)
      .sitioDesenganche(copy.sitioDesenganche != null ? sitioDesenganche.copyWith(copy.sitioDesenganche) : sitioDesenganche)
      .fecha(copy.fecha != null ? copy.fecha : this.fecha)
      .hora(copy.hora != null ? copy.hora : hora)
      .build();
  }

  @Override
  public ReporteServicioGrua copyId(Long id) {
    return copyWith(ReporteServicioGrua.builder().id(id).build());
  }

}
