/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fes.aragon.modelo;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Julio
 */
public class Nota {
    
    private final SimpleStringProperty titulo;
    private final SimpleStringProperty descripcion;
     
     
     public Nota(String titulo, String descripcion){
         this.titulo = new SimpleStringProperty(titulo);
         this.descripcion = new SimpleStringProperty(descripcion);
     }
     
     public String getTitulo(){
         return this.titulo.get();
     }
     
     public void setTitulo(String titulo){
         this.titulo.set(titulo);
     }
    
     public String getDescripcion(){
         return this.descripcion.get();
     }
     
     public void setDescripcion(String descripcion){
         this.descripcion.set(descripcion);
     }
    
}
