package Modelo.Unidad;

import Modelo.Edificio.*;
import Modelo.Juego.*;
import Modelo.Excepciones.*;

public class Arquero extends Unidad implements AtacanteDeUnidades, AtacanteDeEdificios, UnidadAtacable{

	private int alcance = 3;

	public Arquero(Celda celda, Jugador jugador) {
		super(celda, 75, 75,jugador);
	}

	public void atacar(UnidadAtacable unidadAtacable){
		
		if(!haAtacado){
			if(((Pieza)unidadAtacable).esPiezaPropia(this.jugador)){
				throw new NoEsPosibleAtacarPiezasPropias();
			}
			if(!this.distanciaAPiezaEsMenorIgualA(this.alcance,(Pieza)unidadAtacable)){
				throw new NoEsPosibleAtacarUnidadFueraDelAlcanceException();
			}
			unidadAtacable.recibirDanio(this);
			this.inhabilitarAtaque();
		}
		else{
			throw new UnidadYaAtacoException();
		}
	}

	public void atacar(EdificioAtacable edificioAtacable){
		if(((Pieza)edificioAtacable).esPiezaPropia(this.jugador)){
			throw new NoEsPosibleAtacarPiezasPropias();
		}
		if(!this.distanciaAPiezaEsMenorIgualA(this.alcance,(Pieza)edificioAtacable)){
			throw new NoEsPosibleAtacarEdificioFueraDelAlcanceException();
		}
		edificioAtacable.recibirDanio(this);
	}

	public void recibirDanio(Arquero arquero){
		this.reducirVidaEn(15);
		this.verificarVida();
	}

	public void recibirDanio(Espadachin espadachin){
		this.reducirVidaEn(25);
		this.verificarVida();
	}

	public void recibirDanio(Castillo castillo){
		this.reducirVidaEn(20);
		this.verificarVida();
	}
}
