package com.globalvia.genovias.api.models.entities;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.globalvia.genovias.api.models.base.Copyable;
import com.globalvia.genovias.api.models.base.Identificable;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "REPORTES_ACCIDENTES", uniqueConstraints = @UniqueConstraint(columnNames = "fecha"))
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ReporteAccidente implements Identificable<Long>, Copyable<ReporteAccidente, Long> {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Schema(description = "ID of the entity", accessMode = Schema.AccessMode.READ_ONLY)
  private Long id;

  @Column(nullable = false)
  private LocalDateTime fecha;

  @Builder.Default
  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "accidentes_vehiculos", joinColumns = @JoinColumn(nullable = false, name = "reporte_id"), inverseJoinColumns = @JoinColumn(nullable = false, name = "vehiculo_id"))
  private Set<Vehiculo> vehiculos = new HashSet<>();

  @ManyToOne
  @JoinColumn(name = "direccion", nullable = false)
  private Direccion direccion;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(nullable = false)
  private TipoAccidente tipoAccidente;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(nullable = false)
  private Responsable responsable;

  @Override
  public ReporteAccidente copyWith(ReporteAccidente copy) {
    return ReporteAccidente.builder()
        .id(copy.getId() != null ? copy.getId() : this.getId())
        .vehiculos(copy.getVehiculos() != null && !copy.getVehiculos().isEmpty()
            ? copy.vehiculos.stream().map(vehiculo -> vehiculo.copyWith(vehiculo)).collect(Collectors.toSet())
            : this.getVehiculos())
        .direccion(copy.getDireccion() != null ? copy.direccion : this.direccion)
        .fecha(copy.getFecha() != null ? copy.fecha : this.fecha)
        .tipoAccidente(copy.getTipoAccidente() != null ? copy.tipoAccidente.copyWith(copy.tipoAccidente) : this.tipoAccidente)
        .responsable(copy.getResponsable() != null ? copy.responsable.copyWith(copy.responsable) : this.responsable)
        .build();
  }

  @Override
  public ReporteAccidente copyId(Long id) {
    return copyWith(ReporteAccidente.builder().id(id).build());
  }

}
