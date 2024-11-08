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

@Entity
@Table(name = "TIPOS_ACCIDENTES")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class TipoAccidente implements Identificable<Short>, Copyable<TipoAccidente> {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Short id;

  @Column(nullable = false, length = 50)
  private String tipo;

  @Override
  public TipoAccidente copyWith(TipoAccidente copy) {
    return TipoAccidente.builder()
      .id(id != null ? this.id : copy.id)
      .tipo(tipo != null ? this.tipo : copy.tipo)
      .build();
  }

}
