package com.proyecto.calificacion.controller;

import static org.mockito.Mockito.when;
import java.util.Arrays;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.proyecto.calificacion.model.Publicacion;
import com.proyecto.calificacion.service.PublicacionServiceImpl;

@WebMvcTest(PublicacionController.class)
public class PublicacionControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PublicacionServiceImpl publicacionServiceMock;

    private List<Publicacion> publicacion;

    @BeforeEach
    public void setUp() {
        Publicacion publicacion1 = new Publicacion();
        publicacion1.setTitulo("The Dark Knight");
        publicacion1.setId(1L);
      
        publicacion = Arrays.asList(publicacion1);
    }

    @AfterEach
    public void tearDown() {
        publicacion = null;
    }

    @Test
    public void allTest() throws Exception {
        when(publicacionServiceMock.getAllPublicacion()).thenReturn(publicacion);
    
        mockMvc.perform(MockMvcRequestBuilders.get("/publicaciones"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].titulo", Matchers.is("The Dark Knight")));
    }
    

}

