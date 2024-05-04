package com.proyecto.calificacion.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.proyecto.calificacion.model.Publicacion;
import com.proyecto.calificacion.repository.PublicacionRepository;


@ExtendWith(MockitoExtension.class)
public class PublicacionServiceTest {
    @InjectMocks
    private PublicacionServiceImpl publicacionService;

    @Mock
    private PublicacionRepository publicacionRepositoryMock;

    @Test
    public void publicacionGuardarTest() {

        Publicacion publicacion = new Publicacion();
        publicacion.setTitulo("Pooldead");

        when(publicacionRepositoryMock.save(any())).thenReturn(publicacion);

        Publicacion resultadoTest = publicacionService.createPublicacion(publicacion);

        assertEquals("Pooldead", publicacion.getTitulo());
    }
}

