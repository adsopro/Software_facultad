package com.mvc.facultad.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdministradorControlador {
    @GetMapping("/")
    public String inicioAdmin(){
       return "inicioAdmin.html"; 
    }
}
