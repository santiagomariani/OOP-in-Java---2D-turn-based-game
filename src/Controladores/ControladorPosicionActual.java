package Controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import Vista.*;

public class ControladorPosicionActual implements EventHandler<ActionEvent>{

    @Override
    public void handle(ActionEvent event) {
       System.out.println("Posicion actual: "); 
       System.out.println("X: "+PosicionActual.obtenerInstancia().getX());      
       System.out.println("Y: "+PosicionActual.obtenerInstancia().getY());

	}
}