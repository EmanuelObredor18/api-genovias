package com.globalvia.genovias.api.controller;

import java.util.Set;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.globalvia.genovias.api.models.base.Copyable;
import com.globalvia.genovias.api.models.base.Identificable;
import com.globalvia.genovias.api.repositories.OptionRepository;
import com.globalvia.genovias.api.services.base.interfaces.BaseService;

public class OptionController<E extends Identificable<ID> & Copyable<E,ID>, DTO extends Identificable<ID>, ID> extends BaseController<E, DTO, ID> {
  
  private final OptionRepository<?, ?, ?> optionRepository;

  public OptionController(BaseService<E, DTO, ID> service, OptionRepository<?, ?, ?> optionRepository) {
    super(service);
    this.optionRepository = optionRepository;
  }

  @GetMapping("/get/options")
  public ResponseEntity<Set<?>> getOptions() {
    return ResponseEntity.ok().body(optionRepository.getOptions());
  }
}
