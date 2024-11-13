package com.globalvia.genovias.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globalvia.genovias.api.models.dto.CamionetaDTO;
import com.globalvia.genovias.api.models.entities.Camioneta;
import com.globalvia.genovias.api.services.base.interfaces.BaseService;

@RestController
@RequestMapping(BaseEndpoint.BASE_ENDPOINT + "/camioneta")
public class CamionetaController extends BaseController<Camioneta, CamionetaDTO, String> {
  
  public CamionetaController(BaseService<Camioneta, CamionetaDTO, String> service) {
    super(service);
  }

}
