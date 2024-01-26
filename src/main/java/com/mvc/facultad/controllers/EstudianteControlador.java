package com.mvc.facultad.controllers;

import com.mvc.facultad.entidades.Estudiante;
import com.mvc.facultad.entidades.Persona;
import com.mvc.facultad.enums.EstadoCivil;
import com.mvc.facultad.servicios.EstudianteServicioImp;
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
@RequestMapping("/estudiante")
public class EstudianteControlador {

    @Autowired
    EstudianteServicioImp es;

    @GetMapping("/crearEstudiante")
    public String crearEstudiante(Model model) {
        model.addAttribute("estadoCivilValues", EstadoCivil.values());
        return "crearEstudiante";
    }

    @PostMapping("/guardarEstudiante")
    public String guardarEstudiante(@ModelAttribute Estudiante estudiante) {
        es.save(estudiante);
        return "redirect:/estudiante/crearEstudiante";
    }

    @GetMapping("/estudiantes")
    public String verEstudiantes(Model model) {
        List<Estudiante> estudiantes = es.findAll();
        model.addAttribute("estudiantes", estudiantes);
        return "estudiantes";
    }

    @GetMapping("/modificarEstudiante/{id}")
    public String modificarEstudiante(@PathVariable Integer id, Model model) throws Exception {
        Optional<Estudiante> estudiante = es.findById(id);
        if (estudiante.isPresent()) {
            model.addAttribute("estudiante", estudiante.get());
            model.addAttribute("estadoCivilValues", EstadoCivil.values()); // Agregar los valores del enum

            return "modificarEstudiante"; // Vista para modificar
        }
        return "redirect:/estudiante/estudiantes"; // Redirige si no se encuentra el estudiante
    }

    @GetMapping("/eliminarEstudiante/{id}")
    public String eliminarEstudiante(@PathVariable Integer id) {
        es.deleteById(id);
        return "redirect:/estudiante/estudiantes"; // Redirige después de eliminar
    }

    @PostMapping("/actualizarEstudiante")
    public String actualizarEstudiante(@ModelAttribute Estudiante estudiante) {
        es.save(estudiante);
        return "redirect:/estudiante/estudiantes/";
    }
}
