
package com.mvc.facultad.excepciones;


public class EmailInvalidoException extends Exception {
    public EmailInvalidoException() {
        super("El email no puede ser nulo o estar vacío");
    }
}
