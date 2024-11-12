package com.globalvia.genovias.api.services.dto;

import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.globalvia.genovias.api.models.dto.DireccionDTO;
import com.globalvia.genovias.api.models.dto.ReporteAccidenteDTO;
import com.globalvia.genovias.api.models.dto.ResponsableDTO;
import com.globalvia.genovias.api.models.dto.TipoAccidenteDTO;
import com.globalvia.genovias.api.models.dto.VehiculoDTO;
import com.globalvia.genovias.api.models.entities.Direccion;
import com.globalvia.genovias.api.models.entities.ReporteAccidente;
import com.globalvia.genovias.api.models.entities.Responsable;
import com.globalvia.genovias.api.models.entities.TipoAccidente;
import com.globalvia.genovias.api.models.entities.Vehiculo;
import com.globalvia.genovias.api.services.base.BaseCrudService;
import com.globalvia.genovias.api.validator.ReporteAccidenteValidator;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReporteAccidenteDTOProcess implements DTOProcessService<ReporteAccidente, ReporteAccidenteDTO> {

  private final BaseCrudService<Responsable, ResponsableDTO, Short> responsableCrudService;
  private final BaseCrudService<Vehiculo, VehiculoDTO, String> vehiculoCrudService;
  private final BaseCrudService<Direccion, DireccionDTO, Byte> direccionCrudService;
  private final BaseCrudService<TipoAccidente, TipoAccidenteDTO, Short> tipoCrudService;

  private final ModelMapper modelMapper;
  private final ReporteAccidenteValidator validator;

  @Override
  public ReporteAccidente postProcess(ReporteAccidenteDTO input, boolean isNew) {
    Set<Vehiculo> vehiculos = vehiculoCrudService.findAllEntitiesById(input.getVehiculosPlacas()).getBody();
    Responsable responsable = responsableCrudService.findEntityById(input.getResponsableId()).getBody();
    Direccion direccion = direccionCrudService.findEntityById(input.getDireccionId()).getBody();
    TipoAccidente tipoAccidente = tipoCrudService.findEntityById(input.getTipoAccidenteId()).getBody();

    ReporteAccidente reporteAccidente = modelMapper.map(input, ReporteAccidente.class);

    validator.buildValidator(reporteAccidente, isNew);

    return reporteAccidente
        .copyWith(
          ReporteAccidente.builder()
          .vehiculos(vehiculos)
          .responsable(responsable)
          .direccion(direccion)
          .tipoAccidente(tipoAccidente)
          .build());
    

  }

}
