package com.globalvia.genovias.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globalvia.genovias.api.models.dto.ResponsableDTO;
import com.globalvia.genovias.api.models.entities.Responsable;
import com.globalvia.genovias.api.services.base.interfaces.BaseService;

@RestController
@RequestMapping(BaseEndpoint.BASE_ENDPOINT + "/responsable")
public class ResponsableController extends BaseController<Responsable, ResponsableDTO, Short>{
  
  public ResponsableController(BaseService<Responsable, ResponsableDTO, Short> service) {
    super(service);
  }
  
}
