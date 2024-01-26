
package com.mvc.facultad.excepciones;


public class Password2InvalidoException extends Exception {
    public Password2InvalidoException() {
        super("Las contraseñas no coinciden");
    }
}
