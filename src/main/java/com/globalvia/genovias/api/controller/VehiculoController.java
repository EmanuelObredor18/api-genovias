package com.globalvia.genovias.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globalvia.genovias.api.models.dto.VehiculoDTO;
import com.globalvia.genovias.api.models.entities.Vehiculo;
import com.globalvia.genovias.api.models.projections.options.VehiculoOption;
import com.globalvia.genovias.api.repositories.OptionRepository;
import com.globalvia.genovias.api.services.base.interfaces.BaseService;

@RequestMapping(BaseEndpoint.BASE_ENDPOINT + "/vehiculo")
@RestController
public class VehiculoController extends OptionController<Vehiculo, VehiculoDTO, String> {
  
  public VehiculoController(BaseService<Vehiculo, VehiculoDTO, String> service, OptionRepository<Vehiculo, VehiculoOption, String> optionRepository) {
    super(service, optionRepository);
  }

}
