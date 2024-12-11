package com.globalvia.genovias.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.globalvia.genovias.api.models.dto.ResponsableDTO;
import com.globalvia.genovias.api.models.entities.Responsable;
import com.globalvia.genovias.api.repositories.ResponsableRepository;
import com.globalvia.genovias.api.services.ResponsableService;
import com.globalvia.genovias.api.services.base.interfaces.BaseService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping(BaseEndpoint.BASE_ENDPOINT + "/responsable")
public class ResponsableController extends OptionController<Responsable, ResponsableDTO, Short>{
  
  private final ResponsableService service;

  public ResponsableController(BaseService<Responsable, ResponsableDTO, Short> service, ResponsableRepository repository) {
    super(service, repository);
    this.service = (ResponsableService) service;
  }
  
  @GetMapping("/findByUserUsername")
  public ResponseEntity<ResponsableDTO> getByUserUsername(@Valid @NotBlank @RequestParam(required = true) String username) {
      return service.findByUserEntity(username);
  }
  

}
