package com.mvc.facultad.servicios;

import com.mvc.facultad.entidades.Persona;
import com.mvc.facultad.repositorios.PersonaRepositorio;
import com.mvc.facultad.servicios.interfaces.IPersonaServicio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class PersonaServicioImp implements IPersonaServicio {

    @Autowired
    PersonaRepositorio pr;

    @Override

    public List<Persona> findAll() {
        return pr.findAll();
    }

    @Override
    public Optional<Persona> findById(Integer id) throws Exception {
        return pr.findById(id);
    }

    @Override
    public void update(Persona persona) {
        pr.save(persona);
    }

    @Override
    public void delete(Persona persona) {
        pr.delete(persona);
    }

    @Override
    public void save(Persona persona) {
        pr.save(persona);
    }
    
    @Override
    public void deleteById(Integer id){
        pr.deleteById(id);
    }

    @Override
    public List<Persona> findAllPersonasOnly(){
       return pr.findAllPersonasOnly();
    }
}
