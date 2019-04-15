package Modelo.Edificio;

import Modelo.Juego.*;
import Modelo.Unidad.*;
import Modelo.Excepciones.*;

import java.util.ArrayList;

public class PlazaCentral extends Edificio implements EdificioAtacable {

	public PlazaCentral(Celda celdaInicial, Jugador jugador) {
		super(new Zona(celdaInicial, base, altura), 450, 100,jugador, 25, 3);
	}

	static int base = 2;
	static int altura = 2;

	public static int getTamanioBase() {
		return base;
	}
	
	public static int getTamanioAltura() {
		return altura;
	}

	public ArrayList<Celda> posiblesCeldasParaCrearAldeano() {
		
		ArrayList<Celda> celdasPosibles = super.posiblesCeldasParaCrearUnidad((Zona)this.posicion, base + 2, altura + 2);
		
		if(celdasPosibles.isEmpty()){
			throw new NoEsPosibleCrearException();
		}
		
		return celdasPosibles;
	}

	public void crearAldeano(Celda unaCelda) {
		ArrayList<Celda> celdasPosibles = posiblesCeldasParaCrearAldeano();
		for(Celda celda: celdasPosibles){
			if(celda.igualA(unaCelda)){				
				Aldeano aldeano = new Aldeano(celda,this.jugador);
				this.jugador.disminuirOro(aldeano.obtenerCosto());
				this.jugador.agregarPieza(aldeano);				
				Mapa.obtenerInstancia().insertar(celda);
				return;
			}
		}
		throw new NoEsPosibleCrearException();		
	}

	public void recibirDanio(Arquero arquero){
		this.reducirVidaEn(10);
		this.verificarVida();
	}

	public void recibirDanio(Espadachin espadachin){
		this.reducirVidaEn(15);
		this.verificarVida();
	}

	public void recibirDanio(ArmaDeAsedio armaDeAsedio){
		this.reducirVidaEn(75);
		this.verificarVida();
	}

	public void recibirDanio(Castillo castillo){
		this.reducirVidaEn(20);
		this.verificarVida();
	}

	public void verificarVida(){
		if(this.vida < 1 ){
			this.jugador.eliminarPieza(this);
			Mapa.obtenerInstancia().eliminar(this.posicion);
		}
	}

}
