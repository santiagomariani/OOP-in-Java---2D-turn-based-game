package Modelo.Unidad;

import Modelo.Edificio.*;
import Modelo.Juego.*;
import Modelo.Excepciones.*;

public class ArmaDeAsedioMontada implements EstadoArmaDeAsedio{

	public void atacar(EdificioAtacable edificioAtacable, ArmaDeAsedio armaDeAsedio, Jugador jugador, int alcance) {
		if(((Pieza)edificioAtacable).esPiezaPropia(jugador)){
			throw new NoEsPosibleAtacarPiezasPropias();
		}
		if(!armaDeAsedio.distanciaAPiezaEsMenorIgualA(alcance,(Pieza)edificioAtacable)){
			throw new NoEsPosibleAtacarEdificioFueraDelAlcanceException();
		}
		edificioAtacable.recibirDanio(armaDeAsedio);
	}

	public void moverArriba(ArmaDeAsedio arma){
		throw new ArmaDeAsedioMontadaNoPuedeMoverse();
	}
	
	public void moverAbajo(ArmaDeAsedio arma){
		throw new ArmaDeAsedioMontadaNoPuedeMoverse();
	}
	
	public void moverDerecha(ArmaDeAsedio arma){
		throw new ArmaDeAsedioMontadaNoPuedeMoverse();
	}
	
	public void moverIzquierda(ArmaDeAsedio arma){
		throw new ArmaDeAsedioMontadaNoPuedeMoverse();
	}
	
	public void moverArribaDerecha(ArmaDeAsedio arma){
		throw new ArmaDeAsedioMontadaNoPuedeMoverse();
	}
	
	public void moverArribaIzquierda(ArmaDeAsedio arma){
		throw new ArmaDeAsedioMontadaNoPuedeMoverse();
	}
	
	public void moverAbajoDerecha(ArmaDeAsedio arma){
		throw new ArmaDeAsedioMontadaNoPuedeMoverse();
	}
	
	public void moverAbajoIzquierda(ArmaDeAsedio arma){
		throw new ArmaDeAsedioMontadaNoPuedeMoverse();
	}

}
