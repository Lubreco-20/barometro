package com.mycompany.barometro;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;

public class MainFX extends Application{
    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        Preferences userPreferences = Preferences.userRoot();
        String lang = userPreferences.get("LANG", "");
        String[] langs = lang.split("_");
        if (langs.length < 2) {
            langs = new String[]{"", ""};
        }
        
        Locale locale = new Locale(langs[0], langs[1]);
        ResourceBundle bundle = ResourceBundle.getBundle("Bundle", locale);

        Parent root = FXMLLoader.load(
                getClass().getClassLoader().getResource("com/mycompany/barometro/Documento.fxml"), bundle);
        
        scene = new Scene(root, 640, 480);
        stage.setScene(scene);
        stage.show();
    }
    
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainFX.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }
}
