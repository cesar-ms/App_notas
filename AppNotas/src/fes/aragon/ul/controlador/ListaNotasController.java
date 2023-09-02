/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fes.aragon.ul.controlador;

import fes.aragon.modelo.Nota;
import fes.aragon.ui.BaseControlador;
import static fes.aragon.ui.PaginasFXML.AGREGAR;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import static javafx.scene.control.ButtonType.OK;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Julio
 */
public class ListaNotasController extends BaseControlador implements Initializable {

    @FXML
    private TextField txtBuscarNota;
    @FXML
    private Label numeroNotas;
    @FXML
    private TableView<Nota> listasNotasTabla;
    @FXML
    private TableColumn tblTitulo;
    @FXML
    private TableColumn tblDescripcion;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.tblTitulo.setCellValueFactory(new PropertyValueFactory<>("Titulo"));
        this.tblDescripcion.setCellValueFactory(new PropertyValueFactory<>("Descripcion"));
        this.numeroNotas.textProperty().bind(Bindings.createStringBinding(()->datos.size()+ " Notas ", datos));
        
        alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setTitle("Dialogo de confirmación");
        alerta.setHeaderText("Confirimación de eliminación");
        alerta.setContentText("¿Estas deacuerdo de eliminar la nota?");
        FilteredList<Nota> filtroDato = new FilteredList<>(datos,n->true);
        this.txtBuscarNota.setOnKeyReleased(e->{
            filtroDato.setPredicate(n->{
               if(this.txtBuscarNota.getText() == null || this.txtBuscarNota.getText().isEmpty()){
                   return true;
               } 
               return n.getTitulo().contains(txtBuscarNota.getText()) || n.getDescripcion().contains(txtBuscarNota.getText());
            });
        });
        this.listasNotasTabla.setItems(filtroDato);
    
    }    
    private Nota getItem(){
        return Nota.class.cast(listasNotasTabla.getSelectionModel().getSelectedItem());
    }
        
    @FXML
    private void agregarNota(ActionEvent event) throws IOException {
        editarNota = null;
        System.out.println(AGREGAR.getPagina());
        navegar(event,AGREGAR.getPagina());
        
    }

    @FXML
    private void borrarNota(ActionEvent event) {
        Optional<ButtonType> Resultado = alerta.showAndWait();
        if(Resultado.get().equals(OK)){
            datos.remove(getItem());
        }
    }

    @FXML
    private void editarNota(ActionEvent event) throws IOException {
        editarNota = null;
        editarNota = getItem();
        if(Objects.nonNull(editarNota)){
            navegar(event,AGREGAR.getPagina());
        }
    }
    
}
