package com.globalvia.genovias.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globalvia.genovias.api.models.dto.simple.ReporteAccidenteDTO;
import com.globalvia.genovias.api.models.entities.ReporteAccidente;
import com.globalvia.genovias.api.services.ReporteAccidenteService;

@RequestMapping("api/v0/reporteAccidente")
@RestController
public class ReporteAccidenteController extends BaseController<ReporteAccidente, ReporteAccidenteDTO, Long> {
  
  public ReporteAccidenteController(ReporteAccidenteService service) {
    super(service);
  }

  
}
