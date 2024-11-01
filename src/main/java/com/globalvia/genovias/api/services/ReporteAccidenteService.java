package com.globalvia.genovias.api.services;

import java.util.Set;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.globalvia.genovias.api.mapper.ReporteAccidenteMapper;
import com.globalvia.genovias.api.models.dto.detailed.ReporteAccidenteDetailsDTO;
import com.globalvia.genovias.api.models.dto.simple.ReporteAccidenteDTO;
import com.globalvia.genovias.api.models.entities.ReporteAccidente;
import com.globalvia.genovias.api.models.entities.Vehiculo;
import com.globalvia.genovias.api.repositories.DireccionRepository;
import com.globalvia.genovias.api.repositories.ReporteAccidenteRepository;
import com.globalvia.genovias.api.repositories.VehiculoRepository;
import com.globalvia.genovias.api.response.Response;
import com.globalvia.genovias.api.response.enums.Estado;
import com.globalvia.genovias.api.services.interfaces.impl.BaseReporteServiceImpl;
import com.globalvia.genovias.api.validators.services.ReporteAccidenteValidator;
import com.globalvia.genovias.api.validators.services.base.ServiceValidator;

@Service
public class ReporteAccidenteService extends BaseReporteServiceImpl<ReporteAccidente, ReporteAccidenteDTO, ReporteAccidenteDetailsDTO, Long> {
    
    private final ReporteAccidenteValidator childrenValidator;
    private final VehiculoRepository vehiculoRepository;
    private final ModelMapper modelMapper;
    private final ReporteAccidenteRepository reporteAccidenteRepository;

    // Constructor de la clase, inicializa los repositorios y validadores
    public ReporteAccidenteService(
        JpaRepository<ReporteAccidente, Long> repository,
        ModelMapper modelMapper,
        DireccionRepository direccionRepository,
        VehiculoRepository vehiculoRepository,
        ServiceValidator<ReporteAccidenteDTO> childrenValidator,
        ReporteAccidenteRepository reporteAccidenteRepository,
        ReporteAccidenteMapper reporteAccidenteMapper) {
        
        super(ReporteAccidente.class, ReporteAccidenteDTO.class, repository, modelMapper, reporteAccidenteMapper);
        this.childrenValidator = (ReporteAccidenteValidator) childrenValidator;
        this.vehiculoRepository = vehiculoRepository;
        this.modelMapper = modelMapper;
        this.reporteAccidenteRepository = reporteAccidenteRepository;
    }

    @Override
    public ResponseEntity<Response> postEntity(ReporteAccidenteDTO input) {
        input.setId(null); // Asegura que el ID sea nulo para que la base de datos lo genere automáticamente
        Response response = processEntity(input, true);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    
    // Método principal para procesar la entidad
    private Response processEntity(ReporteAccidenteDTO input, boolean isNew) {
        childrenValidator.validate(input, isNew); // Valida la entidad DTO
        Set<Vehiculo> vehiculos = getVehiculosFromIds(input.getVehiculosId()); // Obtiene los vehículos por sus IDs
        ReporteAccidente reporteAccidente = mapToEntity(input, vehiculos); // Mapea el DTO a la entidad ReporteAccidente
        setEstadoAndSave(reporteAccidente); // Establece el estado y guarda la entidad
        return buildResponse(reporteAccidente, isNew); // Construye la respuesta
    }

    // Método para obtener vehículos a partir de sus IDs
    private Set<Vehiculo> getVehiculosFromIds(Set<Long> vehiculosIds) {
        return vehiculosIds.stream()
            .map(id -> vehiculoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Vehiculo no encontrado: " + id)))
            .collect(Collectors.toSet());
    }

    // Método para mapear DTO a entidad
    private ReporteAccidente mapToEntity(ReporteAccidenteDTO dto, Set<Vehiculo> vehiculos) {
        ReporteAccidente reporteAccidente = modelMapper.map(dto, ReporteAccidente.class);
        reporteAccidente.setVehiculos(vehiculos); // Asocia los vehículos obtenidos a la entidad
        return reporteAccidente;
    }

    // Método para establecer el estado y guardar la entidad
    private void setEstadoAndSave(ReporteAccidente reporteAccidente) {
        if (reporteAccidente.getVehiculos().isEmpty()) {
            reporteAccidente.setEstado(Estado.FINALIZADO); // Finaliza si no hay vehículos
        } else {
            reporteAccidente.setEstado(Estado.EN_PROCESO); // Establece en proceso si hay vehículos
        }
        reporteAccidenteRepository.save(reporteAccidente); // Guarda la entidad en el repositorio
    }

    // Método para construir la respuesta
    private Response buildResponse(ReporteAccidente reporteAccidente, boolean isNew) {
        HttpStatus status = isNew ? HttpStatus.CREATED : HttpStatus.OK;
        return new Response(status, reporteAccidente.getEstado(), reporteAccidente.getEstado() == Estado.FINALIZADO ? "Finalizado" : "En proceso");
    }

    @Override
    public ResponseEntity<Response> putEntity(ReporteAccidenteDTO input) {
        Response response = processEntity(input, false);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
