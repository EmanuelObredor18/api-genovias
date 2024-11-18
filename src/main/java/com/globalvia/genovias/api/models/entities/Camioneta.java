package com.globalvia.genovias.api.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.globalvia.genovias.api.models.base.Copyable;
import com.globalvia.genovias.api.models.base.Identificable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "CAMIONETAS")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Camioneta implements Identificable<String>, Copyable<Camioneta, String> {
  
  @Id
  @Column(length = 7)
  private String placa;

  @Column(nullable = false)
  private int kilometraje;

  @Override
  public Camioneta copyWith(Camioneta copy) {
    return Camioneta.builder()
      .placa(copy.placa != null ? copy.placa : placa)
      .kilometraje(copy.kilometraje != 0 ? copy.kilometraje : kilometraje)
      .build();
  }

  @Override
  public Camioneta copyId(String id) {
    return copyWith(Camioneta.builder().placa(id).build());
  }

  @Override
  @JsonIgnore
  public String getId() {
    return this.placa;
  }

}
