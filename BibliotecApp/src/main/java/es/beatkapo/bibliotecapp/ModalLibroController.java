package es.beatkapo.bibliotecapp;
import es.beatkapo.bibliotecapp.model.Libro;
import es.beatkapo.bibliotecapp.model.ModalData;
import es.beatkapo.bibliotecapp.model.Tematica;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class ModalLibroController implements Initializable {

    @FXML
    private ComboBox<Tematica> comboTematica;

    @FXML
    private TextField textAutor;

    @FXML
    private TextField textISBN;

    @FXML
    private TextField textTitulo;

    @FXML
    void aceptar(ActionEvent event) {
        if(textTitulo.getText().isEmpty() || textAutor.getText().isEmpty() || textISBN.getText().isEmpty() || comboTematica.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error al dar de alta el libro");
            alert.setContentText("Todos los campos son obligatorios");
            alert.showAndWait();
        }else{
            Libro libro = new Libro();
            libro.setId(ModalData.libros.size());
            libro.setTitulo(textTitulo.getText());
            libro.setAutor(textAutor.getText());
            libro.setIsbn(textISBN.getText());
            libro.setTematica(comboTematica.getValue());
            libro.setFechaEdicion(new Date());
            ModalData.libro = libro;
            ModalData.libros.add(libro);
        }
        Stage stage = (Stage) textTitulo.getScene().getWindow();
        stage.close();
    }

    @FXML
    void cancelar(ActionEvent event) {
        Stage stage = (Stage) textTitulo.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        comboTematica.getItems().setAll(Tematica.values());
    }
}
