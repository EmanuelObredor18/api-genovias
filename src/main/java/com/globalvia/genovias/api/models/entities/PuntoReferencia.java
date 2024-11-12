package com.globalvia.genovias.api.models.entities;

import com.globalvia.genovias.api.models.base.Copyable;
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

@Entity
@Table(name = "PUNTOS_REFERENCIA", uniqueConstraints = @UniqueConstraint(columnNames = {"nombre"}))
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class PuntoReferencia implements Identificable<Byte>, Copyable<PuntoReferencia, Byte> {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Byte id;

  @Column(nullable = false, length = 50)
  private String nombre;

  @Override
  public PuntoReferencia copyWith(PuntoReferencia copy) {
    return PuntoReferencia.builder()
      .id(copy.id != null ? copy.id : this.id)
      .nombre(copy.nombre != null ? copy.nombre : this.nombre)
      .build();
  }

  @Override
  public PuntoReferencia copyId(Byte id) {
    return copyWith(PuntoReferencia.builder().id(id).build());
  }

}
