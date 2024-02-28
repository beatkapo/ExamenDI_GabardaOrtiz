package es.beatkapo.bibliotecapp;

import es.beatkapo.bibliotecapp.model.ModalData;
import es.beatkapo.bibliotecapp.model.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ModalPrestarController implements Initializable {

    @FXML
    private Label libroLabel;

    @FXML
    private ComboBox<Usuario> usuarios;

    @FXML
    void cancelar(ActionEvent event) {
        Stage stage = (Stage) libroLabel.getScene().getWindow();
        stage.close();
    }

    @FXML
    void prestar(ActionEvent event) {
        if(usuarios.getValue() != null) {
            ModalData.usuario = usuarios.getValue();
            Stage stage = (Stage) libroLabel.getScene().getWindow();
            stage.close();
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error al prestar el libro");
            alert.setContentText("Debes seleccionar un usuario");
            alert.showAndWait();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        libroLabel.setText(ModalData.libro.getTitulo());
        usuarios.getItems().setAll(ModalData.usuarios);
    }
}
