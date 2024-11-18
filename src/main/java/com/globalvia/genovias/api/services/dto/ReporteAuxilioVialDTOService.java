package com.globalvia.genovias.api.services.dto;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.globalvia.genovias.api.models.dto.DireccionDTO;
import com.globalvia.genovias.api.models.dto.ReporteAuxilioVialDTO;
import com.globalvia.genovias.api.models.dto.ResponsableDTO;
import com.globalvia.genovias.api.models.entities.Direccion;
import com.globalvia.genovias.api.models.entities.ReporteAuxilioVial;
import com.globalvia.genovias.api.models.entities.Responsable;
import com.globalvia.genovias.api.services.base.interfaces.BaseService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReporteAuxilioVialDTOService implements DTOProcessService<ReporteAuxilioVial, ReporteAuxilioVialDTO> {

  private final BaseService<Responsable, ResponsableDTO, Short> responsableService;

  private final BaseService<Direccion, DireccionDTO, Byte> direccionService;

  private final ModelMapper modelMapper;

  @Override
  public ReporteAuxilioVial postProcess(ReporteAuxilioVialDTO input, boolean isNew) {
    Responsable responsable = responsableService.findEntityById(input.getResponsableId()).getBody();
    Direccion direccion = direccionService.findEntityById(input.getDireccionId()).getBody();

    ReporteAuxilioVial reporteAuxilioVial = modelMapper.map(input, ReporteAuxilioVial.class);
      
    return reporteAuxilioVial.copyWith(ReporteAuxilioVial.builder().direccion(direccion).responsable(responsable).build());
  }
  
}
