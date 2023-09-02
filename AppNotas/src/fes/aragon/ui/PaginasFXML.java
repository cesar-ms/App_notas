/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fes.aragon.ui;

import java.net.URL;

/**
 *
 * @author Julio
 */
public enum PaginasFXML {
    LISTA("/fes/aragon/ul/fxml/ListaNotas.fxml"),
    AGREGAR("/fes/aragon/ul/fxml/AgregarNotas.fxml");
    
    private final String ubicacion;

    private PaginasFXML(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    
    public URL getPagina(){
        return getClass().getResource(ubicacion);
    }
    
}
