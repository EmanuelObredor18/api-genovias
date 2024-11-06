package com.globalvia.genovias.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globalvia.genovias.api.models.dto.VehiculoDTO;
import com.globalvia.genovias.api.models.entities.Vehiculo;
import com.globalvia.genovias.api.services.BaseService;

@RequestMapping("/api/v0/vehiculo")
@RestController
public class VehiculoController extends BaseController<Vehiculo, VehiculoDTO, String> {
  
  public VehiculoController(BaseService<Vehiculo, VehiculoDTO, String> service) {
    super(service);
  }

}