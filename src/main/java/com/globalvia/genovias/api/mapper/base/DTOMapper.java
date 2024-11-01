package com.globalvia.genovias.api.mapper.base;

public interface DTOMapper<E, DTO> {
  DTO toDTO(E entity);
}
