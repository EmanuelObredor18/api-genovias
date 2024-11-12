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

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "SITIOS_DESENGANCHE")
@Entity
public class SitioDesenganche implements Identificable<Short>, Copyable<SitioDesenganche, Short> {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Short id;

  @Column(nullable = false, length = 40)
  private String nombre;

  @Override
  public SitioDesenganche copyWith(SitioDesenganche copy) {
    return SitioDesenganche.builder()
      .id(copy.id != null ? copy.id : id)
      .nombre(copy.nombre != null ? copy.nombre : nombre)
      .build();
  }

  @Override
  public SitioDesenganche copyId(Short id) {
    return this.copyWith(SitioDesenganche.builder().id(id).build());
  }

}
