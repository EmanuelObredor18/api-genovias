package com.globalvia.genovias.api.auth.repository;

import org.springframework.data.repository.CrudRepository;
import com.globalvia.genovias.api.auth.model.RoleEntity;

import java.util.List;

public interface RoleRepository extends CrudRepository<RoleEntity, Long> {
  
    List<RoleEntity> findAllByRoleNameIn(List<String> roleNames);
}
