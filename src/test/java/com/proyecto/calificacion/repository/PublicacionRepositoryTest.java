package com.proyecto.calificacion.repository;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import com.proyecto.calificacion.model.Publicacion;

    @DataJpaTest
    @AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
    public class PublicacionRepositoryTest {
        @Autowired
        private PublicacionRepository publicacionRepository;
        @Test
        public void guardarPublicacionTest() {
            Publicacion publicacionTest = new Publicacion();
            publicacionTest.setTitulo("Deadpool vs Taskmaster");

            Publicacion resultadoTest = publicacionRepository.save(publicacionTest);

            assertNotNull(resultadoTest.getId());
            assertEquals("Deadpool vs Taskmaster", resultadoTest.getTitulo());
        } 
    }   
