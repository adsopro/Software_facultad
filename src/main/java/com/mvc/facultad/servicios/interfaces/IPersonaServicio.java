package com.mvc.facultad.servicios.interfaces;

import com.mvc.facultad.entidades.Persona;
import java.util.List;
import java.util.Optional;

public interface IPersonaServicio {

    public List<Persona> findAll();

    public Optional<Persona> findById(Integer id) throws Exception;

    public void update(Persona persona);

    public void delete(Persona persona);

    public void save(Persona persona);

    public void deleteById(Integer id);

    public List<Persona> findAllPersonasOnly();

}
