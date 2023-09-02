/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fes.aragon.ui;

import fes.aragon.modelo.Nota;
import java.io.IOException;
import java.net.URL;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

/**
 *
 * @author Julio
 */
public class BaseControlador {
    protected Alert alerta;
    protected static ObservableList<Nota> datos = FXCollections.
            <Nota>observableArrayList(
                    new Nota("Nota 1","Descripcion 1"),
                    new Nota("Nota 2","Descripcion 2"),
                    new Nota("Nota 3","Descripcion 3"),
                    new Nota("Nota 4","Descripcion 4"));
    
    protected static Nota editarNota=null;
    
    protected void navegar(Event event,URL faxmoDoc) throws IOException{
        System.out.println(faxmoDoc);
        Parent pagina = FXMLLoader.load(faxmoDoc);
        Scene escena = new Scene(pagina);
        Stage appEscenario = (Stage)((Node)event.getSource()).getScene().getWindow();
        appEscenario.hide();
        appEscenario.setScene(escena);
        appEscenario.show();
    }
}
