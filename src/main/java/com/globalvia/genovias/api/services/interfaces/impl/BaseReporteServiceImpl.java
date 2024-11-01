package com.globalvia.genovias.api.services.interfaces.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

import com.globalvia.genovias.api.mapper.base.DetailsMapper;
import com.globalvia.genovias.api.models.base.Identificable;
import com.globalvia.genovias.api.models.base.Reporte;
import com.globalvia.genovias.api.response.enums.Estado;

public class BaseReporteServiceImpl<E extends Identificable<ID>, SD extends Reporte, DD extends Reporte, ID>
    extends BaseServiceImpl<E, SD, ID> {

  final JpaRepository<E, ID> repository;
  final ModelMapper modelMapper;
  final Class<SD> dtoClass;
  final DetailsMapper<E, DD, SD> detailsMapper; 

  public BaseReporteServiceImpl(Class<E> entityClass, Class<SD> dtoClass, JpaRepository<E, ID> repository,
      ModelMapper modelMapper, DetailsMapper<E, DD, SD> detailsMapper) {
    super(entityClass, dtoClass, repository, modelMapper);
    this.repository = repository;
    this.modelMapper = modelMapper;
    this.dtoClass = dtoClass;
    this.detailsMapper = detailsMapper;
    
  }

  @Override
  public ResponseEntity<Map<String, Object>> getAllEntities(int page, int size, String sortBy, String sortDirection) {
    Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
        : Sort.by(sortBy).descending();
    Pageable pageable = PageRequest.of(page, size, sort);

    // Convertir a SD y filtrar
    List<DD> listaFiltrada = repository.findAll(pageable).stream()
        .map(e -> detailsMapper.toDTO(e))
        .filter(d -> d.getEstado() == Estado.FINALIZADO)
        .collect(Collectors.toList());

    // Convertir de vuelta a Page
    Page<DD> pagedResult = new PageImpl<>(listaFiltrada, pageable, listaFiltrada.size());

    Map<String, Object> responseList = new HashMap<>();
    responseList.put("content", pagedResult.getContent());
    responseList.put("currentPage", pagedResult.getNumber());
    responseList.put("totalItems", pagedResult.getTotalElements());
    responseList.put("totalPages", pagedResult.getTotalPages());

    return ResponseEntity.ok(responseList);
  }
}
