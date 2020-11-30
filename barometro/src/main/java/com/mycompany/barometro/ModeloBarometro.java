package com.mycompany.barometro;

import java.util.List;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.Month;
/**
 * @version 4
 * @author Grupo 4
 */
public class ModeloBarometro {
    private Double altitud = 0.0;
    
    List<valores> listaValores = new ArrayList<valores>();
    
    public class valores{
        Double presion;
        LocalDateTime fecha;
        
        public valores(Double presion, LocalDateTime fecha) {
            this.presion = presion;
            this.fecha = fecha;
        }
        
        public Double getPresion(){
            return presion;
        }
    }
    
    public ModeloBarometro(){
        listaValores.add(new valores(1013.25, LocalDateTime.of(2020, Month.NOVEMBER, 28, 00, 00, 00)));
        listaValores.add(new valores(1013.25, LocalDateTime.of(2020, Month.NOVEMBER, 28, 1, 00, 00)));
        listaValores.add(new valores(1013.25, LocalDateTime.of(2020, Month.NOVEMBER, 28, 2, 00, 00)));
        listaValores.add(new valores(1013.25, LocalDateTime.of(2020, Month.NOVEMBER, 28, 3, 00, 00)));
        listaValores.add(new valores(1013.25, LocalDateTime.of(2020, Month.NOVEMBER, 28, 4, 00, 00)));
        listaValores.add(new valores(1013.25, LocalDateTime.of(2020, Month.NOVEMBER, 28, 5, 00, 00)));
        listaValores.add(new valores(1013.25, LocalDateTime.of(2020, Month.NOVEMBER, 28, 6, 00, 00)));
        listaValores.add(new valores(1013.25, LocalDateTime.of(2020, Month.NOVEMBER, 28, 7, 00, 00)));
        listaValores.add(new valores(1013.25, LocalDateTime.of(2020, Month.NOVEMBER, 28, 8, 00, 00)));
        listaValores.add(new valores(1013.25, LocalDateTime.of(2020, Month.NOVEMBER, 28, 9, 00, 00)));
        listaValores.add(new valores(1013.25, LocalDateTime.of(2020, Month.NOVEMBER, 28, 10, 00, 00)));
        listaValores.add(new valores(1013.25, LocalDateTime.of(2020, Month.NOVEMBER, 28, 11, 00, 00)));
        listaValores.add(new valores(1013.25, LocalDateTime.of(2020, Month.NOVEMBER, 28, 12, 00, 00)));
        listaValores.add(new valores(1013.25, LocalDateTime.of(2020, Month.NOVEMBER, 28, 13, 00, 00)));
        listaValores.add(new valores(1013.25, LocalDateTime.of(2020, Month.NOVEMBER, 28, 14, 00, 00)));
        listaValores.add(new valores(1013.25, LocalDateTime.of(2020, Month.NOVEMBER, 28, 15, 00, 00)));
        listaValores.add(new valores(1013.25, LocalDateTime.of(2020, Month.NOVEMBER, 28, 16, 00, 00)));
        listaValores.add(new valores(1013.25, LocalDateTime.of(2020, Month.NOVEMBER, 28, 17, 00, 00)));
        listaValores.add(new valores(1013.25, LocalDateTime.of(2020, Month.NOVEMBER, 28, 18, 00, 00)));
        listaValores.add(new valores(1013.25, LocalDateTime.of(2020, Month.NOVEMBER, 28, 19, 00, 00)));
        listaValores.add(new valores(1013.25, LocalDateTime.of(2020, Month.NOVEMBER, 28, 20, 00, 00)));
        listaValores.add(new valores(1013.25, LocalDateTime.of(2020, Month.NOVEMBER, 28, 21, 00, 00)));
        listaValores.add(new valores(1050.00, LocalDateTime.of(2020, Month.NOVEMBER, 28, 22, 00, 00)));
        listaValores.add(new valores(1100.50, LocalDateTime.of(2020, Month.NOVEMBER, 28, 23, 00, 00)));
        listaValores.add(new valores(1100.50, LocalDateTime.of(2020, Month.NOVEMBER, 29, 00, 00, 00)));
    }
    
    public void addPresion(Double presion, LocalDateTime fecha){
        listaValores.add(new valores(presion, fecha));
    }
    
    public int prediccion(){
        Double haceHoras = listaValores.get(listaValores.size() - 25).getPresion();
        Double ultimaHora = listaValores.get(listaValores.size() - 1).getPresion();
        Double horaAnterior = listaValores.get(listaValores.size() - 2).getPresion();
        
        if(haceHoras - ultimaHora > 6){
            //La borrasca pasará lejos
            return 1;
        }
        else if(horaAnterior - ultimaHora > 1){
            //Se acerca una gran borrasca
            return 2;
        }
        else if(ultimaHora - haceHoras > 6){
            //Hará un tiempo seco y encalmado de anticiclón
            return 3;
        }
        else if(ultimaHora - horaAnterior > 1){
            //Habrá una mejoría que puede ser pasajera, por tratarse del paso de una dorsal anticiclónica entre dos borrascas
            return 4;
        }
        else{
            //No habrá un gran cambio
            return 5;
        }
    }
    
    public void setAltitud(Double altitud){
        this.altitud = altitud;
    }
}