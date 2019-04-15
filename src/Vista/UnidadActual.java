package Vista;

import Modelo.Juego.*;
import Modelo.Unidad.*;
import Controladores.*;

public class UnidadActual{
	Unidad unidad;	

	private static UnidadActual instancia = new UnidadActual();
	
	public void actualizar(int x,int y){
		Jugador jugador = ControladorDeTurno.getInstance().jugadorEnTurno();		
		Unidad unidad = jugador.obtenerUnidad(new Celda(x,y));
		if( unidad == null || !unidad.esPiezaPropia(jugador)){
			return;
		}
		this.unidad = unidad;		
	}	

	public static UnidadActual obtenerInstancia(){		
		return instancia;
	}

	public void reset(){
		this.instancia = new UnidadActual();
	}

	public Unidad unidad(){
		return this.unidad;
	}

}