/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fes.aragon.ul.controlador;

import fes.aragon.modelo.Nota;
import fes.aragon.ui.BaseControlador;
import static fes.aragon.ui.PaginasFXML.LISTA;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Julio
 */
public class AgregarNotasController extends BaseControlador implements Initializable {

    @FXML
    private Button btnLista;
    @FXML
    private TextField txtTitulo;
    @FXML
    private TextArea txtDescripcion;
    @FXML
    private Button btnCancelar;
    @FXML
    private Button btnLimpiar;
    @FXML
    private Button btnGuardar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        alerta = new Alert(Alert.AlertType.WARNING);
        alerta.setTitle("Dialogo de aviso");
        alerta.setHeaderText("Dato invalido para salvar");
        alerta.setContentText("El titulo o descripción no deben de ser vacios");
        
        if(Objects.nonNull(editarNota)){
            txtTitulo.setText(editarNota.getTitulo());
            txtDescripcion.setText(editarNota.getDescripcion());
            btnGuardar.setText("Guardar");
        }
    }    

    @FXML
    private void regresar(ActionEvent event) throws IOException {
        navegar(event, LISTA.getPagina());
    }

    @FXML
    private void cancelar(ActionEvent event) throws IOException {
        navegar(event, LISTA.getPagina());
    }

    @FXML
    private void limpiar(ActionEvent event) {
        txtTitulo.clear();
        txtDescripcion.clear();
    }

    @FXML
    private void guardar(ActionEvent event) throws IOException {
        if(Objects.nonNull(editarNota)){
            datos.remove(editarNota);
        }
        if(txtTitulo.getText().trim().equals("") || txtDescripcion.getText().trim().equals("")){
            alerta.showAndWait();
            return;
        }
        datos.add(new Nota(txtTitulo.getText(),txtDescripcion.getText()));
        navegar(event,LISTA.getPagina());
    }
    
}
