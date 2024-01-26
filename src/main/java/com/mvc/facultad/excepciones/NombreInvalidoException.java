
package com.mvc.facultad.excepciones;

public class NombreInvalidoException extends Exception {
    public NombreInvalidoException() {
        super("El nombre no puede ser nulo o estar vacío");
    }
}