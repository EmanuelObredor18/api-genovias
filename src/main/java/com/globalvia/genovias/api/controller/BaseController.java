package com.globalvia.genovias.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.globalvia.genovias.api.models.base.Identificable;
import com.globalvia.genovias.api.response.ResponseBody;
import com.globalvia.genovias.api.services.BaseService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BaseController<E extends Identificable<ID>, DTO extends Identificable<ID>, ID> {
  
  private final BaseService<E, DTO, ID> service;

  @PostMapping("/post/new")
  public ResponseEntity<ResponseBody> postEntity(@Valid @RequestBody DTO input) {
    return service.postEntity(input);
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<String> deleteEntityById(@PathVariable(required = true) ID id) {
    return service.deleteEntityById(id);
  }

  @PutMapping("/updateById/{id}")
  public ResponseEntity<ResponseBody> putEntity(@Valid @RequestBody DTO input, @PathVariable(required = true) ID id) {
    return service.updateEntityById(input, id);
  }
}
