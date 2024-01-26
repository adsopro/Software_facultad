/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mvc.facultad.controllers;

import com.mvc.facultad.entidades.Curso;
import com.mvc.facultad.servicios.CursoServicioImp;
import com.mvc.facultad.servicios.EstudianteServicioImp;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/estudiante")
public class MatriculaControlador {

    @Autowired
    private EstudianteServicioImp es;

    @Autowired
    private CursoServicioImp cs;

    @GetMapping("/matricularEstudiante/{id}")
    public String matricularEstudianteForm(@PathVariable Integer id, Model model) throws Exception {
        List<Curso> cursos = cs.findAll();
        
        model.addAttribute("estudianteId", id);
        model.addAttribute("cursos", cursos);

        return "matriculaEstudiantes";
    }

    @PostMapping("/guardarMatricula")
    public String guardarMatricula(@RequestParam Integer estudianteId, @RequestParam List<Integer> cursoIds) {
        es.matricularEstudianteEnCursos(estudianteId, cursoIds);
        return "redirect:/estudiante/estudiantes";
    }
}