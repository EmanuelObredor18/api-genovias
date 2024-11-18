package com.globalvia.genovias.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globalvia.genovias.api.models.dto.ReporteDiarioDTO;
import com.globalvia.genovias.api.models.entities.ReporteDiario;
import com.globalvia.genovias.api.services.base.ReporteBaseCrudService;


@RestController
@RequestMapping(BaseEndpoint.BASE_ENDPOINT + "/reporteDiario")
public class ReporteDiarioController extends BaseReporteController<ReporteDiario, ReporteDiarioDTO, Long> {
  
  public ReporteDiarioController(ReporteBaseCrudService<ReporteDiario, ReporteDiarioDTO, Long> service) {
    super(service);
  }

}
