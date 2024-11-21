package com.globalvia.genovias.api.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "camionetas")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Camioneta {

  @Id
  @Column(nullable = false, unique = true, length = 7)
  private String placa; // Identificador único de la camioneta

  @Column(nullable = false, length = 20000)
  private double kilometraje; // Kilometraje actual de la camioneta
}
