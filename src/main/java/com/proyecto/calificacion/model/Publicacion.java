package com.proyecto.calificacion.model;
import org.springframework.hateoas.RepresentationModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name ="publicacion")

 public class Publicacion extends RepresentationModel<Publicacion> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_publicacion")
    private Long id;
    @Column(name="titulo")
    private String titulo;
    @Column(name="contenido")
    private String contenido;
    @Column(name="comentarios")
    private String comentarios;
    @Column(name="calificacion")
    private int calificacion;

 // Getters y Setters
    // Método getter para 'id'
    public Long getId() {
        return id;
    }
    
    public String getTitulo() {
        return titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public String getComentarios() {
        return comentarios;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

}
