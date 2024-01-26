package com.mvc.facultad.servicios;

import com.mvc.facultad.entidades.Profesor;
import com.mvc.facultad.repositorios.ProfesorRepositorio;
import com.mvc.facultad.servicios.interfaces.IProfesorServicio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class ProfesorServicioImp implements IProfesorServicio {

    @Autowired
    ProfesorRepositorio prr;

    @Override
    public List<Profesor> findAll() {
        return prr.findAll();
    }

    @Override
    public Optional<Profesor> findById(Integer id) {
        return prr.findById(id);
    }

    @Override
    public void update(Profesor profesor) {
        prr.save(profesor);
    }

    @Override
    public void delete(Profesor profesor) {
        prr.delete(profesor);
    }

    @Override
    public void save(Profesor profesor) {
        prr.save(profesor);
    }

}
