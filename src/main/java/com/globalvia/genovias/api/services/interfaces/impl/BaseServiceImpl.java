package com.globalvia.genovias.api.services.interfaces.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

import com.globalvia.genovias.api.models.base.Identificable;
import com.globalvia.genovias.api.response.Response;
import com.globalvia.genovias.api.response.enums.Estado;
import com.globalvia.genovias.api.services.interfaces.BaseService;


public class BaseServiceImpl<E extends Identificable<ID>, DTO, ID>
    implements BaseService<DTO, ID> {

  private final Class<E> entityClass;
  private final Class<DTO> dtoClass;
  private final JpaRepository<E, ID> repository;
  private final ModelMapper modelMapper;
  protected Response response;

  public BaseServiceImpl(Class<E> entityClass, Class<DTO> dtoClass, JpaRepository<E, ID> repository,
      ModelMapper modelMapper
    ) {
    this.entityClass = entityClass;
    this.dtoClass = dtoClass;
    this.modelMapper = modelMapper;
    this.repository = repository;
    this.response = new Response();
  }

  @Override
  @Transactional
  public ResponseEntity<Response> postEntity(DTO input) {
    E entity = modelMapper.map(input, entityClass);
    repository.save(entity);
    return ResponseEntity.status(response.getCodeStatus()).body(response);
  }

  @Override
  public ResponseEntity<Map<String, Object>> getAllEntities(int page, int size, String sortBy, String sortDirection) {
    Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
        : Sort.by(sortBy).descending();
    Pageable pageable = PageRequest.of(page, size, sort);

    Page<DTO> pagedResult = repository.findAll(pageable).map(e -> modelMapper.map(e, dtoClass));

    Map<String, Object> responseList = new HashMap<>();
    responseList.put("content", pagedResult.getContent());
    responseList.put("currentPage", pagedResult.getNumber());
    responseList.put("totalItems", pagedResult.getTotalElements());
    responseList.put("totalPages", pagedResult.getTotalPages());

    return ResponseEntity.ok(responseList);
  }

  @Override
  public ResponseEntity<Response> putEntity(DTO input) {
    E entity = modelMapper.map(input, entityClass);

    repository.save(entity);

    return ResponseEntity.ok().body(response);
  }

  @Override
  @Transactional
  public ResponseEntity<Response> deleteEntityById(ID id) {
    Optional<E> entity = repository.findById(id);

    entity.ifPresentOrElse(e -> {
      response = new Response(HttpStatus.OK, Estado.FINALIZADO, "Eliminado correctamente");
      repository.delete(e);
    }, () -> {
      response = new Response(HttpStatus.NOT_FOUND, Estado.ERROR, "Entidad no encontrada");
    });
    
    return ResponseEntity.status(response.getCodeStatus()).body(response);
  }

  @Override
  public ResponseEntity<Object> findEntityById(ID id) {
    Optional<E> entity = repository.findById(id);

    if (entity.isPresent()) {
      return ResponseEntity.ok().body(modelMapper.map(entity.get(), dtoClass));
    }    

    response = new Response(HttpStatus.NOT_FOUND, Estado.ERROR, "Entidad no encontrada");

    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
  }

}
