package Modelo.Juego;

import Modelo.Edificio.*;
import Modelo.Unidad.*;
import Modelo.Excepciones.*;

public class Pieza {
	
	public Posicion posicion;
	public int vida;
	public int costo;
	public int vidaMaxima;
	public Jugador jugador;
	
	public Pieza(Posicion posicion, int vida, int costo, Jugador jugador){
		this.vida = vida;
		this.costo = costo;
		this.posicion = posicion;
		this.vidaMaxima = vida;
		this.jugador = jugador;
	}

	public Posicion obtenerPosicion(){
		return this.posicion;
	}

	public void reducirVidaEn(int unaCantidad){	
		this.vida = this.vida - unaCantidad;
		if(this.vida <= 0){
			this.jugador.eliminarPieza(this);
			Mapa.obtenerInstancia().eliminar(this.posicion);
		}				
	}

	public boolean distanciaAPiezaEsMenorIgualA(int unValor, Pieza pieza){
		return pieza.distanciaAPosicionEsMenorIgualA(unValor, this.posicion);
	}

	public boolean distanciaAPosicionEsMenorIgualA(int unValor, Posicion posicion) {
		return posicion.distanciaAPosicionEsMenorIgualA(unValor, this.posicion);
	}

	public int obtenerVida(){
		return this.vida;
	}

	public int obtenerCosto(){
		return this.costo;
	}

	public boolean esPiezaPropia(Jugador jugador){
		return this.jugador == jugador;
	}
	
}
