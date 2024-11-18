package com.globalvia.genovias.api.repositories;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface ReporteRepository<E, ID> extends JpaRepository<E, ID> {
  
  boolean existsByFechaAndHora(LocalDate fecha, LocalTime hora);

  Set<E> findAllByFecha(LocalDate fecha);
}
