package com.globalvia.genovias.api.services.dto;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.globalvia.genovias.api.models.dto.CamionetaDTO;
import com.globalvia.genovias.api.models.dto.ReporteDiarioDTO;
import com.globalvia.genovias.api.models.entities.Camioneta;
import com.globalvia.genovias.api.models.entities.ReporteDiario;
import com.globalvia.genovias.api.services.base.interfaces.BaseService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReporteDiarioDTOProcess implements DTOProcessService<ReporteDiario, ReporteDiarioDTO> {

  private final BaseService<Camioneta, CamionetaDTO, String> camionetaService; 
  private final ModelMapper modelMapper;

  @Override
  public ReporteDiario postProcess(ReporteDiarioDTO input, boolean isNew) {
    
    Camioneta camioneta = camionetaService.findEntityById(input.getCamionetaPlaca()).getBody();
    Camioneta camionetaCopy = camioneta.copyWith(Camioneta.builder().kilometraje(input.getKilometrajeSalida()).build());
    camionetaService.updateEntityById(modelMapper.map(camionetaCopy, CamionetaDTO.class), camionetaCopy.getPlaca());

    ReporteDiario reporteDiario = modelMapper.map(input, ReporteDiario.class);
    return reporteDiario.copyWith(ReporteDiario.builder().camioneta(camioneta).build());
    
  }

  @Override
  public void deleteProcess(ReporteDiarioDTO input) {
    Camioneta camioneta = camionetaService.findEntityById(input.getCamionetaPlaca()).getBody();

    Camioneta camionetaCopy = camioneta.copyWith(Camioneta.builder().kilometraje(camioneta.getKilometraje() - input.getKilometrajeSalida()).build());

    camionetaService.updateEntityById(modelMapper.map(camionetaCopy, CamionetaDTO.class), camionetaCopy.getId());
  }
  
}
