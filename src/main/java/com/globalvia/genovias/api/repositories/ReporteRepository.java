package com.globalvia.genovias.api.repositories;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface ReporteRepository<E, ID> extends JpaRepository<E, ID> {
  boolean existsByFecha(LocalDateTime fecha);
}
