package com.globalvia.genovias.api.models.entities;

import com.globalvia.genovias.api.models.base.Identificable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "USUARIOS_CONDUCTORES", uniqueConstraints = @UniqueConstraint(columnNames = {"nombre", "apellido", "cedula"}))
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UsuarioConductor implements Identificable<Long> {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, length = 50)
  private String nombre;

  @Column(nullable = false, length = 50)
  private String apellido;

  @Column(nullable = false, length = 80)
  private String cedula;
}
