package com.proyecto.calificacion.controller;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

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
import java.util.stream.Collectors;

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
public CollectionModel<EntityModel<Publicacion>> getAllPublicacion() {
    List<Publicacion> publicaciones = publicacionService.getAllPublicacion();
    log.info("GET /publicacion");
    log.info("-------------------Desplegando la informacion----------------");
    List<EntityModel<Publicacion>> publicacionResources = publicaciones.stream()
        .map(publicacion -> EntityModel.of(publicacion,
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getPublicacionById(publicacion.getId())).withSelfRel()
        ))
        .collect(Collectors.toList());
    WebMvcLinkBuilder linkTo = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllPublicacion());
    CollectionModel<EntityModel<Publicacion>> resources = CollectionModel.of(publicacionResources, linkTo.withRel("publicacion"));
    return resources;
}

        
@GetMapping("/{id}")
public EntityModel<Publicacion> getPublicacionById(@PathVariable Long id){
    Optional<Publicacion> publicacion = publicacionService.getPublicacionById(id);

    if (publicacion.isPresent()) {
        return EntityModel.of(publicacion.get(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getPublicacionById(id)).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllPublicacion()).withRel("publicacion"));    
    }   else {
        throw new PublicacionesNotFoundException("Id publicacion no encontrado: "+id);
    }
}


    @PostMapping
    public EntityModel<Publicacion> createPublicacion(@RequestBody Publicacion publicacion) {
        Publicacion createdPublicacion = publicacionService.createPublicacion(publicacion);
        return EntityModel.of(createdPublicacion,
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getPublicacionById(createdPublicacion.getId())).withSelfRel(),
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllPublicacion()).withRel("publicacion"));
    }

    @PutMapping("/{id}")
    public EntityModel<Publicacion> updatePublicacion(@PathVariable Long id, @RequestBody Publicacion publicacion) {
        Publicacion updatedPublicacion = publicacionService.updatePublicacion(id, publicacion);
        return EntityModel.of(updatedPublicacion,
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getPublicacionById(id)).withSelfRel(),
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllPublicacion()).withRel("publicacion"));
    }

    @DeleteMapping("/{id}")
    public void deletePublicacion(@PathVariable Long id){
        publicacionService.deletePublicacion(id);
    }
}
