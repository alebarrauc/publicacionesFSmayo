 package com.proyecto.calificacion.controller;

 import org.springframework.http.HttpStatus;
 import org.springframework.web.bind.annotation.ResponseStatus;
 
 @ResponseStatus(HttpStatus.NOT_FOUND)
 public class PublicacionesNotFoundException extends RuntimeException{
     
     public PublicacionesNotFoundException(String message) {
         super(message);
     }
 }