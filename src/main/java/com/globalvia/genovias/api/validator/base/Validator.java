package com.globalvia.genovias.api.validator.base;

import java.util.LinkedList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.globalvia.genovias.api.exceptions.EntityFoundException;
import com.globalvia.genovias.api.exceptions.EntityNotFoundException;
import com.globalvia.genovias.api.models.base.Identificable;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Validator<E extends Identificable<ID>, ID> {

  private final JpaRepository<E, ID> repository;

  private final List<VoidCallback> validators = new LinkedList<>();

  public final void validate() {
    validators.forEach(callBack -> callBack.apply());
  };

  
  public final void validateExistence(ID id, boolean isNew) {

    boolean exists = false;

    if (id != null) {
      
      exists = repository.existsById(id);
    
    }

    if (!isNew && !exists) {
      throw new EntityNotFoundException("Error de validación. Entidad con id " + id + " no encontrado(a) en la base de datos");
    } 

    if (isNew && exists) {
      throw new EntityFoundException("Entidad encontrada en la base de datos. Editarla por este medio no está disponible");
    }
    
  }

  public void validateUniqueFields(Object... fields) {}

  public Validator<E, ID> addValidation(VoidCallback callback) {
    validators.add(callback);
    return this;
  }
}
