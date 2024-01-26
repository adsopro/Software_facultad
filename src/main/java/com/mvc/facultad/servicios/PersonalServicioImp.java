package com.mvc.facultad.servicios;

import com.mvc.facultad.entidades.PersonalDeServicio;
import com.mvc.facultad.repositorios.PersonalRepositorio;
import com.mvc.facultad.servicios.interfaces.IPersonalServicio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class PersonalServicioImp implements IPersonalServicio {

    @Autowired
    PersonalRepositorio prr;

    @Override
    public List<PersonalDeServicio> findAll() {
        return prr.findAll();
    }

    @Override
    public Optional<PersonalDeServicio> findById(Integer id) throws Exception {
        return prr.findById(id);
    }

    @Override
    public void update(PersonalDeServicio personal) {
        prr.save(personal);
    }

    @Override
    public void delete(PersonalDeServicio personal) {
        prr.delete(personal);
    }

    @Override
    public void save(PersonalDeServicio personal) {
        prr.save(personal);
    }

}
