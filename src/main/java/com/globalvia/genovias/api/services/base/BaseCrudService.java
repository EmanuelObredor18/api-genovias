package com.globalvia.genovias.api.services.base;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.globalvia.genovias.api.exceptions.EntityFoundException;
import com.globalvia.genovias.api.exceptions.EntityNotFoundException;
import com.globalvia.genovias.api.models.base.Copyable;
import com.globalvia.genovias.api.models.base.Identificable;
import com.globalvia.genovias.api.models.factory.EntityFactory;
import com.globalvia.genovias.api.response.ResponseBody;
import com.globalvia.genovias.api.response.ResponseStatus;
import com.globalvia.genovias.api.services.base.interfaces.BaseService;
import com.globalvia.genovias.api.services.dto.DTOProcessService;

public class BaseCrudService<E extends Identificable<ID> & Copyable<E, ID>, DTO extends Identificable<ID>, ID>
    implements BaseService<E, DTO, ID> {

  protected final ResponseBody successCreatedResponse = new ResponseBody(ResponseStatus.SUCCESS,
      HttpStatus.CREATED.value(), "Entidad creada exitosamente");
  protected final ResponseBody successUpdatedResponse = new ResponseBody(ResponseStatus.SUCCESS, HttpStatus.OK.value(),
      "Entidad actualizada exitosamente");

  private final JpaRepository<E, ID> repository;
  private final Class<E> entityClass;
  private final Class<DTO> dtoClass;
  protected final ModelMapper modelMapper;
  private final DTOProcessService<E, DTO> dtoProcessService;

  public BaseCrudService(EntityFactory<E, ID> entityFactory, DTOProcessService<E, DTO> dtoProcessService,
      Class<DTO> dtoClass) {
    this.repository = entityFactory.getRepository();
    this.entityClass = entityFactory.getEntityClass();
    this.modelMapper = new ModelMapper();
    this.dtoProcessService = dtoProcessService;
    this.dtoClass = dtoClass;
  }

  public BaseCrudService(EntityFactory<E, ID> entityFactory, DTOProcessService<E, DTO> dtoProcessService) {
    this(entityFactory, dtoProcessService, null);
  }

  // Método reutilizable para manejar el mapeo entre DTO y entidad
  private E mapDtoToEntity(DTO input, boolean isNew) {
    if (dtoProcessService != null) {
      return dtoProcessService.postProcess(input, isNew);
    }
    return modelMapper.map(input, entityClass);
  }

  // Método reutilizable para buscar una entidad por ID o lanzar una excepción
  protected E findEntityOrThrow(ID id) {
    return repository.findById(id)
        .orElseThrow(
            () -> new EntityNotFoundException(entityClass.getSimpleName() + " no encontrado(a) en la base de datos"));
  }

  @Override
  public ResponseEntity<ResponseBody> postEntity(DTO input) throws EntityFoundException {
    if (input.getId() != null && repository.existsById(input.getId())) {
      throw new EntityFoundException(
          "Entidad encontrada en la base de datos. Editarla por este medio no está disponible");
    }

    E entity = mapDtoToEntity(input, true);
    repository.save(entity);

    return ResponseEntity.status(HttpStatus.CREATED).body(successCreatedResponse);
  }

  // Optimización en la actualización de la entidad

  // TODO: agregar proceso de DTO
  @Override
  public ResponseEntity<ResponseBody> updateEntityById(DTO input, ID id) throws EntityNotFoundException {
    if (!repository.existsById(id)) {
      throw new EntityNotFoundException(
          "Error de validación. Entidad con id " + id + " no encontrado(a) en la base de datos");
    }

    findEntityOrThrow(id);
    E entity = mapDtoToEntity(input, true);
    repository.save(entity.copyId(id));

    return ResponseEntity.status(HttpStatus.OK).body(successUpdatedResponse);
  }

  // Método para eliminar entidad por ID
  @Override
  public ResponseEntity<String> deleteEntityById(ID id) {
    E entity = findEntityOrThrow(id);
    if (dtoProcessService != null && dtoClass != null) {
      dtoProcessService.deleteProcess(modelMapper.map(entity, dtoClass));
    }
    repository.delete(entity);
    return ResponseEntity.noContent().build();
  }

  // Optimización en la obtención de todas las entidades con paginación y
  // ordenamiento
  @Override
  public ResponseEntity<Map<String, Object>> getAllEntities(int size, int page, String sortDirection, String sortBy) {
    Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortDirection), sortBy));

    Page<E> pageResponse = repository.findAll(pageable);
    Map<String, Object> response = new LinkedHashMap<>();
    response.put("totalElements", pageResponse.getTotalElements());
    response.put("totalPages", pageResponse.getTotalPages());
    response.put("content",
        pageResponse.getContent().stream().map(this::mapper).collect(Collectors.toCollection(LinkedHashSet::new)));

    return ResponseEntity.ok(response);
  }

  // Método para encontrar una entidad por ID
  @Override
  public ResponseEntity<DTO> findEntityDTOById(ID id) {
    E entity = findEntityOrThrow(id);
    return ResponseEntity.ok(mapper(entity));
  }

  @Override
  public ResponseEntity<E> findEntityById(ID id) {
    E entity = findEntityOrThrow(id);
    return ResponseEntity.ok(entity);
  }

  // Optimización para buscar varias entidades por un conjunto de IDs
  @Override
  public ResponseEntity<Set<E>> findAllEntitiesById(Collection<ID> ids) {
    // Obtener las entidades encontradas por sus IDs
    Set<E> entities = repository.findAllById(ids).stream().collect(Collectors.toSet());

    // Extraer los IDs de las entidades encontradas
    Set<ID> foundIds = entities.stream().map(Identificable::getId).collect(Collectors.toSet());

    // Identificar los IDs que no se encontraron
    Set<ID> notFoundIds = ids.stream().filter(id -> !foundIds.contains(id)).collect(Collectors.toSet());

    // Si hay IDs que no se encontraron, lanzar una excepción
    if (!notFoundIds.isEmpty()) {
      throw new EntityNotFoundException(
          "No se encontraron " + entityClass.getSimpleName() + "s con los siguientes IDs: " + notFoundIds);
    }

    return ResponseEntity.ok(entities);
  }

  public DTO mapper(E entity) {
    return modelMapper.map(entity, dtoClass);
  }
}
