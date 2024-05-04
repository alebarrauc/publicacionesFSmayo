package com.proyecto.calificacion.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.calificacion.model.Publicacion;
import com.proyecto.calificacion.service.PublicacionService ;

import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/publicaciones")
public class PublicacionController {

    private static final Logger log = LoggerFactory.getLogger(PublicacionController.class);
    @Autowired
    private PublicacionService publicacionService;

    @GetMapping
    public List<Publicacion> getAllPublicacion(){
        log.info("GET /publicacion");
        log.info("-------------------Desplegando la informacion----------------");
        return publicacionService.getAllPublicacion();
    }
        
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Publicacion>> getPublicacionById(@PathVariable Long id) {
        Optional<Publicacion> ubicacion = publicacionService.getPublicacionById(id);
        if (ubicacion.isEmpty()){
            log.error("no se encuentra la Publicacion con ID {}", id);
             return ResponseEntity.notFound().build();
        }
        log.info("Publicacion encontrada con exito");

        return ResponseEntity.ok(publicacionService.getPublicacionById(id));
    }

    @PostMapping
    public Publicacion createPublicacion(@RequestBody Publicacion publicacion) {
        return publicacionService.createPublicacion(publicacion);
    }


    @PutMapping("/{id}")
    public Publicacion updatePublicacion(@PathVariable Long id,@RequestBody Publicacion publicacion) {
        return publicacionService.updatePublicacion(id,publicacion);
    }
    @DeleteMapping("/{id}")
    public void deletePublicacion(@PathVariable Long id){
        publicacionService.deletePublicacion(id);
    }
}
