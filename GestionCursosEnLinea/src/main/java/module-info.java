module org.example.gestioncursosenlinea {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.gestioncursosenlinea to javafx.fxml;
    exports org.example.gestioncursosenlinea;
}