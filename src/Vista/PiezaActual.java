package Vista;

import Modelo.Juego.*;
import Controladores.*;

public class PiezaActual{
	Pieza pieza = null;

	private static PiezaActual instancia = new PiezaActual();	

	public void actualizar(int x,int y,Juego juego){
		Celda celda = new Celda(x,y);
		Jugador jugador1 = juego.obtenerJugador1();
        Jugador jugador2 = juego.obtenerJugador2();
		Pieza pieza1 = jugador1.obtenerPieza(celda) ;
        Pieza pieza2 = jugador2.obtenerPieza(celda) ;

        if(pieza1 != null){
        	this.pieza = pieza1;
        }
        else if(pieza2 != null){
        	this.pieza = pieza2;
        }       
	}	

	public static PiezaActual obtenerInstancia(){		
		return instancia;
	}

	public void reset(){
		this.instancia = new PiezaActual();
	}

	public Pieza obtenerPieza(){
		return this.pieza;
	}

	public int obtenerVida(){
		if(this.pieza != null){
			return this.pieza.obtenerVida();
		}
		return 0;
	}

}