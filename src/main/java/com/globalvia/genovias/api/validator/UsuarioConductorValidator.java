package com.globalvia.genovias.api.validator;

import org.springframework.stereotype.Component;

import com.globalvia.genovias.api.models.entities.UsuarioConductor;
import com.globalvia.genovias.api.repositories.UsuarioConductorRepository;

@Component
public class UsuarioConductorValidator extends Validator<UsuarioConductor, Long> {

  public UsuarioConductorValidator(UsuarioConductorRepository repository) {
    super(repository);
  }

}
