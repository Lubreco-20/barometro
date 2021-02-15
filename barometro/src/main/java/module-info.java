module com.mycompany.barometro {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.controlsfx.controls;
    requires java.desktop;
    requires java.logging;
    requires java.prefs;
    requires commons.cli;
    
    opens com.mycompany.barometro to javafx.fxml;
    exports com.mycompany.barometro;
}
