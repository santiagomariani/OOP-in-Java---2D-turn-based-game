package Modelo.Juego;

import Modelo.Edificio.*;
import Modelo.Unidad.*;
import Modelo.Excepciones.*;
import java.util.ArrayList;

public class Mapa {
	
	int altura;
	int base;
	ArrayList<Posicion> posiciones;

	private static Mapa instancia = new Mapa();
	
	public Mapa(){
		this.altura = 20;
		this.base = 20;
		this.posiciones = new ArrayList<Posicion>();		
	}

	public static Mapa obtenerInstancia(){		       
		return Mapa.instancia;
	}

	public static void reset(){
		instancia = new Mapa();
	}
	
	public void mover(Celda celdaNueva){
		this.posicionEsValida(celdaNueva);
	}

	public void insertar(Posicion unaPosicion) {
		this.posicionEsValida(unaPosicion);
		this.posiciones.add(unaPosicion);
	}

	public void eliminar(Posicion unaPosicion){
		this.posiciones.remove(unaPosicion);
	}

	private void posicionEsValida(Posicion posicion) {
		if(! posicion.enRango(this.altura, this.base)){
			throw new CeldaInvalidaException();
		}
		if(this.posicionOcupada(posicion)){
			throw new CeldaOcupadaException();
		}
	}

	public boolean posicionOcupada(Posicion unaPosicion) {
		for(Posicion posicion: this.posiciones){
			if(unaPosicion.igualA(posicion)) return true;
		}
		return false;
	}
	
	public int getTamanioBase() {
		return base;
	}

	public int getTamanioAltura() {
		return altura;
	}

	public boolean enRango(Posicion unaPosicion) {
		return unaPosicion.enRango(this.altura, this.base);
	}

	public ArrayList<Zona> buscarZonasPosibles(Celda celdaDeBusqueda, Zona zonaDeBusqueda, int base, int altura) {
		int baseZonaDeBusqueda = 2 * base + 1 ;
		int alturaZonaDeBusqueda = 2 * altura + 1 ;
		ArrayList<Zona> zonasPosibles = new ArrayList<Zona>();
		
		for(int i = 0 ; i < alturaZonaDeBusqueda; i++){
			for(int j = 0 ; j < baseZonaDeBusqueda; j++){
				Celda celdaNueva = celdaDeBusqueda.crearCeldaIgual();
				celdaNueva.desplazarHorizontalmente(j);
				celdaNueva.desplazarVerticalmente(-i);
				Zona posibleZona = new Zona(celdaNueva, base, altura);
				if(posibleZona.dentroDe(zonaDeBusqueda) && ! this.posicionOcupada(posibleZona) && this.enRango(posibleZona)){
					zonasPosibles.add(posibleZona);
				}
			}
		}
		return zonasPosibles;
	}

	public ArrayList<Celda> buscarPosiblesCeldas(Celda celdaInicialDeBusqueda, Zona zonaDeBusqueda, int base, int altura) {
		ArrayList<Celda> celdasPosibles = new ArrayList<Celda>();
		
		for(int i = 0 ; i < altura ; i++){
			for(int j = 0 ; j < base ; j++){
				Celda posibleCelda = celdaInicialDeBusqueda.crearCeldaIgual();
				posibleCelda.desplazarHorizontalmente(j);
				posibleCelda.desplazarVerticalmente(-i);
				if(posibleCelda.igualA(zonaDeBusqueda) && ! this.posicionOcupada(posibleCelda) && this.enRango(posibleCelda)){
					celdasPosibles.add(posibleCelda);
				}
			}
		}
		return celdasPosibles;
	}
	
}
