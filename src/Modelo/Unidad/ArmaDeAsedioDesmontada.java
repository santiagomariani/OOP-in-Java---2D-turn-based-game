package Modelo.Unidad;

import Modelo.Edificio.*;
import Modelo.Excepciones.*;
import Modelo.Juego.Jugador;

public class ArmaDeAsedioDesmontada implements EstadoArmaDeAsedio{

	@Override
	public void atacar(EdificioAtacable edificioAtacable, ArmaDeAsedio armaDeAsedio, Jugador jugador, int alcance) {
		throw new ArmaDeAsedioDesmontadaNoPuedeActacar();
	}

	public void moverArriba(ArmaDeAsedio arma){
		return;
	}
	
	public void moverAbajo(ArmaDeAsedio arma){
		return;
	}

	public void moverDerecha(ArmaDeAsedio arma){
		return;
	}
	
	public void moverIzquierda(ArmaDeAsedio arma){
		return;
	}
	
	public void moverArribaDerecha(ArmaDeAsedio arma){
		return;
	}
	
	public void moverArribaIzquierda(ArmaDeAsedio arma){
		return;
	}
	
	public void moverAbajoDerecha(ArmaDeAsedio arma){
		return;
	}
	
	public void moverAbajoIzquierda(ArmaDeAsedio arma){
		return;
	}

}
