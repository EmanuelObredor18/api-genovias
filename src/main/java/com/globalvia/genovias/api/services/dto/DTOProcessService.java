package com.globalvia.genovias.api.services.dto;

public interface DTOProcessService<E, DTO> {
  
  E postProcess(DTO input, boolean isNew);

  default void deleteProcess(DTO input) {};
}
