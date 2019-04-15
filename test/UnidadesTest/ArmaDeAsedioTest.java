
package UnidadesTest;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

import Modelo.Edificio.*;
import Modelo.Unidad.*;
import Modelo.Excepciones.*;
import Modelo.Juego.*;

public class ArmaDeAsedioTest{
	@Before
	public void reset(){
		Mapa.reset();
	}

	@Test
	public void test01ArmaDeAsedioDesmontadaSePuedeMover(){

		Celda celda = new Celda(15, 15);
		Jugador jugador = new Jugador(100, "Mario");
		Castillo castillo = new Castillo(celda, jugador);
		jugador.aumentarOro(200);
		ArrayList<Celda> celdasPosibles = castillo.posiblesCeldasParaCrearArmaDeAsedio();
		Celda celdaACrear = celdasPosibles.get(0); // celda = (14,16)
		castillo.crearArmaDeAsedio(celdaACrear);

		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(celdaACrear));

		ArmaDeAsedio arma = (ArmaDeAsedio)jugador.obtenerUnidad(celdaACrear);
		arma.moverArriba();

		Assert.assertFalse(Mapa.obtenerInstancia().posicionOcupada(new Celda(14,16)));
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(new Celda(14,17)));
	}

	@Test
	public void test02ArmaDeAsedioMontadaNoSePuedeMover(){

		Celda celda = new Celda(15, 15);
		Jugador jugador = new Jugador(100, "Mario");
		Castillo castillo = new Castillo(celda, jugador);

		ArrayList<Celda> celdasPosibles = castillo.posiblesCeldasParaCrearArmaDeAsedio();
		Celda celdaACrear = celdasPosibles.get(0); //celda=(14,16)
		jugador.aumentarOro(200);
		castillo.crearArmaDeAsedio(celdaACrear);
		ArmaDeAsedio arma = (ArmaDeAsedio)jugador.obtenerUnidad(celdaACrear);
		arma.actualizarEstado(new ArmaDeAsedioMontada());

		
		try{
			arma.moverArriba();
		} catch(ArmaDeAsedioMontadaNoPuedeMoverse e){ }
	}
}
