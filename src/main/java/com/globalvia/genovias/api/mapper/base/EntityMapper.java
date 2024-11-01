package com.globalvia.genovias.api.mapper.base;

public interface EntityMapper<E, DTO> {
  E toEntity(DTO dto);
}
