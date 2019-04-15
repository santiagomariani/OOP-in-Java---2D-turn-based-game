package Modelo.Unidad;

import Modelo.Edificio.*;
import Modelo.Juego.*;
import Modelo.Excepciones.*;
import Modelo.Edificio.*;


public class AldeanoConstruyendoCuartel implements EstadoAldeano{

	final int turnosNecesarios = 3;
	int turnosConstruyendo ;
	Zona zonaEnQueSeConstruye ;

	public AldeanoConstruyendoCuartel(Zona zona){
		this.zonaEnQueSeConstruye = zona;
		this.turnosConstruyendo = 0;
		Mapa.obtenerInstancia().insertar(this.zonaEnQueSeConstruye);		
	}

	@Override
	public void repararEdificio(Edificio edificio , Aldeano aldeano) {
		throw new AldeanoOcupado();
	}		

	@Override
	public void desocuparse(Aldeano aldeano) {
		throw new AldeanoOcupado();
	}

	@Override
	public void construirCuartel(Zona zona,Aldeano aldeano) {
		if(zona != this.zonaEnQueSeConstruye){
			throw new AldeanoOcupado();
		}
		else{
			throw new AldeanoOcupado();	
		}			
	}

	@Override
	public void construirPlazaCentral(Zona zona,Aldeano aldeano) {
		throw new AldeanoOcupado();
	}

	public boolean aldeanoLibre(){
		return false;
	}

	public void realizarTareas(Aldeano aldeano,Jugador jugador){
		this.turnosConstruyendo += 1;
		if(this.turnosConstruyendo == this.turnosNecesarios ){			
			Cuartel cuartel = new Cuartel(this.zonaEnQueSeConstruye.getCeldaArribaIzquierda(),jugador);
			jugador.agregarPieza(cuartel) ;
			aldeano.actualizarEstado(new AldeanoRecolectandoOro());
		}
	}
}
