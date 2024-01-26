package com.mvc.facultad.servicios.interfaces;

import com.mvc.facultad.entidades.Estudiante;
import java.util.List;
import java.util.Optional;


public interface IEstudianteServicio {

    public List<Estudiante> findAll();

    public Optional<Estudiante> findById(Integer id) throws Exception;

    public void update(Estudiante estudiante);

    public void delete(Estudiante estudiante);

    public void save(Estudiante estudiante);
    
     public void deleteById(Integer id);
     
     public void matricularEstudianteEnCursos(Integer estudianteId, List<Integer> cursoIds);
 
}
