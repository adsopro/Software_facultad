package com.mvc.facultad.controllers;

import com.mvc.facultad.excepciones.ApellidoInvalidoException;
import com.mvc.facultad.excepciones.EmailInvalidoException;
import com.mvc.facultad.excepciones.NombreInvalidoException;
import com.mvc.facultad.excepciones.Password2InvalidoException;
import com.mvc.facultad.excepciones.PasswordInvalidoException;
import com.mvc.facultad.servicios.AdministradorServicioImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author migue
 */
@Controller
public class PortalControlador {
    @Autowired
    private AdministradorServicioImp as;
    
    
    @GetMapping("/")//URL a donde me dirige
    public String index() {
        return "inicio.html";
    }

    @GetMapping("/registro")
    public String register(Model model) {
        model.addAttribute("errorNombre", "");
        model.addAttribute("errorApellido", "");
        model.addAttribute("errorEmail", "");
        model.addAttribute("errorPassword", "");
        model.addAttribute("errorPassword2", "");
        return "registro.html";
    }
    
    @PostMapping("/registro")
    public String registrarUsuario(@RequestParam("nombre") String nombre,
            @RequestParam("apellido") String apellido,
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            @RequestParam("password2") String password2,
            Model model) {
        try {
            as.registrar(nombre, apellido, email, password, password2);
            System.out.println("hola, no hubo errores");
            return "inicio.html";
        } catch (NombreInvalidoException e) {
            System.out.println(e);
            model.addAttribute("errorNombre", "El nombre es inválido");
        } catch (ApellidoInvalidoException e) {
             System.out.println(e);
            model.addAttribute("errorApellido", "El apellido es inválido");
        } catch (EmailInvalidoException e) {
             System.out.println(e);
            model.addAttribute("errorEmail", "El email es inválido");
        } catch (PasswordInvalidoException e) {
             System.out.println(e);
            model.addAttribute("errorPassword", "La contraseña es inválida");
        } catch (Password2InvalidoException e) {
             System.out.println(e);
            model.addAttribute("errorPassword2", "Las contraseñas no coinciden");
        } catch (Exception e) {
             System.out.println(e);
            model.addAttribute("error", "Error al registrar usuario");
        }
        return "registro.html";
    }
    
    @GetMapping("/login")
    public String login(@RequestParam(required=false) String error, ModelMap model) {
        if(error != null){
            model.put("error", "Usuario o contraseña inválidos");
        }
        return "login.html";
    }
    
}
