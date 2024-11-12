package com.globalvia.genovias.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globalvia.genovias.api.models.dto.UsuarioConductorDTO;
import com.globalvia.genovias.api.models.entities.UsuarioConductor;
import com.globalvia.genovias.api.services.base.interfaces.BaseService;

@RestController
@RequestMapping(BaseEndpoint.BASE_ENDPOINT + "/usuarioConductor")
public class UsuarioConductorController extends BaseController<UsuarioConductor, UsuarioConductorDTO, Long> {
  public UsuarioConductorController(BaseService<UsuarioConductor, UsuarioConductorDTO, Long> usuarioService) {
    super(usuarioService);
  }
}
