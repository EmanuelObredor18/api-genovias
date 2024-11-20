package com.globalvia.genovias.api.services;

import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.globalvia.genovias.api.exceptions.EntityNotFoundException;
import com.globalvia.genovias.api.models.dto.ResponsableDTO;
import com.globalvia.genovias.api.models.entities.Responsable;
import com.globalvia.genovias.api.models.factory.EntityFactory;
import com.globalvia.genovias.api.repositories.ResponsableRepository;
import com.globalvia.genovias.api.services.base.BaseCrudService;

@Service
@Primary
public class ResponsableService extends BaseCrudService<Responsable, ResponsableDTO, Short> {

  private final ResponsableRepository repository;

  public ResponsableService(EntityFactory<Responsable, Short> entityFactory) {
    super(entityFactory, null, ResponsableDTO.class);
    this.repository = (ResponsableRepository) entityFactory.getRepository();
  }

  public ResponseEntity<ResponsableDTO> findByUserEntity(String username) {
    return ResponseEntity.ok()
      .body(
        modelMapper.map(
          repository.findByUserEntityUsername(username)
            .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado")), 
          ResponsableDTO.class
        )
      );

  }
}
