
package com.mvc.facultad.servicios.interfaces;

import com.mvc.facultad.entidades.Curso;
import java.util.List;

/**
 *
 * @author migue
 */
public interface ICursoServicio {
    public void crearCursos();
     public List<Curso> findAll();
}
