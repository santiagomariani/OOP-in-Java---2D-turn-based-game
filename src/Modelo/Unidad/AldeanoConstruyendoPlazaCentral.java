package Modelo.Unidad;

import Modelo.Edificio.*;
import Modelo.Juego.*;
import Modelo.Excepciones.*;
import Modelo.Edificio.*;

public class AldeanoConstruyendoPlazaCentral implements EstadoAldeano{

	final int turnosNecesarios = 3;
	int turnosConstruyendo ;
	Zona zonaEnQueSeConstruye ;

	public AldeanoConstruyendoPlazaCentral(Zona zona){
		this.zonaEnQueSeConstruye = zona;
		this.turnosConstruyendo = 0;
	}

	@Override
	public void repararEdificio(Edificio edificio, Aldeano aldeano) {
		throw new AldeanoOcupado();
	}	

	@Override
	public void desocuparse(Aldeano aldeano) {
		throw new AldeanoOcupado();
	}

	@Override
	public void construirCuartel(Zona zona,Aldeano aldeano) {
		throw new AldeanoOcupado();
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
			Mapa.obtenerInstancia().insertar(this.zonaEnQueSeConstruye);
			PlazaCentral plazaCentral = new PlazaCentral(this.zonaEnQueSeConstruye.getCeldaArribaIzquierda(),jugador );
			jugador.agregarPieza(plazaCentral) ;
			aldeano.actualizarEstado(new AldeanoRecolectandoOro());
		}
	}
}
