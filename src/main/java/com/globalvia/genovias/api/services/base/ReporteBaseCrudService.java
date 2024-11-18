package com.globalvia.genovias.api.services.base;

import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;

import com.globalvia.genovias.api.exceptions.EntityFoundException;
import com.globalvia.genovias.api.models.base.Copyable;
import com.globalvia.genovias.api.models.base.Dateable;
import com.globalvia.genovias.api.models.base.Identificable;
import com.globalvia.genovias.api.models.factory.EntityFactory;
import com.globalvia.genovias.api.repositories.ReporteRepository;
import com.globalvia.genovias.api.response.ResponseBody;
import com.globalvia.genovias.api.services.dto.DTOProcessService;
import com.globalvia.genovias.api.validator.base.ReporteValidator;

public class ReporteBaseCrudService<E extends Identificable<ID> & Copyable<E, ID>, DTO extends Identificable<ID> & Dateable, ID> extends BaseCrudService<E, DTO, ID> {
  
  private final ReporteValidator<E, ID> validator;
  private final ReporteRepository<E, ID> repository;

  public ReporteBaseCrudService(EntityFactory<E, ID> entityFactory, DTOProcessService<E, DTO> dtoProcessService, Class<DTO> dtoClass, ReporteValidator<E, ID> validator) {
    super(entityFactory, dtoProcessService, dtoClass);
    this.validator = validator;
    this.repository = (ReporteRepository<E, ID>) entityFactory.getRepository();
  }

  @Override
  public ResponseEntity<ResponseBody> postEntity(DTO input) throws EntityFoundException {
    validator.validateFecha(input.getFecha(), input.getHora());
    return super.postEntity(input);
  }

  public ResponseEntity<Set<DTO>> getAllByFecha(LocalDate fecha) {
    return ResponseEntity.ok().body(
      repository.findAllByFecha(fecha)
        .stream()
        .map(this::mapper)
        .collect(Collectors.toSet()
      )
    );
  }

}
