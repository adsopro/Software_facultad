package com.mvc.facultad.servicios.interfaces;

import com.mvc.facultad.entidades.PersonalDeServicio;
import java.util.List;
import java.util.Optional;


public interface IPersonalServicio {

    public List<PersonalDeServicio> findAll();

    public Optional<PersonalDeServicio> findById(Integer id) throws Exception;

    public void update(PersonalDeServicio personal);

    public void delete(PersonalDeServicio personal);

    public void save(PersonalDeServicio personal);
    

}
