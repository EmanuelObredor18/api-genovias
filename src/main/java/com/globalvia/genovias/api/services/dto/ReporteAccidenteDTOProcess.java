package com.globalvia.genovias.api.services.dto;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

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
import com.globalvia.genovias.api.services.base.interfaces.BaseService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReporteAccidenteDTOProcess implements DTOProcessService<ReporteAccidente, ReporteAccidenteDTO> {

  private final BaseService<Responsable, ResponsableDTO, Short> responsableCrudService;
  private final BaseService<Vehiculo, VehiculoDTO, String> vehiculoCrudService;
  private final BaseService<Direccion, DireccionDTO, Byte> direccionCrudService;
  private final BaseService<TipoAccidente, TipoAccidenteDTO, Short> tipoCrudService;

  private final ModelMapper modelMapper;

  @Override
  public ReporteAccidente postProcess(ReporteAccidenteDTO input, boolean isNew) {
    // Ejecutar llamadas a servicios en paralelo utilizando CompletableFuture
    CompletableFuture<Set<Vehiculo>> vehiculosFuture = CompletableFuture.supplyAsync(() -> 
      vehiculoCrudService.findAllEntitiesById(input.getVehiculosPlacas()).getBody()
    );
    
    CompletableFuture<Responsable> responsableFuture = CompletableFuture.supplyAsync(() -> 
      responsableCrudService.findEntityById(input.getResponsableId()).getBody()
    );
    
    CompletableFuture<Direccion> direccionFuture = CompletableFuture.supplyAsync(() -> 
      direccionCrudService.findEntityById(input.getDireccionId()).getBody()
    );
    
    CompletableFuture<TipoAccidente> tipoAccidenteFuture = CompletableFuture.supplyAsync(() -> 
      tipoCrudService.findEntityById(input.getTipoAccidenteId()).getBody()
    );

    // Esperar a que todas las llamadas completen
    CompletableFuture.allOf(vehiculosFuture, responsableFuture, direccionFuture, tipoAccidenteFuture).join();

    // Obtener resultados de las llamadas asincrónicas
    Set<Vehiculo> vehiculos = vehiculosFuture.join();
    Responsable responsable = responsableFuture.join();
    Direccion direccion = direccionFuture.join();
    TipoAccidente tipoAccidente = tipoAccidenteFuture.join();

    // Mapea el DTO a la entidad
    ReporteAccidente reporteAccidente = modelMapper.map(input, ReporteAccidente.class);
    
    // Usa el método copyWith para establecer las entidades relacionadas
    return reporteAccidente.copyWith(
          ReporteAccidente.builder()
          .vehiculos(vehiculos)
          .responsable(responsable)
          .direccion(direccion)
          .tipoAccidente(tipoAccidente)
          .build());
  }

}
