package com.globalvia.genovias.api.repositories;

import com.globalvia.genovias.api.models.entities.Responsable;
import com.globalvia.genovias.api.models.projections.options.ResponsableOption;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;

public interface ResponsableRepository extends OptionRepository<Responsable, ResponsableOption, Short>{
  Optional<Responsable> findByUserEntityUsername(String username);

  @Query("SELECT r.id AS id, r.nombre AS nombre, r.apellido AS apellido FROM Responsable r")
  Set<ResponsableOption> getOptions();
}
