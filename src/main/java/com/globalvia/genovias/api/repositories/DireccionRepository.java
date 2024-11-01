package com.globalvia.genovias.api.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.globalvia.genovias.api.models.entities.Direccion;

public interface DireccionRepository extends JpaRepository<Direccion, Byte> {
  boolean existsByCalleAndCarrera(String calle, String carrera);

  @Query("SELECT d.id FROM Direccion d WHERE d.calle = :calle AND d.carrera = :carrera")
  Optional<Byte> findIdByCalleAndCarrera(@Param("calle") String calle, @Param("carrera") String carrera);
}
