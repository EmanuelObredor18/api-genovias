package com.globalvia.genovias.api.validator;

import org.springframework.stereotype.Component;

import com.globalvia.genovias.api.models.entities.Vehiculo;
import com.globalvia.genovias.api.repositories.VehiculoRepository;

@Component
public class VehiculoValidator extends Validator<Vehiculo, String> {

  public VehiculoValidator(VehiculoRepository repository) {
    super(repository);
  }

}
