package com.mycompany.barometro;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import java.time.LocalDateTime;

/**
 * @version 2
 * @author Grupo 4
 */
public class VistaBarometro {
    private static ControladorBarometro control;
    private static LocalDateTime fecha;
    private static Double presion;
    private static int predecir;
    
    public VistaBarometro(){
        this.control = new ControladorBarometro(this);
    }
   
    public static void main(String args[]) {
        VistaBarometro vista = new VistaBarometro();
        vista.show(args);
    }
    
    private void show(String args[]){
        HelpFormatter formatter = new HelpFormatter();
        
        Options opts = new Options();
        opts.addOption("h", "Muestra opciones de ayuda");
        opts.addOption("pr", "Muestra la predicción");
        opts.addOption("pe", true, "Añade una nueva presión (también hay que añadir una fecha)");
        opts.addOption("fh", true, "Añade una nueva fecha y una hora (también hay que añadir una presión)");
        opts.addOption("al", true, "Cambia la altitud");
        opts.addOption("G", true, "Poner la interfaz gráfica");

        CommandLineParser parser = new DefaultParser();
        
        try {
            CommandLine cmd = parser.parse(opts, args);
            
            if(cmd.hasOption("h")){
                formatter.printHelp("VistaBarometro", opts);
            }
            if(cmd.hasOption("pe") && cmd.hasOption("fh")) {
                presion = Double.parseDouble(cmd.getOptionValue("p"));
                fecha = LocalDateTime.parse(cmd.getOptionValue("fh"));
                control.addPresion(presion, fecha);
                System.out.println("Se ha añadido una nueva presión.");
            }
            if(cmd.hasOption("pr")){
                predecir = control.getPrediccion();
                switch(predecir){
                    case 1:
                        System.out.println("Va a haber una borrasca, pero pasará lejos.");
                        break;
                    case 2:
                        System.out.println("Va a haber una gran borrasca.");
                        break;
                    case 3:
                        System.out.println("Va a haber un tiempo seco y encalmado de anticiclón.");
                        break;
                    case 4:
                        System.out.println("Va a haber una mejoría que puede ser pasajera, por tratarse del paso de una dorsal anticiclónica entre dos borrascas.");
                        break;
                    case 5:
                        System.out.println("No va a haber grandes cambios en el clima.");
                        break;
                }
            }
            if(cmd.hasOption("al")){
                control.setAltitud(Double.parseDouble(cmd.getOptionValue("al")));
            }
           
        } catch (ParseException ex) {
            formatter.printHelp("VistaBarometro", opts );
        }
    }
}

