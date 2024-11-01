package com.globalvia.genovias.api.config;

import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.globalvia.genovias.api.models.dto.simple.ReporteAccidenteDTO;
import com.globalvia.genovias.api.models.entities.ReporteAccidente;
import com.globalvia.genovias.api.models.entities.Vehiculo;
@Configuration
public class ModelMapperConfig {

    @Bean
    ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        
        modelMapper.typeMap(ReporteAccidente.class, ReporteAccidenteDTO.class)
            .addMappings(mapper -> mapper.using(ctx -> {
                @SuppressWarnings("unchecked")
                Set<Vehiculo> vehiculos = (Set<Vehiculo>) ctx.getSource();
                return vehiculos == null ? null : vehiculos.stream().map(Vehiculo::getId).collect(Collectors.toSet());
            }).map(ReporteAccidente::getVehiculos, ReporteAccidenteDTO::setVehiculosId));
        
        return modelMapper;
    }
}
