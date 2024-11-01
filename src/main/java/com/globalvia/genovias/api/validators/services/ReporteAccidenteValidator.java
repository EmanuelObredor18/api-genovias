package com.globalvia.genovias.api.validators.services;

import java.util.Set;
import java.util.stream.Collectors;

import com.globalvia.genovias.api.models.dto.simple.ReporteAccidenteDTO;
import com.globalvia.genovias.api.repositories.DireccionRepository;
import com.globalvia.genovias.api.repositories.ReporteAccidenteRepository;
import com.globalvia.genovias.api.repositories.VehiculoRepository;
import com.globalvia.genovias.api.response.enums.Estado;
import com.globalvia.genovias.api.validators.services.base.ServiceValidator;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ReporteAccidenteValidator implements ServiceValidator<ReporteAccidenteDTO> {

  private final DireccionRepository direccionRepository;
  private final VehiculoRepository vehiculoRepository;
  private final ReporteAccidenteRepository reporteAccidenteRepository;

  // Conjunto para almacenar los IDs de los vehículos no encontrados en la base de datos
  private Set<Long> idVehiculosNotFound;

  // Getter para el conjunto de IDs de vehículos no encontrados
  public Set<Long> getIdVehiculosNotFound() {
    return idVehiculosNotFound;
  }

  @Override
  public void validate(ReporteAccidenteDTO input, boolean isNew) {

    // Verificar si ya existe un reporte en proceso al agregar uno nuevo
    if (isNew && !reporteAccidenteRepository.findByEstado(Estado.EN_PROCESO).isEmpty()) {
      throw new RuntimeException("Imposible agregar o editar un nuevo reporte. Existe un reporte en proceso. Primero finalice dicho reporte antes de agregar uno nuevo.");
    }

    // Verificar si ya existe un reporte con la misma fecha al agregar uno nuevo
    if (isNew && reporteAccidenteRepository.existsByFecha(input.getFecha())) {
      throw new EntityNotFoundException("Imposible agregar o editar un nuevo reporte. Ya existe un reporte idéntico. Pruebe con modificarlo");
    }

    // Verificar si el reporte existe en la base de datos al editar
    if (!isNew && !reporteAccidenteRepository.existsById(input.getId())) {
      throw new EntityNotFoundException("Entidad no encontrada en la BD");
    }
    
    // Verificar si la dirección existe en la base de datos
    if (!direccionRepository.existsById(input.getDireccionId())) {
      throw new EntityNotFoundException("Imposible agregar o editar un nuevo reporte. La dirección no existen en la base de datos.");
    }

    // Recopilar IDs de vehículos no encontrados en la base de datos
    idVehiculosNotFound = input.getVehiculosId().stream()
        .filter(id -> !vehiculoRepository.existsById(id))
        .collect(Collectors.toSet());

    // Si no se encuentran todos los vehículos, lanzar una excepción
    if (idVehiculosNotFound.size() == input.getVehiculosId().size()) {
      throw new EntityNotFoundException("Imposible agregar o editar un nuevo reporte. Los vehículos no existen en la base de datos.");
    }
  }  
  
}
