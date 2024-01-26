
package com.mvc.facultad.servicios.interfaces;

import com.mvc.facultad.entidades.Empleado;
import java.util.List;
import java.util.Optional;


/**
 *
 * @author migue
 */
public interface IEmpleadoServicio {

    public List<Empleado> findAll();

    public Optional<Empleado> findById(Integer id) throws Exception;

    public void update(Empleado empleado);

    public void delete(Empleado empleado);

    public void save(Empleado empleado);
    
    public void deleteById(Integer id);
}
