
package com.mvc.facultad.excepciones;


public class ApellidoInvalidoException extends Exception{
    public ApellidoInvalidoException() {
        super("El apellido no puede ser nulo o estar vacío");
    }
}
