
package com.mvc.facultad.repositorios;

import com.mvc.facultad.entidades.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfesorRepositorio extends JpaRepository<Profesor, Integer> {
    
}
