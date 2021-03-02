package com.mycompany.barometro;

import javafx.event.ActionEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.prefs.Preferences;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.*;
import javafx.stage.Stage;
import javax.swing.DefaultListModel;
import org.controlsfx.validation.*;

public class ControladorJavaFX {

    private final ModeloBarometro modelo;
    Calendar fechaActual = new GregorianCalendar();
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    private String cogerFecha, cogerValor;
    private int predecir;
    private double presion, altitud;
    private LocalDateTime fecha;
    
    public ControladorJavaFX(){
        this.modelo = new ModeloBarometro();
    }
    
    public double validaDouble(String number){
        double result = 0; //Valor default.
        try{
            if(number != null){
                result = Double.parseDouble(number);
            }
        }catch(NumberFormatException nfe){
            System.out.println("Ha habido un error al introducir la presión o la fecha, error: " + nfe.getMessage());
            //*No es numerico!
        }
        return result;
    }

    public int getprediccion(){
        return (modelo.prediccion());
    }
    
    public void addPresion(Double presion, LocalDateTime fecha){
        modelo.addPresion(presion, fecha);
    }
    
    public void setAltitud(Double altitud){
        modelo.setAltitud(altitud);
    }
    
    @FXML
    private Button btnPredecir, btnPresion, btnFecha, btnAltitud, btnHistorico;

    @FXML
    private TextField txfPresion, txfAltitud;

    @FXML
    private DatePicker dpFecha;

    @FXML
    private ListView<?> list;

    @FXML
    private Label lblIconos, lblTexto;
    
    private static final String CLASES[] = {"sol", "lluvia", "nubes", "viento"};

    @FXML
    void clcikHistorico(ActionEvent event) {
        DefaultListModel listModel = new DefaultListModel();
        for (int i=0; i<modelo.listaValores.size(); i++){
            listModel.addElement(modelo.listaValores.get(i).toString());
        }
    }

    @FXML
    void clickCambio(ActionEvent event) {
        altitud = validaDouble(txfAltitud.getText());
        if(!txfAltitud.getText().equals("")){
            setAltitud(altitud);
        }
    }

    @FXML
    void clickFecha(ActionEvent event) {
        try{
            Calendar calendario = new GregorianCalendar();
            int hora =calendario.get(Calendar.HOUR_OF_DAY);
            int minutos = calendario.get(Calendar.MINUTE);
            int segundos = calendario.get(Calendar.SECOND);
            String Horas = String.valueOf(hora) + ":" + String.valueOf(minutos) + ":" + String.valueOf(segundos);
            
            cogerFecha = df.format(dpFecha);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            fecha = LocalDateTime.parse(cogerFecha, formatter);
            modelo.addPresion(presion, fecha);
        }
        catch(Exception e){
            System.out.println("Ha habido un error al añadir la fecha y/o la hora, error: " + e.getMessage());
       }
    }

    @FXML
    void clickPrediccion(ActionEvent event) {
        ObservableList<String> clases = lblIconos.getStyleClass();
        clases.removeAll(CLASES);
        ProgressBar progress = new ProgressBar();
        progress.setProgress(0.2);
        ProgressIndicator indicator = new ProgressIndicator(0.6);
        progress.setPrefSize(300, 30);
        HBox hbox = new HBox(20);
        hbox.setSpacing(5);
        hbox.setPadding(new Insets(75,150,50,60));
        hbox.getChildren().addAll(progress, indicator);
        Group root = new Group(hbox);
        Scene scene = new Scene(root, 595, 200, Color.BEIGE);
        Stage stage = null;
        stage.setScene(scene);
        stage.show();
        predecir = getprediccion();
        switch(predecir){
            case 1:
                //Borrasca lejana CARD3(nubes)
                lblTexto.setText("Va a haber una borrasca, pero pasará lejos");
                clases.add(CLASES[2]);
                break;
            case 2:
                //Gran borrasca CARD4(lluvia)
                lblTexto.setText("Va a haber una gran borrasca");
                clases.add(CLASES[1]);
                break;
            case 3:
                //Seco y encalmado CARD5(viento)
                lblTexto.setText("Va a hacer un tiempo seco y encalmado de anticiclón");
                clases.add(CLASES[3]);
                break;
            case 4:
                //mejoria CARD2(sol)
                lblTexto.setText("Va a haber una mejoría");
                clases.add(CLASES[0]);
                break;
            case 5:
                //No cambia
                lblTexto.setText("No va a haber cambios");
                break;
        }
    }

    @FXML
    void clickPresion(ActionEvent event) {

        presion=validaDouble(txfPresion.getText());
        if(!txfPresion.getText().equals("")){
            modelo.addPresion(presion, fecha);
        }
    }
    
    ValidationSupport validacion = new ValidationSupport();

    @FXML
    void initialize() {
        assert lblIconos != null : "fx:id=\"lblIconos\" was not injected: check your FXML file 'Documento.fxml'.";
        assert btnPredecir != null : "fx:id=\"btnPredecir\" was not injected: check your FXML file 'Documento.fxml'.";
        assert btnPresion != null : "fx:id=\"btnPresion\" was not injected: check your FXML file 'Documento.fxml'.";
        assert btnAltitud != null : "fx:id=\"btnAltitud\" was not injected: check your FXML file 'Documento.fxml'.";
        assert btnFecha != null : "fx:id=\"btnFecha\" was not injected: check your FXML file 'Documento.fxml'.";
        assert btnHistorico != null : "fx:id=\"btnHistorico\" was not injected: check your FXML file 'Documento.fxml'.";
        
        validacion.registerValidator(txfPresion, Validator.createEmptyValidator("Se requiere introducir una presión"));
        validacion.registerValidator(txfAltitud, Validator.createEmptyValidator("Se requiere introducir una altitud"));
        validacion.registerValidator(dpFecha, Validator.createEmptyValidator("Se requiere introducir una fecha"));
        
    }
    
    @FXML
    void changeToEn(ActionEvent event) {
        Preferences userPreferences = Preferences.userRoot();
        userPreferences.put("LANG", "en_UK");

    }

    @FXML
    void changeToEs(ActionEvent event) {
        Preferences userPreferences = Preferences.userRoot();
        userPreferences.put("LANG", "es_ES");
    }

    @FXML
    void changeToFr(ActionEvent event) {
        Preferences userPreferences = Preferences.userRoot();
        userPreferences.put("LANG", "fr_FR");
    }
}
