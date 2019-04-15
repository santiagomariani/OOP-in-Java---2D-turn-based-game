package Modelo.Juego;

import Modelo.Edificio.*;
import Modelo.Unidad.*;
import java.util.ArrayList;

public class Juego {
	Jugador jugador1;
	Jugador jugador2;
	int cantidadDeOroInicial;
	ArrayList<Jugador> jugadores;	
	
	public Juego(String nombreJugador1, String nombreJugador2){		
		this.cantidadDeOroInicial = 100;
		this.inicializarJugadores(nombreJugador1, nombreJugador2);
	}

	private void inicializarJugadores(String nombreJugador1, String nombreJugador2) {
		this.inicializarJugador1(nombreJugador1);
		this.inicializarJugador2(nombreJugador2);

		jugador1.setearJugadorOponente(jugador2);
		jugador2.setearJugadorOponente(jugador1);
		
		this.jugadores = new ArrayList<Jugador>();
		this.jugadores.add(this.jugador1);
		this.jugadores.add(this.jugador2);	
	}

	private void inicializarJugador1(String nombreJugador) {
		this.jugador1 = new Jugador(this.cantidadDeOroInicial, nombreJugador);
		int alturaMapa = Mapa.obtenerInstancia().getTamanioAltura();
		int baseCastillo = Castillo.getTamanioBase();
		int alturaCastillo = Castillo.getTamanioAltura();

		Celda celdaInicial = new Celda(0, alturaMapa-1);		
		Castillo castillo = new Castillo(celdaInicial, this.jugador1);
		this.jugador1.setearCastillo(castillo);
		Mapa.obtenerInstancia().insertar(new Zona(celdaInicial,baseCastillo,alturaCastillo));

		// Primer aldeano
		celdaInicial.desplazarVerticalmente(-alturaCastillo - 1);
		celdaInicial.desplazarDerecha();
		Celda celda1 = celdaInicial.crearCeldaIgual();	
		Mapa.obtenerInstancia().insertar(celda1);

		// Segundo aldeano
		celdaInicial.desplazarHorizontalmente(baseCastillo);
		Celda celda2 = celdaInicial.crearCeldaIgual();	
		Mapa.obtenerInstancia().insertar(celda2);		
		
		// Tercer aldeano
		celdaInicial.desplazarVerticalmente(alturaCastillo);
		Celda celda3 = celdaInicial.crearCeldaIgual();
		Mapa.obtenerInstancia().insertar(celda3);	

		//PlazaCentral
		celdaInicial.desplazarHorizontalmente(2);
		Celda celda4 = celdaInicial.crearCeldaIgual();
		Mapa.obtenerInstancia().insertar(new Zona(celda4,PlazaCentral.getTamanioBase(),PlazaCentral.getTamanioAltura()));
		
		this.jugador1.agregarPieza(new Aldeano(celda1, this.jugador1 ));
		this.jugador1.agregarPieza(new Aldeano(celda2, this.jugador1 ));
		this.jugador1.agregarPieza(new Aldeano(celda3, this.jugador1 ));
		this.jugador1.agregarPieza(new PlazaCentral(celda4, this.jugador1 ));
	}

	private void inicializarJugador2(String nombreJugador) {
		this.jugador2 = new Jugador(this.cantidadDeOroInicial, nombreJugador);
		int baseCastillo = Castillo.getTamanioBase();
		int alturaCastillo = Castillo.getTamanioAltura();
		int baseMapa = Mapa.obtenerInstancia().getTamanioBase();		
		
		Celda celdaInicial = new Celda(baseMapa - baseCastillo , alturaCastillo - 1);	
		Castillo castillo = new Castillo(celdaInicial, this.jugador2);
		this.jugador2.setearCastillo(castillo);
		Mapa.obtenerInstancia().insertar(new Zona(celdaInicial,baseCastillo,alturaCastillo));
		
		// Primer aldeano
		celdaInicial.desplazarHorizontalmente(baseCastillo - 2);
		celdaInicial.desplazarVerticalmente(2);		
		Celda celda1 = celdaInicial.crearCeldaIgual();
		Mapa.obtenerInstancia().insertar(celda1);		
		
		// Segundo aldeano
		celdaInicial.desplazarHorizontalmente(-baseCastillo);
		Celda celda2 = celdaInicial.crearCeldaIgual();	
		Mapa.obtenerInstancia().insertar(celda2);		
		
		// Tercer aldeano
		celdaInicial.desplazarVerticalmente(-alturaCastillo);
		Celda celda3 = celdaInicial.crearCeldaIgual();	
		Mapa.obtenerInstancia().insertar(celda3);		

		//PlazaCentral
		celdaInicial.desplazarHorizontalmente(-3);
		celdaInicial.desplazarVerticalmente(1);
		Celda celda4 = celdaInicial.crearCeldaIgual();
		Mapa.obtenerInstancia().insertar(new Zona(celda4,PlazaCentral.getTamanioBase(),PlazaCentral.getTamanioAltura()));
		
		this.jugador2.agregarPieza(new Aldeano(celda1, this.jugador2 ));
		this.jugador2.agregarPieza(new Aldeano(celda2, this.jugador2 ));
		this.jugador2.agregarPieza(new Aldeano(celda3, this.jugador2) );
		this.jugador2.agregarPieza(new PlazaCentral(celda4, this.jugador2));			
				
	}

	public Jugador obtenerJugador1(){
		return jugador1;
	}

	public Jugador obtenerJugador2(){
		return jugador2;
	}

	public ArrayList<Jugador> obtenerJugadores(){
		return this.jugadores;
	}
	
}
