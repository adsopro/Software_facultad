/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mvc.facultad.servicios.test;

/**
 *
 * @author Julian_Velasco
 */
import com.mvc.facultad.entidades.Estudiante;
import com.mvc.facultad.repositorios.CursoRepositorio;
import com.mvc.facultad.repositorios.EstudianteRepositorio;
import com.mvc.facultad.servicios.EstudianteServicioImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EstudianteServicioImpTest {

    @InjectMocks
    private EstudianteServicioImp estudianteServicio;

    @Mock
    private EstudianteRepositorio estudianteRepositorio;

    @Mock
    private CursoRepositorio cursoRepositorio;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindAll() {
        List<Estudiante> estudiantes = new ArrayList<>();
        when(estudianteRepositorio.findAll()).thenReturn(estudiantes);

        List<Estudiante> result = estudianteServicio.findAll();

        verify(estudianteRepositorio).findAll();
        assertEquals(estudiantes, result);
    }

    @Test
    public void testFindById() throws Exception {
        Estudiante estudiante = new Estudiante();
        when(estudianteRepositorio.findById(1)).thenReturn(Optional.of(estudiante));

        Optional<Estudiante> result = estudianteServicio.findById(1);

        verify(estudianteRepositorio).findById(1);
        assertTrue(result.isPresent());
        assertEquals(estudiante, result.get());
    }

}