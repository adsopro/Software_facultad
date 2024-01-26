package com.mvc.facultad.servicios;


import com.mvc.facultad.entidades.Empleado;
import com.mvc.facultad.repositorios.EmpleadoRepositorio;
import com.mvc.facultad.servicios.interfaces.IEmpleadoServicio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class EmpleadoServicioImp implements IEmpleadoServicio {

    @Autowired
    EmpleadoRepositorio er;
    
    @Override
    public List<Empleado> findAll() {
        return er.findAll();
    }

    @Override
    public Optional<Empleado> findById(Integer id) throws Exception {
        return er.findById(id);
    }

    @Override
    public void update(Empleado empleado) {
        er.save(empleado);
    }

    @Override
    public void delete(Empleado empleado) {
        er.delete(empleado);
    }

    @Override
    public void save(Empleado empleado) {
        er.save(empleado);
    }

    
    @Override
    public void deleteById(Integer id){
        er.deleteById(id);
    }
    
   
}
