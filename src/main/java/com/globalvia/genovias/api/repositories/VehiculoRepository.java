package com.globalvia.genovias.api.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.globalvia.genovias.api.models.entities.Vehiculo;

public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {
  Optional<Vehiculo> findByPlaca(String placa);
  boolean existsByPlaca(String placa);
}
