package com.globalvia.genovias.api.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "puntos_referencia")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PuntoReferencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 1, max = 255)
    @Column(nullable = false)
    private String puntoReferencia; // Punto de referencia que puede cambiar

    @ManyToOne
    @JoinColumn(name = "direccion_id", nullable = false)
    private Direccion direccion; // Relación con una direccion fija
}
