package com.proyecto.calificacion.model;

import com.proyecto.calificacion.model.Publicacion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PublicacionTest {
    private Publicacion publicacion;

    @BeforeEach
    public void setUp() {
        publicacion = new Publicacion();
    }

    @Test
    public void testId() {
        Long idValue = 1L;
        publicacion.setId(idValue);
        assertEquals(idValue, publicacion.getId());
    }

    @Test
    public void testTitulo() {
        String tituloValue = "The Dark Knight";
        publicacion.setTitulo(tituloValue);
        assertEquals(tituloValue, publicacion.getTitulo());
    }


}

