package com.mvc.facultad.servicios;

import com.mvc.facultad.entidades.Curso;
import com.mvc.facultad.enums.Cursos;
import com.mvc.facultad.repositorios.CursoRepositorio;
import com.mvc.facultad.servicios.interfaces.ICursoServicio;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursoServicioImp implements ICursoServicio {

    @Autowired
    CursoRepositorio cr;

    @Transactional

    @Autowired
    @Override
    public void crearCursos() {
        Curso curso;
        ArrayList<Curso> cursos = (ArrayList<Curso>) cr.findAll();
        if (cursos.isEmpty()) {
            for (int i = 0; i < Cursos.values().length; i++) {
                curso = new Curso();
                curso.setNombre(Cursos.values()[i].materia);
                cr.save(curso);
            }
        } else {
            for (int i = 0; i < Cursos.values().length; i++) {
                if (!cursos.get(i).getNombre().equals(Cursos.values()[i].materia)) {
                    curso = new Curso();
                    curso.setNombre(Cursos.values()[i].materia);
                    cr.save(curso);
                }
            }
        }

    }

    @Override
    public List<Curso> findAll() {
        return cr.findAll();
    }
}
