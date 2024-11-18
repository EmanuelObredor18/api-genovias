package com.globalvia.genovias.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globalvia.genovias.api.models.dto.ReporteAuxilioVialDTO;
import com.globalvia.genovias.api.models.entities.ReporteAuxilioVial;
import com.globalvia.genovias.api.services.base.ReporteBaseCrudService;


@RequestMapping(BaseEndpoint.BASE_ENDPOINT + "/reporteAuxilioVial")
@RestController
public class ReporteAuxilioVialController extends BaseReporteController<ReporteAuxilioVial, ReporteAuxilioVialDTO, Long> {
  
  public ReporteAuxilioVialController(ReporteBaseCrudService<ReporteAuxilioVial, ReporteAuxilioVialDTO, Long> service) {
    super(service);
  } 

}
