package com.globalvia.genovias.api.services;

import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.globalvia.genovias.api.exceptions.EntityFoundException;
import com.globalvia.genovias.api.models.base.Identificable;
import com.globalvia.genovias.api.models.factory.EntityFactory;
import com.globalvia.genovias.api.response.ResponseBody;
import com.globalvia.genovias.api.response.ResponseStatus;
import com.globalvia.genovias.api.services.dto.DTOProcessService;
import com.globalvia.genovias.api.validator.Validator;

import jakarta.persistence.EntityNotFoundException;

public class BaseService<E extends Identificable<ID>, DTO extends Identificable<ID>, ID> {

  protected final ResponseBody successCreatedResponse = new ResponseBody(ResponseStatus.SUCCESS, HttpStatus.CREATED.value(), "Entidad creada exitosamente");

  private final JpaRepository<E, ID> repository;
  private final Class<E> entityClass;
  private final ModelMapper modelMapper;
  private final DTOProcessService<E, DTO> dtoProcessService;
  private final Validator<E, ID> validator;

  public BaseService(
    EntityFactory<E, ID> entityFactory, 
    DTOProcessService<E, DTO> dtoProcessService,
    Validator<E, ID> validator) {
    this.repository = entityFactory.getRepository();
    this.entityClass = entityFactory.getEntityClass();
    this.modelMapper = new ModelMapper();
    this.dtoProcessService = dtoProcessService;
    this.validator = validator;
  }

  public ResponseEntity<ResponseBody> postEntity(DTO input) throws EntityFoundException {

    validator.validateExistence(input.getId(), true);
    
    E entity;

    if (dtoProcessService == null) {
      
      entity = modelMapper.map(input, entityClass);

    } else {

      entity = dtoProcessService.postProcess(input);
    }

    repository.save(entity);

    return ResponseEntity.status(HttpStatus.CREATED)
        .body(successCreatedResponse);
  }

  public ResponseEntity<String> deleteEntityById(ID id) throws EntityNotFoundException {
    repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Entidad no encontrada en la base de datos"));
    repository.deleteById(id);
    return ResponseEntity.noContent().build();
  }

  public ResponseEntity<ResponseBody> updateEntityById(DTO input, ID id) throws EntityNotFoundException {
    validator.validateExistence(id, false);

    E entity;

    if (dtoProcessService == null) {
      
      entity = modelMapper.map(input, entityClass);

    } else {

      entity = dtoProcessService.postProcess(input);

    }

    repository.save(entity);

    return ResponseEntity.status(HttpStatus.CREATED)
        .body(successCreatedResponse);

  }
}
