package com.globalvia.genovias.api.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globalvia.genovias.api.models.dto.ReporteServicioGruaDTO;
import com.globalvia.genovias.api.models.entities.ReporteServicioGrua;
import com.globalvia.genovias.api.services.base.interfaces.BaseService;

@RestController
@RequestMapping(BaseEndpoint.BASE_ENDPOINT + "/servicioGrua")
public class ReporteServicioGruaController extends BaseController<ReporteServicioGrua, ReporteServicioGruaDTO, Long> {
  
  public ReporteServicioGruaController(@Qualifier("reporteServicioGruaBaseService") BaseService<ReporteServicioGrua, ReporteServicioGruaDTO, Long> service) {
    super(service);
  }

}
