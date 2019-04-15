package Modelo.Unidad;

import Modelo.Edificio.*;
import Modelo.Juego.*;
import Modelo.Excepciones.*;

public class Movimiento {

	public void moverArriba(Celda celda) {
		Celda celdaNueva = celda.crearCeldaIgual();
		celdaNueva.desplazarArriba();
		Mapa.obtenerInstancia().mover(celdaNueva);
		celda.desplazarArriba();
	}	
	public void moverAbajo(Celda celda) {
		Celda celdaNueva = celda.crearCeldaIgual();
		celdaNueva.desplazarAbajo();
		Mapa.obtenerInstancia().mover(celdaNueva);
		celda.desplazarAbajo();
	}
	public void moverDerecha(Celda celda) {
		Celda celdaNueva = celda.crearCeldaIgual();
		celdaNueva.desplazarDerecha();
		Mapa.obtenerInstancia().mover(celdaNueva);
		celda.desplazarDerecha();
	}
	public void moverIzquierda(Celda celda) {
		Celda celdaNueva = celda.crearCeldaIgual();
		celdaNueva.desplazarIzquierda();
		Mapa.obtenerInstancia().mover(celdaNueva);
		celda.desplazarIzquierda();
	}
	public void moverArribaDerecha(Celda celda) {
		Celda celdaNueva = celda.crearCeldaIgual();
		celdaNueva.desplazarArribaDerecha();
		Mapa.obtenerInstancia().mover(celdaNueva);
		celda.desplazarArribaDerecha();
	}
	public void moverArribaIzquierda(Celda celda) {
		Celda celdaNueva = celda.crearCeldaIgual();
		celdaNueva.desplazarArribaIzquierda();
		Mapa.obtenerInstancia().mover(celdaNueva);
		celda.desplazarArribaIzquierda();
	}
	public void moverAbajoDerecha(Celda celda) {
		Celda celdaNueva = celda.crearCeldaIgual();
		celdaNueva.desplazarAbajoDerecha();
		Mapa.obtenerInstancia().mover(celdaNueva);
		celda.desplazarAbajoDerecha();
	}
	public void moverAbajoIzquierda(Celda celda) {
		Celda celdaNueva = celda.crearCeldaIgual();
		celdaNueva.desplazarAbajoIzquierda();
		Mapa.obtenerInstancia().mover(celdaNueva);
		celda.desplazarAbajoIzquierda();
	}

}
