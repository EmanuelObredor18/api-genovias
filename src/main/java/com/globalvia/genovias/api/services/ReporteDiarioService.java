package com.globalvia.genovias.api.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.globalvia.genovias.api.models.dto.ReporteDiarioDTO;
import com.globalvia.genovias.api.models.entities.ReporteDiario;
import com.globalvia.genovias.api.models.factory.EntityFactory;
import com.globalvia.genovias.api.services.base.BaseCrudService;
import com.globalvia.genovias.api.services.dto.DTOProcessService;

@Primary
@Service
public class ReporteDiarioService extends BaseCrudService<ReporteDiario, ReporteDiarioDTO, Long> {

  public ReporteDiarioService(EntityFactory<ReporteDiario, Long> entityFactory, DTOProcessService<ReporteDiario, ReporteDiarioDTO> dtoProcessService) {
    super(entityFactory, dtoProcessService, ReporteDiarioDTO.class);
  }

}
