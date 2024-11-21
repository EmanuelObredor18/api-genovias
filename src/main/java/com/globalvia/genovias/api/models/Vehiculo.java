package com.globalvia.genovias.api.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "vehiculos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vehiculo {

  @Id
  @Column(nullable = false, unique = true, length = 7)
  private String placa;

  @Column(nullable = false, length = 2)
  @Enumerated(EnumType.STRING)
  private Categoria categoria;

  @ManyToOne
  @JoinColumn(nullable = false)
  private Conductor conductor;
}
