package com.globalvia.genovias.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globalvia.genovias.api.models.dto.ReporteDiarioDTO;
import com.globalvia.genovias.api.models.entities.ReporteDiario;
import com.globalvia.genovias.api.services.base.BaseCrudService;

@RestController
@RequestMapping("/api/v0/reporteDiario")
public class ReporteDiarioController extends BaseController<ReporteDiario, ReporteDiarioDTO, Long> {
  
  public ReporteDiarioController(BaseCrudService<ReporteDiario, ReporteDiarioDTO, Long> baseCrudService) {
    super(baseCrudService);
  }

}
