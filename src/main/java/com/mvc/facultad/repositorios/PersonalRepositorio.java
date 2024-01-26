
package com.mvc.facultad.repositorios;

import com.mvc.facultad.entidades.PersonalDeServicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalRepositorio extends JpaRepository<PersonalDeServicio, Integer> {
    
}
