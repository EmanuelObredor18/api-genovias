package com.globalvia.genovias.api.models.entities;

import com.globalvia.genovias.api.models.base.Identificable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "DIRECCIONES", uniqueConstraints = @UniqueConstraint(columnNames = {"calle", "carrera", "puntoReferencia"}))
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Direccion implements Identificable<Byte> {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Byte id;

  @Column(nullable = false, length = 2)
  private String calle;

  @Column(nullable = false, length = 2)
  private String carrera;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(nullable = false, name = "puntoReferencia")
  private PuntoReferencia puntoReferencia;
}
