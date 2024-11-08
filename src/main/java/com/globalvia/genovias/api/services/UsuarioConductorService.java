package com.globalvia.genovias.api.services;

import org.springframework.stereotype.Service;

import com.globalvia.genovias.api.models.entities.UsuarioConductor;
import com.globalvia.genovias.api.repositories.UsuarioConductorRepository;
import com.globalvia.genovias.api.validator.base.Validator;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioConductorService {
  
  private final UsuarioConductorRepository repository;

  private final Validator<UsuarioConductor, Long> validator;

  public UsuarioConductor getUsuarioConductorById(Long id) {
    
    validator.validateExistence(id, false);

    return repository.findById(id).get();
  }

}
