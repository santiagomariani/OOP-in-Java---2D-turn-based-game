package UnidadesTest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

import Modelo.Edificio.*;
import Modelo.Unidad.*;
import Modelo.Excepciones.*;
import Modelo.Juego.*;

public class MovimientoYDireccionTest {

	@Before
	public void reset(){
		Mapa.reset();
	}	

	@Test
	public void test01MoverUnidadUnCasilleroHaciaArribaYCasilleroEsValidoEsTrue(){		
		
		Jugador jugador = new Jugador(100, "Juan");
		Celda celdaInicial = new Celda(0, 0);
		Arquero unidad = new Arquero(celdaInicial,jugador);
		
		Mapa.obtenerInstancia().insertar(celdaInicial);
		
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(celdaInicial));
		
		unidad.moverArriba();
		
		Celda celdaNueva = new Celda(0, 1);
		Celda celdaVieja = new Celda(0, 0);
		
		Assert.assertFalse(Mapa.obtenerInstancia().posicionOcupada(celdaVieja));
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(celdaNueva));
		Assert.assertTrue(unidad.estaEnPosicion(celdaNueva));
	}
	
	@Test
	public void test02MoverUnidadUnCasilleroHaciaAbajoYCasilleroEsValidoEsTrue(){		
		
		Jugador jugador = new Jugador(100, "Juan");
		Celda celdaInicial = new Celda(0, 1);
		Aldeano unidad = new Aldeano(celdaInicial,jugador);
		
		Mapa.obtenerInstancia().insertar(celdaInicial);
		
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(celdaInicial));
		
		unidad.moverAbajo();
		
		Celda celdaNueva = new Celda(0, 0);
		Celda celdaVieja = new Celda(0, 1);
		
		Assert.assertFalse(Mapa.obtenerInstancia().posicionOcupada(celdaVieja));
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(celdaNueva));
		Assert.assertTrue(unidad.estaEnPosicion(celdaNueva));
		
	}
	
	@Test
	public void test03MoverUnidadUnCasilleroHaciaLaDerechaYCasilleroEsValidoEsTrue(){		
		
		Jugador jugador = new Jugador(100, "Juan");
		Celda celdaInicial = new Celda(0, 0);
		Aldeano unidad = new Aldeano(celdaInicial,jugador);
		
		Mapa.obtenerInstancia().insertar(celdaInicial);
		
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(celdaInicial));
		
		unidad.moverDerecha();
		
		Celda celdaNueva = new Celda(1, 0);
		Celda celdaVieja = new Celda(0, 0);
		
		Assert.assertFalse(Mapa.obtenerInstancia().posicionOcupada(celdaVieja));
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(celdaNueva));
		Assert.assertTrue(unidad.estaEnPosicion(celdaNueva));
	}
	
	@Test
	public void test04MoverUnidadUnCasilleroHaciaArribaYCasilleroEsValidoEsTrue(){		
	
		Jugador jugador = new Jugador(100, "Juan");
		Celda celdaInicial = new Celda(1, 0);
		Aldeano unidad = new Aldeano(celdaInicial,jugador);
		
		Mapa.obtenerInstancia().insertar(celdaInicial);
		
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(celdaInicial));
		
		unidad.moverIzquierda();
		
		Celda celdaNueva = new Celda(0, 0);
		Celda celdaVieja = new Celda(1, 0);
		
		Assert.assertFalse(Mapa.obtenerInstancia().posicionOcupada(celdaVieja));
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(celdaNueva));
		Assert.assertTrue(unidad.estaEnPosicion(celdaNueva));
	}
	
	@Test
	public void test05MoverUnidadUnCasilleroHaciaArribaIzquierdaYCasilleroEsValidoEsTrue(){		
		
		Jugador jugador = new Jugador(100, "Juan");
		Celda celdaInicial = new Celda(1, 0);
		Aldeano unidad = new Aldeano(celdaInicial,jugador);
		
		Mapa.obtenerInstancia().insertar(celdaInicial);
		
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(celdaInicial));
		
		unidad.moverArribaIzquierda();
		
		Celda celdaNueva = new Celda(0, 1);
		Celda celdaVieja = new Celda(1, 0);
		
		Assert.assertFalse(Mapa.obtenerInstancia().posicionOcupada(celdaVieja));
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(celdaNueva));
		Assert.assertTrue(unidad.estaEnPosicion(celdaNueva));
	}
	
	@Test
	public void test06MoverUnidadUnCasilleroHaciaArribaDerechaYCasilleroEsValidoEsTrue(){		
		
		Jugador jugador = new Jugador(100, "Juan");
		Celda celdaInicial = new Celda(0, 0);
		Aldeano unidad = new Aldeano(celdaInicial,jugador);
		
		Mapa.obtenerInstancia().insertar(celdaInicial);
		
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(celdaInicial));
		
		unidad.moverArribaDerecha();
		
		Celda celdaNueva = new Celda(1, 1);
		Celda celdaVieja = new Celda(0, 0);
		
		Assert.assertFalse(Mapa.obtenerInstancia().posicionOcupada(celdaVieja));
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(celdaNueva));
		Assert.assertTrue(unidad.estaEnPosicion(celdaNueva));
	}
	
	@Test
	public void test07MoverUnidadUnCasilleroHaciaAbajoIzquierdaYCasilleroEsValidoEsTrue(){		
		
		Jugador jugador = new Jugador(100, "Juan");
		Celda celdaInicial = new Celda(1, 1);
		Aldeano unidad = new Aldeano(celdaInicial,jugador);
		
		Mapa.obtenerInstancia().insertar(celdaInicial);
		
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(celdaInicial));
		
		unidad.moverAbajoIzquierda();
		
		Celda celdaNueva = new Celda(0, 0);
		Celda celdaVieja = new Celda(1, 1);
		
		Assert.assertFalse(Mapa.obtenerInstancia().posicionOcupada(celdaVieja));
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(celdaNueva));
		Assert.assertTrue(unidad.estaEnPosicion(celdaNueva));
	}
	
	@Test
	public void test08MoverUnidadUnCasilleroHaciaAbajoDerechaYCasilleroEsValidoEsTrue(){		
		
		Jugador jugador = new Jugador(100, "Juan");
		Celda celdaInicial = new Celda(0, 1);
		Aldeano unidad = new Aldeano(celdaInicial,jugador);
		
		Mapa.obtenerInstancia().insertar(celdaInicial);
		
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(celdaInicial));
		
		unidad.moverAbajoDerecha();
		
		Celda celdaNueva = new Celda(1, 0);
		Celda celdaVieja = new Celda(0, 1);
		
		Assert.assertFalse(Mapa.obtenerInstancia().posicionOcupada(celdaVieja));
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(celdaNueva));
		Assert.assertTrue(unidad.estaEnPosicion(celdaNueva));
	}
	
	@Test
	public void test09MoverUnidadUnCasilleroHaciaArribaYCasilleroEstaOcupadoEsFalse(){		
		
		Jugador jugador = new Jugador(100, "Juan");
		Celda celdaInicial = new Celda(0, 0);
		Celda celdaOcupar = new Celda(0, 1);
		Aldeano unidad = new Aldeano(celdaInicial,jugador);
		
		Mapa.obtenerInstancia().insertar(celdaOcupar);
		Mapa.obtenerInstancia().insertar(celdaInicial);
		
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(celdaOcupar));
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(celdaInicial));
		
		try{
			unidad.moverArriba();
		} catch (CeldaOcupadaException e) { }
		
		Celda celdaNueva = new Celda(0, 1);
		Celda celdaVieja = new Celda(0, 0);
		
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(celdaVieja));
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(celdaNueva));
		Assert.assertTrue(unidad.estaEnPosicion(celdaVieja));
	}
	
	@Test
	public void test10MoverUnidadUnCasilleroHaciaArribaYCasilleroEsInvalidoEsFalse(){		
		
		Jugador jugador = new Jugador(100, "Juan");
		int altura = Mapa.obtenerInstancia().getTamanioAltura();
		Celda celdaInicial = new Celda(0, altura-1);
		Aldeano unidad = new Aldeano(celdaInicial,jugador);
		
		Mapa.obtenerInstancia().insertar(celdaInicial);
	
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(celdaInicial));
		
		try{
			unidad.moverArriba();
		} catch (CeldaInvalidaException e) { }
		
		Celda celdaVieja = new Celda(0, altura-1);
		
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(celdaVieja));
		Assert.assertTrue(unidad.estaEnPosicion(celdaVieja));
	}
	
	@Test
	public void test11MoverUnidadUnCasilleroHaciaAbajoYCasilleroEstaOcupadoEsFalse(){		
		
		Jugador jugador = new Jugador(100, "Juan");
		Celda celdaInicial = new Celda(0, 1);
		Celda celdaOcupar = new Celda(0, 0);
		Aldeano unidad = new Aldeano(celdaInicial,jugador);
		
		Mapa.obtenerInstancia().insertar(celdaOcupar);
		Mapa.obtenerInstancia().insertar(celdaInicial);
		
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(celdaOcupar));
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(celdaInicial));
		
		try{
			unidad.moverAbajo();
		} catch (CeldaOcupadaException e) { }
		
		Celda celdaNueva = new Celda(0, 0);
		Celda celdaVieja = new Celda(0, 1);
		
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(celdaVieja));
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(celdaNueva));
		Assert.assertTrue(unidad.estaEnPosicion(celdaVieja));
	}
	
	@Test
	public void test12MoverUnidadUnCasilleroHaciaAbajoYCasilleroEsInvalidoEsFalse(){		
	
		Jugador jugador = new Jugador(100, "Juan");
		Celda celdaInicial = new Celda(0, 0);
		Aldeano unidad = new Aldeano(celdaInicial,jugador);
		
		Mapa.obtenerInstancia().insertar(celdaInicial);
	
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(celdaInicial));
		
		try{
			unidad.moverAbajo();
		} catch (CeldaInvalidaException e) { }
		
		Celda celdaVieja = new Celda(0, 0);
		
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(celdaVieja));
		Assert.assertTrue(unidad.estaEnPosicion(celdaVieja));
	}
	
	@Test
	public void test13MoverUnidadUnCasilleroHaciaLaDerechaYCasilleroEstaOcupadoEsFalse(){		
		
		Jugador jugador = new Jugador(100, "Juan");
		Celda celdaInicial = new Celda(0, 0);
		Celda celdaOcupar = new Celda(1, 0);
		Aldeano unidad = new Aldeano(celdaInicial,jugador);
		
		Mapa.obtenerInstancia().insertar(celdaOcupar);
		Mapa.obtenerInstancia().insertar(celdaInicial);
		
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(celdaOcupar));
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(celdaInicial));
		
		try{
			unidad.moverDerecha();
		} catch (CeldaOcupadaException e) { }
		
		Celda celdaNueva = new Celda(1, 0);
		Celda celdaVieja = new Celda(0, 0);
		
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(celdaVieja));
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(celdaNueva));
		Assert.assertTrue(unidad.estaEnPosicion(celdaVieja));
	}
	
	@Test
	public void test14MoverUnidadUnCasilleroHaciaLaDerechaYCasilleroEsInvalidoEsFalse(){		
		
		Jugador jugador = new Jugador(100, "Juan");
		int base = Mapa.obtenerInstancia().getTamanioBase();
		Celda celdaInicial = new Celda(base-1, 0);
		Aldeano unidad = new Aldeano(celdaInicial,jugador);
		
		Mapa.obtenerInstancia().insertar(celdaInicial);
	
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(celdaInicial));
		
		try{
			unidad.moverDerecha();
		} catch (CeldaInvalidaException e) { }
		
		Celda celdaVieja = new Celda(base-1, 0);
		
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(celdaVieja));
		Assert.assertTrue(unidad.estaEnPosicion(celdaVieja));
	}
	
	@Test
	public void test15MoverUnidadUnCasilleroHaciaLaIzquierdaYCasilleroEstaOcupadoEsFalse(){		
		
		Jugador jugador = new Jugador(100, "Juan");
		Celda celdaInicial = new Celda(1, 0);
		Celda celdaOcupar = new Celda(0, 0);
		Aldeano unidad = new Aldeano(celdaInicial,jugador);
		
		Mapa.obtenerInstancia().insertar(celdaOcupar);
		Mapa.obtenerInstancia().insertar(celdaInicial);
		
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(celdaOcupar));
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(celdaInicial));
		
		try{
			unidad.moverIzquierda();
		} catch (CeldaOcupadaException e) { }
		
		Celda celdaNueva = new Celda(0, 0);
		Celda celdaVieja = new Celda(1, 0);
		
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(celdaVieja));
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(celdaNueva));
		Assert.assertTrue(unidad.estaEnPosicion(celdaVieja));
	}
	
	@Test
	public void test16MoverUnidadUnCasilleroHaciaLaIzquierdaYCasilleroEsInvalidoEsFalse(){		
		
		Jugador jugador = new Jugador(100, "Juan");
		Celda celdaInicial = new Celda(0, 0);
		Aldeano unidad = new Aldeano(celdaInicial,jugador);
		
		Mapa.obtenerInstancia().insertar(celdaInicial);
	
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(celdaInicial));
		
		try{
			unidad.moverIzquierda();
		} catch (CeldaInvalidaException e) { }
		
		Celda celdaVieja = new Celda(0, 0);
		
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(celdaVieja));
		Assert.assertTrue(unidad.estaEnPosicion(celdaVieja));
	}
	
	@Test
	public void test17MoverUnidadUnCasilleroHaciaArribaDerechaYCasilleroEstaOcupadoEsFalse(){		
		
		Jugador jugador = new Jugador(100, "Juan");
		Celda celdaInicial = new Celda(0, 0);
		Celda celdaOcupar = new Celda(1, 1);
		Aldeano unidad = new Aldeano(celdaInicial,jugador);
		
		Mapa.obtenerInstancia().insertar(celdaOcupar);
		Mapa.obtenerInstancia().insertar(celdaInicial);
		
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(celdaOcupar));
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(celdaInicial));
		
		try{
			unidad.moverArribaDerecha();
		} catch (CeldaOcupadaException e) { }
		
		Celda celdaNueva = new Celda(1, 1);
		Celda celdaVieja = new Celda(0, 0);
		
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(celdaVieja));
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(celdaNueva));
		Assert.assertTrue(unidad.estaEnPosicion(celdaVieja));
	}
	
	@Test
	public void test18MoverUnidadUnCasilleroHaciaArribaDerechaYCasilleroEsInvalidoEsFalse(){		
		
		Jugador jugador = new Jugador(100, "Juan");
		int altura = Mapa.obtenerInstancia().getTamanioAltura();
		Celda celdaInicial = new Celda(0, altura-1);
		Aldeano unidad = new Aldeano(celdaInicial,jugador);
		
		Mapa.obtenerInstancia().insertar(celdaInicial);
	
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(celdaInicial));
		
		try{
			unidad.moverArribaDerecha();
		} catch (CeldaInvalidaException e) { }
		
		Celda celdaVieja = new Celda(0, altura-1);
		
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(celdaVieja));
		Assert.assertTrue(unidad.estaEnPosicion(celdaVieja));
	}
	
	@Test
	public void test19MoverUnidadUnCasilleroHaciaArribaIzquierdaYCasilleroEstaOcupadoEsFalse(){		
		
		Jugador jugador = new Jugador(100, "Juan");
		Celda celdaInicial = new Celda(1, 0);
		Celda celdaOcupar = new Celda(0, 1);
		Arquero unidad = new Arquero(celdaInicial,jugador);
		
		Mapa.obtenerInstancia().insertar(celdaOcupar);
		Mapa.obtenerInstancia().insertar(celdaInicial);
		
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(celdaOcupar));
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(celdaInicial));
		
		try{
			unidad.moverArribaIzquierda();
		} catch (CeldaOcupadaException e) { }
		
		Celda celdaNueva = new Celda(0, 1);
		Celda celdaVieja = new Celda(1, 0);
		
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(celdaVieja));
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(celdaNueva));
		Assert.assertTrue(unidad.estaEnPosicion(celdaVieja));
	}
	
	@Test
	public void test20MoverUnidadUnCasilleroHaciaArribaIzquierdaYCasilleroEsInvalidoEsFalse(){		
		
		Jugador jugador = new Jugador(100, "Juan");
		int altura = Mapa.obtenerInstancia().getTamanioAltura();
		Celda celdaInicial = new Celda(0, altura-1);
		Arquero unidad = new Arquero(celdaInicial,jugador);
		
		Mapa.obtenerInstancia().insertar(celdaInicial);
	
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(celdaInicial));
		
		try{
			unidad.moverArriba();
		} catch (CeldaInvalidaException e) { }
		
		Celda celdaVieja = new Celda(0, altura-1);
		
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(celdaVieja));
		Assert.assertTrue(unidad.estaEnPosicion(celdaVieja));
	}
	
	@Test
	public void test21MoverUnidadUnCasilleroHaciaAbajoDerechaYCasilleroEstaOcupadoEsFalse(){		
		
		Jugador jugador = new Jugador(100, "Juan");
		Celda celdaInicial = new Celda(0, 1);
		Celda celdaOcupar = new Celda(1, 0);
		Arquero unidad = new Arquero(celdaInicial,jugador);
		
		Mapa.obtenerInstancia().insertar(celdaOcupar);
		Mapa.obtenerInstancia().insertar(celdaInicial);
		
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(celdaOcupar));
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(celdaInicial));
		
		try{
			unidad.moverAbajoDerecha();
		} catch (CeldaOcupadaException e) { }
		
		Celda celdaNueva = new Celda(1, 0);
		Celda celdaVieja = new Celda(0, 1);
		
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(celdaVieja));
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(celdaNueva));
		Assert.assertTrue(unidad.estaEnPosicion(celdaVieja));
	}
	
	@Test
	public void test22MoverUnidadUnCasilleroHaciaAbajoDerechaYCasilleroEsInvalidoEsFalse(){		
		
		Jugador jugador = new Jugador(100, "Juan");
		int base = Mapa.obtenerInstancia().getTamanioAltura();
		Celda celdaInicial = new Celda(base-1, 0);
		Arquero unidad = new Arquero(celdaInicial,jugador);
		
		Mapa.obtenerInstancia().insertar(celdaInicial);
	
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(celdaInicial));
		
		try{
			unidad.moverAbajoDerecha();
		} catch (CeldaInvalidaException e) { }
		
		Celda celdaVieja = new Celda(base-1, 0);
		
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(celdaVieja));
		Assert.assertTrue(unidad.estaEnPosicion(celdaVieja));
	}
	
	@Test
	public void test23MoverUnidadUnCasilleroHaciaAbajoIzquierdaYCasilleroEstaOcupadoEsFalse(){		
		
		Jugador jugador = new Jugador(100, "Juan");
		Celda celdaInicial = new Celda(1, 1);
		Celda celdaOcupar = new Celda(0, 0);
		Arquero unidad = new Arquero(celdaInicial,jugador);
		
		Mapa.obtenerInstancia().insertar(celdaOcupar);
		Mapa.obtenerInstancia().insertar(celdaInicial);
		
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(celdaOcupar));
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(celdaInicial));
		
		try{
			unidad.moverAbajoIzquierda();
		} catch (CeldaOcupadaException e) { }
		
		Celda celdaNueva = new Celda(0, 0);
		Celda celdaVieja = new Celda(1, 1);
		
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(celdaVieja));
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(celdaNueva));
		Assert.assertTrue(unidad.estaEnPosicion(celdaVieja));
	}
	
	@Test
	public void test24MoverUnidadUnCasilleroHaciaArribaYCasilleroEsInvalidoEsFalse(){		
		
		Jugador jugador = new Jugador(100, "Juan");
		int base = Mapa.obtenerInstancia().getTamanioAltura();
		Celda celdaInicial = new Celda(base-1, 0);
		Arquero unidad = new Arquero(celdaInicial,jugador);
		
		Mapa.obtenerInstancia().insertar(celdaInicial);
	
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(celdaInicial));
		
		try{
			unidad.moverAbajoIzquierda();
		} catch (CeldaInvalidaException e) { }
		
		Celda celdaVieja = new Celda(base-1, 0);
		
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(celdaVieja));
		Assert.assertTrue(unidad.estaEnPosicion(celdaVieja));
	}
	
}
