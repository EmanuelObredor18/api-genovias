package com.globalvia.genovias.api.repositories;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface OptionRepository<E, DTO, ID> extends JpaRepository<E, ID> {
  Set<DTO> getOptions();
}
