package com.globalvia.genovias.api.models.entities;

import com.globalvia.genovias.api.models.base.Identificable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "VEHICULOS", uniqueConstraints = @UniqueConstraint(columnNames = "placa"))
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Vehiculo implements Identificable<Long> {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, length = 7)
  private String placa;

  @ManyToOne(cascade = {CascadeType.PERSIST})
  @JoinColumn(nullable = false, name = "usuarioConductor")
  private UsuarioConductor usuarioConductor;

}
