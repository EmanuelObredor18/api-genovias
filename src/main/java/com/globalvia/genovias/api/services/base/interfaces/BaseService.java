package com.globalvia.genovias.api.services.base.interfaces;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

import com.globalvia.genovias.api.exceptions.EntityFoundException;
import com.globalvia.genovias.api.exceptions.EntityNotFoundException;
import com.globalvia.genovias.api.models.base.Copyable;
import com.globalvia.genovias.api.models.base.Identificable;
import com.globalvia.genovias.api.response.ResponseBody;

public interface BaseService<E extends Identificable<ID> & Copyable<E, ID>, DTO extends Identificable<ID>, ID> {
  
  @Transactional
  public ResponseEntity<ResponseBody> postEntity(DTO input) throws EntityFoundException;

  @Transactional
  public ResponseEntity<ResponseBody> updateEntityById(DTO input, ID id) throws EntityNotFoundException;

  @Transactional
  public ResponseEntity<String> deleteEntityById(ID id);

  public ResponseEntity<Map<String, Object>> getAllEntities(int size, int page, String sortDirection, String sortBy);
  
  public ResponseEntity<E> findEntityById(ID id);

  public ResponseEntity<Set<E>> findAllEntitiesById(Collection<ID> ids);
}
