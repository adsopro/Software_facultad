
package com.mvc.facultad.repositorios;

import com.mvc.facultad.entidades.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministradorRepositorio extends JpaRepository<Administrador, Integer>{
     public Administrador findByEmail(String email);
}
