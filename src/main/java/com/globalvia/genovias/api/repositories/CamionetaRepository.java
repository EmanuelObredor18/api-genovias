package com.globalvia.genovias.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.globalvia.genovias.api.models.entities.Camioneta;

public interface CamionetaRepository extends JpaRepository<Camioneta, String> {
  
}
