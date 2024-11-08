package com.globalvia.genovias.api.services;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.globalvia.genovias.api.models.entities.Vehiculo;
import com.globalvia.genovias.api.repositories.VehiculoRepository;
import com.globalvia.genovias.api.validator.base.Validator;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class VehiculoService {

  private final Validator<Vehiculo, String> vehiculoValidator;
  private final VehiculoRepository repository;

  public Set<Vehiculo> getVehiculosByPlaca(Set<String> placas) {
    placas.forEach(placa -> vehiculoValidator.validateExistence(placa, false));
    return repository.findAllById(placas).stream().collect(Collectors.toSet());
  } 

}
