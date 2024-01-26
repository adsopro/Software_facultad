
package com.mvc.facultad.servicios;

import com.mvc.facultad.entidades.Administrador;
import com.mvc.facultad.excepciones.ApellidoInvalidoException;
import com.mvc.facultad.excepciones.EmailInvalidoException;
import com.mvc.facultad.excepciones.NombreInvalidoException;
import com.mvc.facultad.excepciones.Password2InvalidoException;
import com.mvc.facultad.excepciones.PasswordInvalidoException;
import com.mvc.facultad.repositorios.AdministradorRepositorio;
import com.mvc.facultad.roles.Rol;
import com.mvc.facultad.servicios.interfaces.IAdministradorServicio;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 *
 * @author migue
 */
@Service
public class AdministradorServicioImp implements IAdministradorServicio, UserDetailsService {
    @Autowired
    AdministradorRepositorio ar;

    @Override
    public List<Administrador> findAll() {
        return ar.findAll();
    }

    @Override
    public Optional<Administrador> getById(Integer id) {
        return ar.findById(id);
    }

    @Override
    public void update(Administrador administrador) {
        ar.save(administrador);
    }

    @Override
    public void delete(Integer id) {
        ar.deleteById(id);
    }

    @Override
    public void save(Administrador administrador) {
        ar.save(administrador);
    }

    @Transactional
    public void registrar(String nombre, String apellido, String email, String password, String password2)
            throws NombreInvalidoException, ApellidoInvalidoException, EmailInvalidoException,
            PasswordInvalidoException, Password2InvalidoException {
        validar(nombre, apellido, email, password, password2);
        Administrador administrador = new Administrador();
        administrador.setNombre(nombre);
        administrador.setApellido(apellido);
        administrador.setEmail(email);
        administrador.setPassword(new BCryptPasswordEncoder().encode(password));
        administrador.setRol(Rol.ADMIN);
        save(administrador);
    }

    @Override
    public void validar(String nombre, String apellido, String email, String password, String password2)
            throws NombreInvalidoException, ApellidoInvalidoException, EmailInvalidoException,
            PasswordInvalidoException, Password2InvalidoException {
        if (nombre.isEmpty()) {
            throw new NombreInvalidoException();
        }

        if (apellido.isEmpty()) {
            throw new ApellidoInvalidoException();
        }

        if (email.isEmpty()) {
            throw new EmailInvalidoException();
        }

        if (password == null || password.isEmpty() || password.length() <= 5) {
            throw new PasswordInvalidoException();
        }

        if (!password.equals(password2)) {
            throw new Password2InvalidoException();
        }
    }
    
    
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Administrador administrador = ar.findByEmail(email);
        if (administrador == null) {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + administrador.getRol().name()));
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpSession session = attr.getRequest().getSession(true);
        session.setAttribute("adminsession", administrador);

        return new User(administrador.getEmail(), administrador.getPassword(), authorities);
    }
}
