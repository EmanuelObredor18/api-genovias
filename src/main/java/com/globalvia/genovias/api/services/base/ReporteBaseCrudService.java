package com.globalvia.genovias.api.services.base;

import org.springframework.http.ResponseEntity;

import com.globalvia.genovias.api.exceptions.EntityFoundException;
import com.globalvia.genovias.api.models.base.Copyable;
import com.globalvia.genovias.api.models.base.Dateable;
import com.globalvia.genovias.api.models.base.Identificable;
import com.globalvia.genovias.api.models.factory.EntityFactory;
import com.globalvia.genovias.api.response.ResponseBody;
import com.globalvia.genovias.api.services.dto.DTOProcessService;
import com.globalvia.genovias.api.validator.base.ReporteValidator;

public class ReporteBaseCrudService<E extends Identificable<ID> & Copyable<E, ID>, DTO extends Identificable<ID> & Dateable, ID> extends BaseCrudService<E, DTO, ID> {
  
  private final ReporteValidator<E, ID> validator;

  public ReporteBaseCrudService(EntityFactory<E, ID> entityFactory, DTOProcessService<E, DTO> dtoProcessService, Class<DTO> dtoClass, ReporteValidator<E, ID> validator) {
    super(entityFactory, dtoProcessService, dtoClass);
    this.validator = validator;
  }

  public ReporteBaseCrudService(EntityFactory<E, ID> entityFactory, DTOProcessService<E, DTO> dtoProcessService, ReporteValidator<E, ID> validator) {
    super(entityFactory, dtoProcessService);
    this.validator = validator;
  }

  @Override
  public ResponseEntity<ResponseBody> postEntity(DTO input) throws EntityFoundException {
    validator.validateFecha(input.getFecha());
    return super.postEntity(input);
  }

}
