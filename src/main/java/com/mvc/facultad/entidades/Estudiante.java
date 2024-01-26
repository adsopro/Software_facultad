package com.mvc.facultad.entidades;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Estudiante extends Persona {

 
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Curso> cursos;

}
