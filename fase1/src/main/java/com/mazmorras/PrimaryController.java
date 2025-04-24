package com.mazmorras;

import java.io.IOException;

import com.mazmorras.models.Escuela;
import com.mazmorras.models.Estudiante;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class PrimaryController {

    @FXML
    private Button btnGuardar;

    @FXML
    private TableColumn<Estudiante, String> colApellido;

    @FXML
    private TableColumn<Estudiante, String> colNombre;

    @FXML
    private TableColumn<Estudiante, String> colNumMatricula;

    @FXML
    private TableColumn<Estudiante, String> colTelefono;

    @FXML
    private TableView<Estudiante> tblEstudiante;

    @FXML
    private TextField txtApellido;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtNumMatricula;

    @FXML
    private TextField txtTelefono;

    private Escuela escuela = new Escuela("Escuela Default"); // Inicialización por defecto
    
    @FXML
    void actualizarEstudiante(ActionEvent event) {
        Estudiante estudiante = new Estudiante();
        estudiante.setNumMatricula(txtNumMatricula.getText());
        estudiante.setNombre(txtNombre.getText());
        estudiante.setApellido(txtApellido.getText());
        estudiante.setTelefono(txtTelefono.getText());

        escuela.actualizarEstudiante(estudiante);
        txtNumMatricula.setEditable(true);

        // Limpiar campos
        txtNombre.clear();
        txtApellido.clear();
        txtNumMatricula.clear();
        txtTelefono.clear();

         // Actualizar la tabla completa
         tblEstudiante.setItems(FXCollections.observableArrayList(escuela.getListaEstudiantes()));
         tblEstudiante.refresh();

    }

    @FXML
void guardarEstudiante(ActionEvent event) {
    try {
        Estudiante estudiante = new Estudiante();
        estudiante.setNombre(txtNombre.getText());
        estudiante.setApellido(txtApellido.getText());
        estudiante.setTelefono(txtTelefono.getText());
        estudiante.setNumMatricula(txtNumMatricula.getText());

        escuela.agregarEstudiante(estudiante);
        
        // Actualizar la tabla completa
        tblEstudiante.setItems(FXCollections.observableArrayList(escuela.getListaEstudiantes()));
        
        // Limpiar campos
        txtNombre.clear();
        txtApellido.clear();
        txtNumMatricula.clear();
        txtTelefono.clear();

        txtNumMatricula.setEditable(true);
    } catch (Exception e) {
        e.printStackTrace();
        
    }
}
    @FXML
    void eliminarEstudiante(ActionEvent event) {
        Estudiante estudiante = tblEstudiante.getSelectionModel().getSelectedItem();

        escuela.eliminarEstudiante(estudiante);

        tblEstudiante.setItems(FXCollections.observableArrayList(escuela.getListaEstudiantes()));
    }

    @FXML
void initialize() {
    // Corrección: usar minúsculas para coincidir con los getters
    colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
    colApellido.setCellValueFactory(new PropertyValueFactory<>("apellido"));
    colNumMatricula.setCellValueFactory(new PropertyValueFactory<>("numMatricula"));
    colTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));

    // Inicializar la tabla con datos vacíos
    tblEstudiante.setItems(FXCollections.observableArrayList());
    tblEstudiante.setOnMouseClicked(mouseEvent-> {
        cargarCampos();
    });
}

private void cargarCampos(){
    Estudiante estudiante = tblEstudiante.getSelectionModel().getSelectedItem();

    txtNombre.setText(estudiante.getNombre());
    txtApellido.setText(estudiante.getApellido());
    txtNumMatricula.setText(estudiante.getNumMatricula());
    txtTelefono.setText(estudiante.getTelefono());

    txtNumMatricula.setEditable(false);

}

    private void actualizarTabla() {
        if (escuela != null) {
            tblEstudiante.setItems(FXCollections.observableArrayList(escuela.getListaEstudiantes()));
        }
    }

    
        public void setEscuela(Escuela escuela) {
            this.escuela = escuela;
            // Ahora que tenemos la escuela, cargamos los datos
            if (escuela != null) {
                tblEstudiante.setItems(FXCollections.observableArrayList(escuela.getListaEstudiantes()));
            }
        }
        
    }
