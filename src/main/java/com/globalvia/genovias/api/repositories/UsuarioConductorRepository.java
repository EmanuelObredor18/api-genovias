package com.globalvia.genovias.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.globalvia.genovias.api.models.entities.UsuarioConductor;
import java.util.Optional;


public interface UsuarioConductorRepository extends JpaRepository<UsuarioConductor, Long> {
  
  Optional<UsuarioConductor> findByNombreAndApellidoAndCedula(String nombre, String apellido, String cedula);

}
