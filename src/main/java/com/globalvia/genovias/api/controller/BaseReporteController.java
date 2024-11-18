package com.globalvia.genovias.api.controller;

import java.time.LocalDate;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.globalvia.genovias.api.models.base.Copyable;
import com.globalvia.genovias.api.models.base.Dateable;
import com.globalvia.genovias.api.models.base.Identificable;
import com.globalvia.genovias.api.services.base.ReporteBaseCrudService;

public class BaseReporteController<E extends Identificable<ID> & Copyable<E, ID>, DTO extends Identificable<ID> & Dateable, ID> extends BaseController<E, DTO, ID> {
  
  private final ReporteBaseCrudService<E, DTO, ID> service;

  public BaseReporteController(ReporteBaseCrudService<E, DTO, ID> service) {
    super(service);
    this.service = service;
  }

  @GetMapping("/getByFecha")
  public ResponseEntity<Set<DTO>> getEntityByFecha(@RequestParam(required = true) @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate fecha) {

    return service.getAllByFecha(fecha);

  }

}
