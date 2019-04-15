package Vista;

import Modelo.Juego.*;
import Modelo.Edificio.*;
import Controladores.*;

public class EdificioActual{
	Edificio edificio;	

	private static EdificioActual instancia = new EdificioActual();
	
	public void actualizar(int x,int y){
		Jugador jugador = ControladorDeTurno.getInstance().jugadorEnTurno();		
		Edificio edificio = jugador.obtenerEdificio(new Zona(new Celda(x,y),2,2));
		if( edificio == null || !edificio.esPiezaPropia(jugador)){
			return;
		}
		this.edificio = edificio;		
	}	

	public static EdificioActual obtenerInstancia(){		
		return instancia;
	}

	public Edificio edificio(){
		return this.edificio;
	}

}