package com.globalvia.genovias.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.globalvia.genovias.api.models.entities.Vehiculo;

public interface VehiculoRepository extends JpaRepository<Vehiculo, String> {

}
