package com.globalvia.genovias.api.models.entities;

import com.globalvia.genovias.api.models.base.Copyable;
import com.globalvia.genovias.api.models.base.Identificable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "RESPONSABLES")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Responsable implements Identificable<Short>, Copyable<Responsable, Short> {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Short id;

  @Column(nullable = false, length = 35)
  private String nombre;

  @Column(nullable = false, length = 35)
  private String apellido;

  @Override
  public Responsable copyWith(Responsable copy) {
    return Responsable.builder()
      .id(copy.id != null ? copy.id : this.id)
      .nombre(copy.nombre != null ? copy.nombre : this.nombre)
      .apellido(copy.apellido != null ? copy.apellido : this.apellido)
      .build();
  }

  @Override
  public Responsable copyId(Short id) {
    return copyWith(Responsable.builder().id(id).build());
  }
  
}
