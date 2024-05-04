package com.proyecto.calificacion.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.calificacion.model.Publicacion;
import com.proyecto.calificacion.repository.PublicacionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PublicacionServiceImpl implements PublicacionService{
    @Autowired
    private PublicacionRepository PublicacionRepository;

    @Override
    public List<Publicacion> getAllPublicacion() {
        return PublicacionRepository.findAll();
    }

    @Override
    public Optional<Publicacion> getPublicacionById(Long id) {
        return PublicacionRepository.findById(id);
    }
    
    @Override
    public Publicacion createPublicacion(Publicacion publicacion){
        return PublicacionRepository.save(publicacion);
    }

    @Override
    public Publicacion updatePublicacion(Long id, Publicacion publicacion){
        if(PublicacionRepository.existsById(id)){
            publicacion.setId(id);
            return PublicacionRepository.save(publicacion);
        }else{
                return null;
            }
        }
 
    @Override
    public void deletePublicacion(Long id){
        PublicacionRepository.deleteById(id);;
    }
    
    }

