package com.mvc.facultad.servicios.interfaces;

import com.mvc.facultad.entidades.Administrador;
import com.mvc.facultad.excepciones.ApellidoInvalidoException;
import com.mvc.facultad.excepciones.EmailInvalidoException;
import com.mvc.facultad.excepciones.NombreInvalidoException;
import com.mvc.facultad.excepciones.Password2InvalidoException;
import com.mvc.facultad.excepciones.PasswordInvalidoException;
import java.util.List;
import java.util.Optional;

public interface IAdministradorServicio {

    public List<Administrador> findAll();

    public Optional<Administrador> getById(Integer id);

    public void update(Administrador usuario);

    public void delete(Integer id);

    public void save(Administrador usuario);
    
     public void validar(String nombre, String apellido, String email, String password, String password2)
            throws NombreInvalidoException, ApellidoInvalidoException, EmailInvalidoException,
            PasswordInvalidoException, Password2InvalidoException;
}
