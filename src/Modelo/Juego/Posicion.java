package Modelo.Juego;

import Modelo.Edificio.*;
import Modelo.Unidad.*;
import Modelo.Excepciones.*;

public interface Posicion {

	boolean enRango(int altura, int base);

	boolean igualA(Posicion unaPosicion);

	boolean igualA(Celda unaCelda);

	boolean igualA(Zona unaZona);

	boolean distanciaAPosicionEsMenorIgualA(int unValor, Posicion unaPosicion);

	boolean distanciaAZonaEsMenorIgualA(int unValor, Zona unaZona);

	boolean distanciaACeldaEsMenorIgualA(int unValor, Celda unaCelda);

	boolean contiene(Celda unaCelda);
}
