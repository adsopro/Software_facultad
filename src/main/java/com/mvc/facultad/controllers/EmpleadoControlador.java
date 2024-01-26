package com.mvc.facultad.controllers;

import com.mvc.facultad.entidades.Empleado;
import com.mvc.facultad.enums.EstadoCivil;
import com.mvc.facultad.servicios.EmpleadoServicioImp;
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
@RequestMapping("/empleado")
public class EmpleadoControlador {

    @Autowired
    EmpleadoServicioImp ems;

    @GetMapping("/crearEmpleado")
    public String crearEmpleado(Model model) {
        model.addAttribute("estadoCivilValues", EstadoCivil.values());
        return "crearEmpleado";
    }

    @PostMapping("/guardarEmpleado")
    public String guardarEmpleado(@ModelAttribute Empleado empleado) {
        ems.save(empleado);
        return "redirect:/empleado/crearEmpleado";
    }

    @GetMapping("/empleados")
    public String verEmpleados(Model model) {
        List<Empleado> empleados = ems.findAll();
        model.addAttribute("empleados", empleados);
        return "empleados";
    }

    @GetMapping("/modificarEmpleado/{id}")
    public String modificarEmpleado(@PathVariable Integer id, Model model) throws Exception {
        Optional<Empleado> empleado = ems.findById(id);
        if (empleado.isPresent()) {
            model.addAttribute("empleado", empleado.get());
            model.addAttribute("estadoCivilValues", EstadoCivil.values()); // Agregar los valores del enum

            return "modificarEmpleado"; // Vista para modificar
        }
        return "redirect:/empleado/empleados"; // Redirige si no se encuentra el empleado
    }

    @GetMapping("/eliminarEmpleado/{id}")
    public String eliminarEmpleado(@PathVariable Integer id) {
        ems.deleteById(id);
        return "redirect:/empleado/empleados"; // Redirige después de eliminar
    }

    @PostMapping("/actualizarEmpleado")
    public String actualizarEmpleado(@ModelAttribute Empleado empleado) {
        ems.save(empleado);
        return "redirect:/empleado/empleados/";
    }
}
