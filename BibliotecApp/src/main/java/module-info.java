module es.beatkapo.bibliotecapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;


    opens es.beatkapo.bibliotecapp to javafx.fxml;
    exports es.beatkapo.bibliotecapp;
}