package com.mvc.facultad.repositorios;

import com.mvc.facultad.entidades.Persona;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PersonaRepositorio extends JpaRepository<Persona, Integer> {

    @Query("SELECT DISTINCT p FROM Persona p LEFT JOIN Estudiante e ON p.id = e.id LEFT JOIN Empleado em ON p.id = em.id WHERE e.id IS NULL AND em.id IS NULL")
    List<Persona> findAllPersonasOnly();

}
