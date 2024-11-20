package com.globalvia.genovias.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.globalvia.genovias.api.models.entities.Responsable;
import java.util.Optional;


public interface ResponsableRepository extends JpaRepository<Responsable, Short> {
  Optional<Responsable> findByUserEntityUsername(String username);
}
