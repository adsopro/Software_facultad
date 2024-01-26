package com.mvc.facultad.servicios.interfaces;

import com.mvc.facultad.entidades.Profesor;
import java.util.List;
import java.util.Optional;




public interface IProfesorServicio {

    public List<Profesor> findAll();

    public Optional<Profesor> findById(Integer id);

    public void update(Profesor profesor);

    public void delete(Profesor profesor);

    public void save(Profesor profesor);
    

}
