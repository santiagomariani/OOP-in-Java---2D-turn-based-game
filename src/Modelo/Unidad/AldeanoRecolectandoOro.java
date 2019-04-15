package Modelo.Unidad;

import Modelo.Edificio.*;
import Modelo.Juego.*;
import Modelo.Excepciones.*;
import Modelo.Edificio.*;

public class AldeanoRecolectandoOro implements EstadoAldeano{
	int cantidadDeOroRecolectado = 20;
	
	@Override
	public void repararEdificio(Edificio edificio, Aldeano aldeano) {
		if(!aldeano.posicionValidaParaRepararEdificio(edificio)){
			throw new NoEsPosibleRepararException();
		}
		edificio.reparando(true);
		aldeano.comienzaAReparar(edificio);		
	}	

	@Override
	public void desocuparse(Aldeano aldeano) {
		return;
	}

	@Override
	public void construirCuartel(Zona zona, Aldeano aldeano) {
		if(!aldeano.posicionValidaParaConstruirEdificio(zona)){
			throw new NoEsPosibleConstruirException();
		}
		aldeano.comienzaAConstruirUnCuartelEnZona(zona);		
	}

	@Override
	public void construirPlazaCentral(Zona zona, Aldeano aldeano) {
		if(!aldeano.posicionValidaParaConstruirEdificio(zona)){
			throw new NoEsPosibleConstruirException();
		}
		aldeano.comienzaAConstruirUnaPlazaCentralEnZona(zona);		
	}

	public boolean aldeanoLibre(){
		return true;
	}

	public void realizarTareas(Aldeano aldeano,Jugador jugador){
		jugador.aumentarOro(cantidadDeOroRecolectado);
	}

}