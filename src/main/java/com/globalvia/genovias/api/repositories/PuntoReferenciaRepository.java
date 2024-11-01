package com.globalvia.genovias.api.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.globalvia.genovias.api.models.entities.PuntoReferencia;

public interface PuntoReferenciaRepository extends JpaRepository<PuntoReferencia, Short> {
  boolean existsByNombre(String nombre);
  
  @Query("SELECT p.id FROM PuntoReferencia p WHERE p.nombre = :nombre")
  Optional<Short> findIdByNombre(@Param("nombre") String nombre);
}
