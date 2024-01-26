package com.mvc.facultad.controllers;

import com.mvc.facultad.entidades.Persona;
import com.mvc.facultad.enums.EstadoCivil;
import com.mvc.facultad.servicios.PersonaServicioImp;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/persona")
public class PersonaControlador {

    @Autowired
    PersonaServicioImp ps;

    @GetMapping("/crearPersona")
    public String crearPersona(Model model) {
        model.addAttribute("estadoCivilValues", EstadoCivil.values());
        return "crearPersona";
    }

    @PostMapping("/guardarPersona")
    public String guardarPersona(@ModelAttribute Persona persona) {
        ps.save(persona);
        return "redirect:/persona/crearPersona";
    }

    @GetMapping("/personas")
    public String verPersonas(Model model) {
        List<Persona> personas = ps.findAllPersonasOnly();
        model.addAttribute("personas", personas);
        return "personas";
    }

    @GetMapping("/modificarPersona/{id}")
    public String modificarPersona(@PathVariable Integer id, Model model) throws Exception {
        Optional<Persona> persona = ps.findById(id);
        if (persona.isPresent()) {
            model.addAttribute("persona", persona.get());
            model.addAttribute("estadoCivilValues", EstadoCivil.values()); // Agregar los valores del enum

            return "modificarPersona"; // Vista para modificar
        }
        return "redirect:/personas/personas"; // Redirige si no se encuentra la persona
    }

    @GetMapping("/eliminarPersona/{id}")
    public String eliminarPersona(@PathVariable Integer id) {
        ps.deleteById(id);
        return "redirect:/persona/personas"; // Redirige después de eliminar
    }

    @PostMapping("/actualizarPersona")
    public String actualizarPersona(@ModelAttribute Persona persona) {
        ps.save(persona);
        return "redirect:/persona/personas/"; 
    }
}
