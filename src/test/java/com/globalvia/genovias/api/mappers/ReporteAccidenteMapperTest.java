package com.globalvia.genovias.api.mappers;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cglib.core.Local;

import com.globalvia.genovias.api.mapper.ReporteAccidenteMapper;
import com.globalvia.genovias.api.models.dto.detailed.ReporteAccidenteDetailsDTO;
import com.globalvia.genovias.api.models.dto.simple.ReporteAccidenteDTO;
import com.globalvia.genovias.api.models.entities.Direccion;
import com.globalvia.genovias.api.models.entities.PuntoReferencia;
import com.globalvia.genovias.api.models.entities.ReporteAccidente;
import com.globalvia.genovias.api.models.entities.UsuarioConductor;
import com.globalvia.genovias.api.models.entities.Vehiculo;

@SpringBootTest
public class ReporteAccidenteMapperTest {

  @Autowired
  private ReporteAccidenteMapper reporteAccidenteMapper;

  private ReporteAccidente reporteAccidente;

  private ReporteAccidenteDetailsDTO reporteAccidenteDetailsDTO;

  @BeforeEach
  public void setUp() {
    reporteAccidente = ReporteAccidente.builder()
        .vehiculos(
            Arrays.asList(
              Vehiculo.builder()
                .id(1L)
                .placa("ASD-123")
                .usuarioConductor(UsuarioConductor.builder()
                    .nombre("Emanuel")
                    .apellido("Obredor")
                    .cedula("1043662882")
                    .id(1L)
                    .build())
                .build())
            .stream().collect(Collectors.toSet()))
        .fecha(LocalDateTime.now())
        .direccion(Direccion.builder()
          .id((byte) 1)
          .calle("38")
          .carrera("15")
          .puntoReferencia(PuntoReferencia.builder()
            .nombre("Glorieta 37")
            .id((byte) 1)
            .build())
          .build())
        .build();
  }

  @Test
  public void test() {
    System.out.println();

    ReporteAccidenteDetailsDTO reporteAccidenteDetailsDTO = reporteAccidenteMapper.toDTO(reporteAccidente);

    ReporteAccidenteDTO reporteAccidenteDTO = ReporteAccidenteDTO.builder()
      .direccionId((byte) 1)
      .fecha(LocalDateTime.now())
      .id(1L)
      .vehiculosId(Arrays.asList(1L, 2L).stream().collect(Collectors.toSet()))
      .build();

    System.out.println(reporteAccidenteMapper.toEntity(reporteAccidenteDTO));
  }
}
