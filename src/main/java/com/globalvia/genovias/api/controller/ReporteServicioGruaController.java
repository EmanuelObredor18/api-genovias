package com.globalvia.genovias.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globalvia.genovias.api.models.dto.ReporteServicioGruaDTO;
import com.globalvia.genovias.api.models.entities.ReporteServicioGrua;
import com.globalvia.genovias.api.services.base.BaseCrudService;

@RestController
@RequestMapping("api/v0/servicioGrua")
public class ReporteServicioGruaController extends BaseController<ReporteServicioGrua, ReporteServicioGruaDTO, Long> {
  
  public ReporteServicioGruaController(BaseCrudService<ReporteServicioGrua, ReporteServicioGruaDTO, Long> baseCrudService) {
    super(baseCrudService);
  }

}
