package Modelo.Edificio;

import Modelo.Juego.*;
import Modelo.Unidad.*;
import Modelo.Excepciones.*;
import java.util.ArrayList;

public class Cuartel extends Edificio implements EdificioAtacable{

	public Cuartel(Celda celdaInicial,Jugador jugador) {
		super(new Zona(celdaInicial, base, altura), 250, 50,jugador, 50, 3);
	}

	static int base = 2;
	static int altura = 2;

	public static int getTamanioBase() {
		return base;
	}
	
	public static int getTamanioAltura() {
		return altura;
	}

	public ArrayList<Celda> posiblesCeldasParaCrearArquero() {
		
		ArrayList<Celda> celdasPosibles = super.posiblesCeldasParaCrearUnidad((Zona)this.posicion, base + 2, altura + 2);
		 
		if(celdasPosibles.isEmpty()){
			throw new NoEsPosibleCrearException();
		}
		
		return celdasPosibles;
	}
	
	public ArrayList<Celda> posiblesCeldasParaCrearEspadachin() {
		
		ArrayList<Celda> celdasPosibles = super.posiblesCeldasParaCrearUnidad((Zona)this.posicion, base + 2, altura + 2);
		 
		if(celdasPosibles.isEmpty()){
			throw new NoEsPosibleCrearException();
		}
		
		return celdasPosibles;
	}
	
	public void crearArquero(Celda unaCelda) {
		ArrayList<Celda> celdasPosibles = posiblesCeldasParaCrearArquero();
		for(Celda celda : celdasPosibles){
			if(celda.igualA(unaCelda)){				
				Arquero arquero = new Arquero(celda, this.jugador);
				this.jugador.disminuirOro(arquero.obtenerCosto());
				this.jugador.agregarPieza(arquero);				
				Mapa.obtenerInstancia().insertar(celda);
				return;
			}
		}
		throw new NoEsPosibleCrearException();		
	}
	
	public void crearEspadachin(Celda unaCelda) {
		ArrayList<Celda> celdasPosibles = posiblesCeldasParaCrearEspadachin();
		for(Celda celda : celdasPosibles){
			if(celda.igualA(unaCelda)){				
				Espadachin espadachin = new Espadachin(celda, this.jugador);
				this.jugador.disminuirOro(espadachin.obtenerCosto());
				this.jugador.agregarPieza(espadachin);				
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
