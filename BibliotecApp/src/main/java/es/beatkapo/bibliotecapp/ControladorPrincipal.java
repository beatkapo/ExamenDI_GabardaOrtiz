package es.beatkapo.bibliotecapp;

import es.beatkapo.bibliotecapp.model.Biblioteca;
import es.beatkapo.bibliotecapp.model.Libro;
import es.beatkapo.bibliotecapp.model.ModalData;
import es.beatkapo.bibliotecapp.model.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControladorPrincipal implements Initializable {

    @FXML
    private ListView<Libro> listaLibros;
    private Biblioteca biblioteca;

    @FXML
    void altaLibro(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("modal-libro.fxml"));
        ModalData.libro = null;
        abrirVentanaModal(fxmlLoader, "Alta de libro","alta.png");

        if(ModalData.libro != null) {
            biblioteca.altaLibro(ModalData.libro);
            listaLibros.getItems().setAll(biblioteca.getLibros());
        }
    }

    private void abrirVentanaModal(FXMLLoader fxmlLoader, String titulo, String imagen) throws IOException {
        Parent root = fxmlLoader.load();
        Stage modal = new Stage();
        modal.setTitle(titulo);
        modal.setScene(new javafx.scene.Scene(root));
        Image icon = new Image(String.valueOf(App.class.getResource(imagen)));
        modal.getIcons().add(icon);
        modal.showAndWait();
    }

    @FXML
    void prestarLibro(ActionEvent event) throws IOException {
        if(listaLibros.getSelectionModel().getSelectedItem() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error al prestar el libro");
            alert.setContentText("Debes seleccionar un libro");
            alert.showAndWait();
            return;
        }
        ModalData.libro = listaLibros.getSelectionModel().getSelectedItem();
        ModalData.usuarios = biblioteca.getUsuarios();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("modal-prestamo.fxml"));
        abrirVentanaModal(fxmlLoader, "Prestar libro","prestar.png");
        if(ModalData.usuario != null) {
            biblioteca.prestarLibro(ModalData.libro.getId(), ModalData.usuario.getDni());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Información");
            alert.setHeaderText("Libro prestado");
            alert.setContentText("Prestado correctamente al usuario con DNI: "+ModalData.usuario.getDni());
            alert.showAndWait();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        biblioteca = new Biblioteca();
        listaLibros.getItems().setAll(biblioteca.getLibros());
        Usuario usuario = new Usuario("12345678A", null);
        biblioteca.altaUsuario(usuario);
    }
}
