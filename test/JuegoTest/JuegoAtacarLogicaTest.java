package JuegoTest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

import Modelo.Unidad.*;
import Modelo.Excepciones.*;
import Modelo.Juego.*;

public class JuegoAtacarLogicaTest {	

	@Before
	public void reset(){
		Mapa.reset();
	}

	@Test
	public void test01JugadoresNoPuedenAtacarPiezasPropias(){

		Juego juego = new Juego("Juan", "Luis");
		Jugador jugador1 = juego.obtenerJugador1();
		Jugador jugador2 = juego.obtenerJugador2();		

		Espadachin espadachin1 = new Espadachin(new Celda(4,4), jugador1);
		Espadachin espadachin2 = new Espadachin(new Celda(4,5), jugador1);

		jugador1.agregarPieza(espadachin1);
		jugador2.agregarPieza(espadachin2);		

		Arquero arquero = new Arquero(new Celda(4,3), jugador2);
		espadachin1.atacar(arquero);
		Assert.assertEquals(50,arquero.obtenerVida());
		
	}


	@Test
	public void test02LasPiezasSeEliminanAlNoTenerVida(){

		Juego juego = new Juego("Juan", "Luis");
		Jugador jugador1 = juego.obtenerJugador1();
		Jugador jugador2 = juego.obtenerJugador2();

		Espadachin espadachin1a = new Espadachin(new Celda(4,4), jugador1);
		Espadachin espadachin1b = new Espadachin(new Celda(5,5), jugador1);
		Espadachin espadachin1c = new Espadachin(new Celda(4,6), jugador1);
		Espadachin espadachin1d = new Espadachin(new Celda(3,5), jugador1);

		Espadachin espadachin2 = new Espadachin(new Celda(4,5), jugador2);

		jugador1.agregarPieza(espadachin1a);
		jugador1.agregarPieza(espadachin1b);
		jugador1.agregarPieza(espadachin1c);
		jugador1.agregarPieza(espadachin1d);

		jugador2.agregarPieza(espadachin2);

		Assert.assertEquals(jugador2.poblacion(),4);

		espadachin1a.atacar(espadachin2); //75
		espadachin1b.atacar(espadachin2); //50
		espadachin1c.atacar(espadachin2); //23
		espadachin1d.atacar(espadachin2); //0


		Assert.assertFalse(Mapa.obtenerInstancia().posicionOcupada(new Celda(4,5)));
		Assert.assertEquals(jugador2.poblacion(),3);
		
	}




}