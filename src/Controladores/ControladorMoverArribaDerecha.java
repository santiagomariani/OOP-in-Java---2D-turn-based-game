package Controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import Modelo.Unidad.*;
import Modelo.Juego.*;
import Modelo.Excepciones.*;
import Vista.*;


public class ControladorMoverArribaDerecha implements EventHandler<ActionEvent>{

	ContenedorPrincipal contenedor;

	public ControladorMoverArribaDerecha(ContenedorPrincipal contenedor){
		this.contenedor = contenedor;
	}

    @Override
    public void handle(ActionEvent event) {
        System.out.println("Mueve arriba derecha");
        Jugador jugadorActual = ControladorDeTurno.getInstance().jugadorEnTurno();
        Unidad unidadActual = UnidadActual.obtenerInstancia().unidad();
        try{
            unidadActual.moverArribaDerecha();   
        }        
        catch(CeldaInvalidaException e){
            new Alerta().fueraDeRango();
        }
        catch(CeldaOcupadaException e){
            new Alerta().celdaOcupada();
        } 
        catch(UnidadYaMovidaException e){
            new Alerta().unidadYaMovida();
        }
        this.contenedor.actualizar();
	}
}