package Modelo.Juego;

import Modelo.Edificio.*;
import Modelo.Unidad.*;
import Modelo.Excepciones.*;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class Zona implements Posicion{
	
	ArrayList<Celda> celdas;
	int base;
	int altura;

	public Zona(Celda celdaInicial, int base, int altura) {
		this.base = base;
		this.altura = altura;
		this.celdas = new ArrayList<Celda>();
		this.inicializarPosiciones(celdaInicial);
	}
	
	private void inicializarPosiciones(Celda celdaInicial) {
		for(int i = 0 ; i < this.altura ; i++){
			for(int j = 0 ; j < this.base ; j++){
				Celda nuevaCelda = celdaInicial.crearCeldaIgual();
				nuevaCelda.desplazarHorizontalmente(j);
				nuevaCelda.desplazarVerticalmente(-i);
				this.celdas.add(nuevaCelda);
			}
		}
		
	}

	@Override
	public boolean igualA(Celda unaCelda) {
		for(Celda celda: celdas){
			if(unaCelda.igualA(celda)) return true;
		}
		return false;
	}
	
	@Override
	public boolean igualA(Zona unaZona){
		for(Celda celda: celdas){
			if(unaZona.igualA(celda)) return true;
		}
		return false;
	}

	@Override
	public boolean enRango(int altura, int base) {
		for(Celda celda: celdas){
			if(! celda.enRango(altura, base)) return false;
		}
		return true;
	}

	@Override
	public boolean igualA(Posicion unaPosicion) {
		return unaPosicion.igualA(this);
	}

	public boolean dentroDe(Zona unaZona) {
		for(Celda celda: celdas){
			if(! unaZona.igualA(celda)) return false;
		}
		return true;
	}
	
	public Celda getCeldaArribaIzquierda(){
		return celdas.get(0);
	}

	public boolean estaAlLadoDe(Celda celda){
		if(this.igualA(celda)){
			return false;
		}
		for(Celda celdaZona: celdas){
			if(celda.estaAlLadoDe(celdaZona)){
				return true;
			}
		}
		return false;
	}


	public boolean distanciaAPosicionEsMenorIgualA(int unValor, Posicion unaPosicion){
		return unaPosicion.distanciaAZonaEsMenorIgualA(unValor, this);
	}

	public boolean distanciaAZonaEsMenorIgualA(int unValor, Zona otraZona){
		for(Celda celda: this.celdas){
			if(otraZona.distanciaACeldaEsMenorIgualA(unValor,celda)) return true;
		}
		return false;
	}

	public boolean distanciaACeldaEsMenorIgualA(int unValor, Celda unaCelda){
		for(Celda celda: this.celdas){
			if(unaCelda.distanciaACeldaEsMenorIgualA(unValor,celda)) return true;
		}
		return false;
	}

	public boolean contiene(Celda unacelda){
		for(Celda celda: this.celdas){
			if(celda.igualA(unacelda)){
				return true;
			}
		}
		return false;
	}

}
