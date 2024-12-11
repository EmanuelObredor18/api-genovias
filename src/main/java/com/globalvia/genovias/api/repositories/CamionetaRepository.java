package com.globalvia.genovias.api.repositories;

import java.util.Set;

import org.springframework.data.jpa.repository.Query;

import com.globalvia.genovias.api.models.entities.Camioneta;
import com.globalvia.genovias.api.models.projections.options.CamionetaOption;

public interface CamionetaRepository extends OptionRepository<Camioneta, CamionetaOption, String> {

  @Query("SELECT c.placa AS placa FROM Camioneta c")
  Set<CamionetaOption> getOptions();
}
