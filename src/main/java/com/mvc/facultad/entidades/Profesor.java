package com.mvc.facultad.entidades;

import javax.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString(callSuper = true)
@Entity
public class Profesor extends Empleado {

    private String departamento;

   
    

}
