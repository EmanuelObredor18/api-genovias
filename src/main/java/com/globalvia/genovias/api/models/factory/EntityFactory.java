package com.globalvia.genovias.api.models.factory;

import org.springframework.data.jpa.repository.JpaRepository;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class EntityFactory<E, ID> {
  private final JpaRepository<E, ID> repository;
  private final Class<E> entityClass;
}
