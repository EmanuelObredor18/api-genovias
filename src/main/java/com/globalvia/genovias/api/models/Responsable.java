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
@Table(name = "responsables")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Responsable {

  @Id
  @Column(nullable = false, unique = true, length = 100)
  private String nombre;

  @Column(nullable = false, length = 100)
  private String apellido;
}
