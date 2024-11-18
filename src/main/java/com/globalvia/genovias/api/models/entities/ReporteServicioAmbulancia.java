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
@Table(name = "REPORTES_SERVICIO_AMBULANCIA", uniqueConstraints = @UniqueConstraint(columnNames = {"fecha", "hora"}))
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ReporteServicioAmbulancia implements Identificable<Long>, Copyable<ReporteServicioAmbulancia, Long> {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private LocalDate fecha;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(nullable = false)
  private Vehiculo vehiculo;

  @Column(nullable = false)
  private LocalTime hora;

  @Override
  public ReporteServicioAmbulancia copyWith(ReporteServicioAmbulancia copy) {
    return ReporteServicioAmbulancia.builder()
      .id(copy.id != null ? copy.id : id)
      .fecha(copy.fecha != null ? copy.fecha : fecha)
      .hora(copy.hora != null ? copy.hora : hora)
      .vehiculo(copy.vehiculo != null ? copy.getVehiculo().copyWith(copy.vehiculo) : vehiculo)
      .build();
  }

  @Override
  public ReporteServicioAmbulancia copyId(Long id) {
    return copyWith(ReporteServicioAmbulancia.builder().id(id).build());
  }
}
