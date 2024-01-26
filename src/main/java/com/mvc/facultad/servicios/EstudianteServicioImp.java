package com.mvc.facultad.servicios;


import com.mvc.facultad.entidades.Curso;
import com.mvc.facultad.entidades.Estudiante;
import com.mvc.facultad.repositorios.CursoRepositorio;
import com.mvc.facultad.repositorios.EstudianteRepositorio;
import com.mvc.facultad.servicios.interfaces.IEstudianteServicio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class EstudianteServicioImp implements IEstudianteServicio {

    @Autowired
    EstudianteRepositorio er;
    
    @Autowired
    CursoRepositorio cr;
    
    @Override
    public List<Estudiante> findAll() {
        return er.findAll();
    }

    @Override
    public Optional<Estudiante> findById(Integer id) throws Exception {
        return er.findById(id);
    }

    @Override
    public void update(Estudiante estudiante) {
        er.save(estudiante);
    }

    @Override
    public void delete(Estudiante estudiante) {
        er.delete(estudiante);
    }

    @Override
    public void save(Estudiante estudiante) {
        er.save(estudiante);
    }
    
    @Override
    public void deleteById(Integer id){
        er.deleteById(id);
    }

    
    @Override
    public void matricularEstudianteEnCursos(Integer estudianteId, List<Integer> cursoIds) {
        Estudiante estudiante = er.findById(estudianteId).orElse(null);

        if (estudiante != null) {
            List<Curso> cursosSeleccionados = cr.findAllById(cursoIds);
            estudiante.getCursos().addAll(cursosSeleccionados);
            er.save(estudiante);
        }
    }



    
}
