package com.globalvia.genovias.api.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globalvia.genovias.api.models.dto.ReporteAuxilioVialDTO;
import com.globalvia.genovias.api.models.entities.ReporteAuxilioVial;
import com.globalvia.genovias.api.services.base.interfaces.BaseService;

@RequestMapping(BaseEndpoint.BASE_ENDPOINT + "/reporteAuxilioVial")
@RestController
public class ReporteAuxilioVialController extends BaseController<ReporteAuxilioVial, ReporteAuxilioVialDTO, Long> {
  
  public ReporteAuxilioVialController(@Qualifier("reporteAuxilioVialBaseService") BaseService<ReporteAuxilioVial, ReporteAuxilioVialDTO, Long> service) {
    super(service);
  } 

}
