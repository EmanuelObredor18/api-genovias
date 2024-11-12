package com.globalvia.genovias.api.services.dto;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.globalvia.genovias.api.models.dto.CamionetaDTO;
import com.globalvia.genovias.api.models.dto.ReporteDiarioDTO;
import com.globalvia.genovias.api.models.entities.Camioneta;
import com.globalvia.genovias.api.models.entities.ReporteDiario;
import com.globalvia.genovias.api.services.base.BaseCrudService;
import com.globalvia.genovias.api.validator.ReporteDiarioValidator;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReporteDiarioDTOProcess implements DTOProcessService<ReporteDiario, ReporteDiarioDTO> {

  private final BaseCrudService<Camioneta, CamionetaDTO, String> camionetaService; 
  private final ModelMapper modelMapper;
  private final ReporteDiarioValidator reporteDiarioValidator;

  @Override
  public ReporteDiario postProcess(ReporteDiarioDTO input, boolean isNew) {
    
    Camioneta camioneta = camionetaService.findEntityById(input.getCamionetaPlaca()).getBody();
    Camioneta camionetaCopy = camioneta.copyWith(Camioneta.builder().kilometraje(input.getKilometrajeSalida()).build());
    camionetaService.updateEntityById(modelMapper.map(camionetaCopy, CamionetaDTO.class), camionetaCopy.getPlaca());

    ReporteDiario reporteDiario = modelMapper.map(input, ReporteDiario.class);

    reporteDiarioValidator.buildValidator(reporteDiario, isNew);

    return reporteDiario.copyWith(ReporteDiario.builder().camioneta(camioneta).build());
    
  }

  @Override
  public void deleteProcess(ReporteDiarioDTO input) {
    Camioneta camioneta = camionetaService.findEntityById(input.getCamionetaPlaca()).getBody();

    Camioneta camionetaCopy = camioneta.copyWith(Camioneta.builder().kilometraje(camioneta.getKilometraje() - input.getKilometrajeSalida()).build());

    camionetaService.updateEntityById(modelMapper.map(camionetaCopy, CamionetaDTO.class), camionetaCopy.getId());
  }
  
}
