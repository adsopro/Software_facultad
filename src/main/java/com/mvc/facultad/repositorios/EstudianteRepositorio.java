
package com.mvc.facultad.repositorios;

import com.mvc.facultad.entidades.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudianteRepositorio extends JpaRepository<Estudiante, Integer>{
    
}
