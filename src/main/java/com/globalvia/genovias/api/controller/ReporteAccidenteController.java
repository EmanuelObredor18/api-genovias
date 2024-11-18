package com.globalvia.genovias.api.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globalvia.genovias.api.models.dto.ReporteAccidenteDTO;
import com.globalvia.genovias.api.models.entities.ReporteAccidente;
import com.globalvia.genovias.api.services.base.ReporteBaseCrudService;

@RequestMapping(BaseEndpoint.BASE_ENDPOINT + "/reporteAccidente")
@RestController
public class ReporteAccidenteController extends BaseReporteController<ReporteAccidente, ReporteAccidenteDTO, Long> {
  
  public ReporteAccidenteController(@Qualifier("reporteAccidenteBaseService") ReporteBaseCrudService<ReporteAccidente, ReporteAccidenteDTO, Long> service) {
    super(service);
  }

}
