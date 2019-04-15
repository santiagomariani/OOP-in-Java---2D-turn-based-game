package Controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import Modelo.Unidad.*;
import Modelo.Juego.*;
import Modelo.Excepciones.*;
import Vista.*;


public class ControladorMoverArriba implements EventHandler<ActionEvent>{

	ContenedorPrincipal contenedor;

	public ControladorMoverArriba(ContenedorPrincipal contenedor){
		this.contenedor = contenedor;
	}

    @Override
    public void handle(ActionEvent event) {
        System.out.println("Mueve arriba");
        Jugador jugadorActual = ControladorDeTurno.getInstance().jugadorEnTurno();
        Unidad unidadActual = UnidadActual.obtenerInstancia().unidad();
        try{
            unidadActual.moverArriba(); 
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