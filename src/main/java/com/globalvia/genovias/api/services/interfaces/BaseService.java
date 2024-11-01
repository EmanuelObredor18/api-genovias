package com.globalvia.genovias.api.services.interfaces;

import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.globalvia.genovias.api.response.Response;

public interface BaseService<DTO, ID> {
  
  ResponseEntity<Response> postEntity(DTO input);

  ResponseEntity<Map<String, Object>> getAllEntities(int page, int size, String sortBy, String sortDirection);

  ResponseEntity<Response> putEntity(DTO input);

  ResponseEntity<Response> deleteEntityById(ID id);

  ResponseEntity<Object> findEntityById(ID id);
}
