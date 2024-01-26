
package com.mvc.facultad.repositorios;

import com.mvc.facultad.entidades.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepositorio extends JpaRepository<Curso, Integer>{
    
}
