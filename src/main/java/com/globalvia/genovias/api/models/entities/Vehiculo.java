package com.globalvia.genovias.api.models.entities;

import com.globalvia.genovias.api.models.base.Copyable;
import com.globalvia.genovias.api.models.base.Identificable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
public class Vehiculo implements Identificable<String>, Copyable<Vehiculo> {
  
  @Id
  @Column(nullable = false, length = 7)
  private String placa;

  @ManyToOne(cascade = {CascadeType.PERSIST})
  @JoinColumn(nullable = false, name = "usuarioConductor")
  private UsuarioConductor usuarioConductor;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private Categoria categoria;

  @Override
  public String getId() {
    return placa;
  }

  @Override
  public Vehiculo copyWith(Vehiculo copy) {
    return Vehiculo.builder()
        .placa(copy.placa != null ? copy.placa : this.placa)
        .usuarioConductor(copy.usuarioConductor != null ? copy.usuarioConductor.copyWith(copy.usuarioConductor) : this.usuarioConductor)
        .build();
  }

}
