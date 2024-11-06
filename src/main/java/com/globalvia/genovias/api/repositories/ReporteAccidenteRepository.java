package com.globalvia.genovias.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.globalvia.genovias.api.models.entities.ReporteAccidente;
import java.time.LocalDateTime;


public interface ReporteAccidenteRepository extends JpaRepository<ReporteAccidente, Long> {
  boolean existsByFecha(LocalDateTime fecha);
}
