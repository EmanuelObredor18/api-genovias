package com.globalvia.genovias.api.repositories;

import java.util.Set;

import org.springframework.data.jpa.repository.Query;

import com.globalvia.genovias.api.models.entities.Vehiculo;
import com.globalvia.genovias.api.models.projections.options.VehiculoOption;

public interface VehiculoRepository extends OptionRepository<Vehiculo, VehiculoOption, String> {

  @Query("SELECT v.placa AS placa FROM Vehiculo v")
  Set<VehiculoOption> getOptions();
}
