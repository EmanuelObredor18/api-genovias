package com.globalvia.genovias.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globalvia.genovias.api.models.dto.ReporteAccidenteDTO;
import com.globalvia.genovias.api.models.entities.ReporteAccidente;
import com.globalvia.genovias.api.services.base.BaseCrudService;

@RequestMapping("/api/v0/reporteAccidente")
@RestController
public class ReporteAccidenteController extends BaseController<ReporteAccidente, ReporteAccidenteDTO, Long> {
  
  public ReporteAccidenteController(BaseCrudService<ReporteAccidente, ReporteAccidenteDTO, Long> service) {
    super(service);
  }

}
