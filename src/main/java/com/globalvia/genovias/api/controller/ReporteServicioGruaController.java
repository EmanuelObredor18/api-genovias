package com.globalvia.genovias.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globalvia.genovias.api.models.dto.ReporteServicioGruaDTO;
import com.globalvia.genovias.api.models.entities.ReporteServicioGrua;
import com.globalvia.genovias.api.services.base.ReporteBaseCrudService;

@RestController
@RequestMapping(BaseEndpoint.BASE_ENDPOINT + "/servicioGrua")
public class ReporteServicioGruaController extends BaseReporteController<ReporteServicioGrua, ReporteServicioGruaDTO, Long> {
  
  public ReporteServicioGruaController(ReporteBaseCrudService<ReporteServicioGrua, ReporteServicioGruaDTO, Long> service) {
    super(service);
  }

}
