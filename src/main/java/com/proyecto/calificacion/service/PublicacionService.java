package com.proyecto.calificacion.service;

import com.proyecto.calificacion.model.Publicacion;
import java.util.List;
import java.util.Optional;

public interface PublicacionService {
    List<Publicacion> getAllPublicacion();
    Optional<Publicacion> getPublicacionById(Long id);
    Publicacion createPublicacion(Publicacion publicacion);
    Publicacion updatePublicacion(Long id, Publicacion publicacion);
    void deletePublicacion (Long id);
}
