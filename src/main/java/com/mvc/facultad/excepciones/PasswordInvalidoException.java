
package com.mvc.facultad.excepciones;


public class PasswordInvalidoException extends Exception{
    public PasswordInvalidoException() {
        super("La contraseña no puede ser nula o estar vacía, además debe tener más de 5 dígitos");
    }
}
