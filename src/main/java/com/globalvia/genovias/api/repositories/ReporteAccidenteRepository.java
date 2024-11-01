package com.globalvia.genovias.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.globalvia.genovias.api.models.entities.ReporteAccidente;
import java.time.LocalDateTime;
import java.util.List;
import com.globalvia.genovias.api.response.enums.Estado;

public interface ReporteAccidenteRepository extends JpaRepository<ReporteAccidente, Long> {

  boolean existsByFecha(LocalDateTime fecha);

  List<ReporteAccidente> findByEstado(Estado estado);
}
