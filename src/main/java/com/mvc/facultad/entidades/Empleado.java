package com.mvc.facultad.entidades;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter @Setter @ToString(callSuper = true)
@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Empleado extends Persona {

    protected String anioIncorporacion;
    protected String nDespacho;


}
