package com.mycompany.barometro;

import java.time.LocalDateTime;

/**
 * @version 1
 * @author Grupo 4
 */
public class ControladorBarometro {
    private ModeloBarometro modelo;
    private VistaBarometro vista;
    public static double presion;
    public static String fecha;
    
    public ControladorBarometro(VistaBarometro vista){
        this.vista = vista;
        this.modelo = new ModeloBarometro();
    }
    
    public void setAltitud(Double altitud){
        modelo.setAltitud(altitud);
    }
    
    public int getPrediccion(){
        return(modelo.prediccion());
    }
    
    public void addPresion(Double presion, LocalDateTime fecha){
        modelo.addPresion(presion, fecha);
    }
}