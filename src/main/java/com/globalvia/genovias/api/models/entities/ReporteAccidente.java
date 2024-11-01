package com.globalvia.genovias.api.models.entities;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import com.globalvia.genovias.api.models.base.Identificable;
import com.globalvia.genovias.api.response.enums.Estado;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
public class ReporteAccidente implements Identificable<Long> {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private LocalDateTime fecha;

  @Builder.Default
  @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
  @JoinTable(
    name = "accidentes_vehiculos", 
    joinColumns = @JoinColumn(nullable = false, name = "reporte_id"),
    inverseJoinColumns = @JoinColumn(nullable = false, name = "vehiculo_id")
  )
  private Set<Vehiculo> vehiculos = new HashSet<>();

  @ManyToOne
  @JoinColumn(name = "direccion", nullable = false)
  private Direccion direccion;

  @Enumerated(EnumType.STRING)
  private Estado estado;
}
