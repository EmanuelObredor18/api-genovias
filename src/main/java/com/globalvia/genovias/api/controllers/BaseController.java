package com.globalvia.genovias.api.controllers;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.globalvia.genovias.api.models.base.Identificable;
import com.globalvia.genovias.api.response.Response;
import com.globalvia.genovias.api.services.interfaces.impl.BaseServiceImpl;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BaseController<E extends Identificable<ID>, DTO, ID> {
  
  private final BaseServiceImpl<E, DTO, ID> service;

  @PostMapping("/nuevo")
  public ResponseEntity<Response> postEntity(DTO input) {
    return service.postEntity(input);
  }

  @GetMapping("/todos")
  public ResponseEntity<Map<String, Object>> getAllEntities(
    @RequestParam(defaultValue = "0") int page,
    @RequestParam(defaultValue = "10") int size,
    @RequestParam(defaultValue = "id") String sortBy,
    @RequestParam(defaultValue = "asc") String sortDirection) {
    return service.getAllEntities(page, size, sortBy, sortDirection);
  }

  @PutMapping("/editar")
  public ResponseEntity<Response> putEntity(@RequestBody DTO input) {
    return service.putEntity(input);
  }

  @DeleteMapping("/eliminarPorId/{id}")
  public ResponseEntity<Response> deleteEntityById(@PathVariable ID id) {
    return service.deleteEntityById(id);
  }

  @GetMapping("/buscarPorId/{id}")
  public ResponseEntity<Object> findEntityById(@PathVariable ID id) {
    return service.findEntityById(id);
  }
}
