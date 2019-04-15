package UnidadesTest;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

import Modelo.Edificio.*;
import Modelo.Unidad.*;
import Modelo.Excepciones.*;
import Modelo.Juego.*;

public class AldeanoConstruyeTest {

	@Before
	public void reset(){
		Mapa.reset();
	}
	
	@Test
	public void test01AldeanoConstruyeCuartelLoConstruyeEnZonaASuLado(){		
		
		Celda celda = new Celda(15, 15);
		Jugador jugador1 = new Jugador(100, "Mario");

		Aldeano aldeano = new Aldeano(celda,jugador1);
		Assert.assertTrue(aldeano.Libre());
		
		Mapa.obtenerInstancia().insertar(celda);	
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(celda));
		
		// Retorna una zona de posibles posiciones para construir
		ArrayList<Zona> zonasPosibles = aldeano.posiblesZonasAConstruirCuartel();
		Assert.assertTrue(aldeano.Libre());
		
		Zona zonaAConstruir = zonasPosibles.get(0);
		aldeano.construirCuartelEnZona(zonaAConstruir);
		Assert.assertFalse(aldeano.Libre());

		//turno 1
		aldeano.realizarTareas();
		Assert.assertFalse(aldeano.Libre());

		//turno 2
		aldeano.realizarTareas();
		Assert.assertFalse(aldeano.Libre());

		//turno 3
		aldeano.realizarTareas();
		Assert.assertTrue(aldeano.Libre());
		
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(celda));
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(zonaAConstruir)); 
	}	

	@Test
	public void test02AldeanoConstruyePlazaCentralLoConstruyeEnZonaASuLado(){		
		
		Celda celda = new Celda(15, 15);
		Jugador jugador1 = new Jugador(100, "Mario");


		Aldeano aldeano = new Aldeano(celda,jugador1);
		Assert.assertTrue(aldeano.Libre());
		
		Mapa.obtenerInstancia().insertar(celda);	
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(celda));	
		
		
		ArrayList<Zona> zonasPosibles = aldeano.posiblesZonasAConstruirPlazaCentral();		
		Zona zonaAConstruir = zonasPosibles.get(0);

		aldeano.construirPlazaCentralEnZona(zonaAConstruir);
		Assert.assertFalse(aldeano.Libre());

		//turno 1
		aldeano.realizarTareas();
		Assert.assertFalse(aldeano.Libre());

		//turno 2
		aldeano.realizarTareas();
		Assert.assertFalse(aldeano.Libre());

		//turno 3
		aldeano.realizarTareas();
		Assert.assertTrue(aldeano.Libre());
		
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(celda));
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(zonaAConstruir));
	}
	
	@Test
	public void test03AldeanoConstruyeEnTurnoCorrecto(){		
		
		Celda celda1 = new Celda(15, 15);
		Celda celda2 = new Celda(10, 10);

		Jugador jugador1 = new Jugador(100, "Mario");
		Jugador jugador2 = new Jugador(100, "Hernan");

		Aldeano aldeano1 = new Aldeano(celda1,jugador1);
		Aldeano aldeano2 = new Aldeano(celda2,jugador2);	
		Mapa.obtenerInstancia().insertar(celda1);	
		Mapa.obtenerInstancia().insertar(celda2);	
		
		
		ArrayList<Zona> zonasPosibles = aldeano1.posiblesZonasAConstruirPlazaCentral();		
		Zona zonaAConstruir = zonasPosibles.get(0);

		aldeano1.construirPlazaCentralEnZona(zonaAConstruir);

		Assert.assertFalse(aldeano1.Libre());
		Assert.assertTrue(aldeano2.Libre());

		//turno 1 jugador 1
		aldeano1.realizarTareas();
		Assert.assertFalse(aldeano1.Libre());
		Assert.assertTrue(aldeano2.Libre());

		//turno 2 jugador 1
		aldeano1.realizarTareas();
		Assert.assertFalse(aldeano1.Libre());
		Assert.assertTrue(aldeano2.Libre());

		//turno 3 jugador 1
		aldeano1.realizarTareas();
		Assert.assertTrue(aldeano1.Libre());
		Assert.assertTrue(aldeano2.Libre());


		ArrayList<Zona> zonasPosibles2 = aldeano2.posiblesZonasAConstruirPlazaCentral();		
		Zona zonaAConstruir2 = zonasPosibles2.get(0);

		aldeano2.construirPlazaCentralEnZona(zonaAConstruir2);

		//turno 1 jugador 2
		aldeano2.realizarTareas();
		Assert.assertTrue(aldeano1.Libre());
		Assert.assertFalse(aldeano2.Libre());
		
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(celda1));
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(celda2));
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(zonaAConstruir));
	}

	
	@Test
	public void test04AldeanoConstruyeYElOroNoAumenta(){		
		
		Celda celda = new Celda(15, 15);
		Jugador jugador = new Jugador(100, "Lucas");

		Aldeano aldeano = new Aldeano(celda,jugador);
		Assert.assertTrue(aldeano.Libre());

		Mapa.obtenerInstancia().insertar(celda);		
		ArrayList<Zona> zonasPosibles = aldeano.posiblesZonasAConstruirPlazaCentral();		
		Zona zonaAConstruir = zonasPosibles.get(0);
		aldeano.construirPlazaCentralEnZona(zonaAConstruir);
		
		Assert.assertTrue(jugador.cantidadDeOro()==0);

		//turno 1
		aldeano.realizarTareas();
		Assert.assertFalse(aldeano.Libre());

		Assert.assertTrue(jugador.cantidadDeOro()==0);
		
	}
	
	@Test
	public void test05AldeanoNoConstruyeYElOroAumenta(){		
	
		Celda celda = new Celda(15, 15);
		Jugador jugador = new Jugador(100, "Martin");
		Mapa.obtenerInstancia().insertar(celda);

		Aldeano aldeano = new Aldeano(celda,jugador);
		Assert.assertTrue(aldeano.Libre());		
		
		Assert.assertTrue(jugador.cantidadDeOro()==100);

		//turno 1
		aldeano.realizarTareas();
		Assert.assertTrue(aldeano.Libre());//esta recolectando oro

		Assert.assertFalse(jugador.cantidadDeOro()==100);
		Assert.assertTrue(jugador.cantidadDeOro()==120);

		//turno 2
		aldeano.realizarTareas();
		Assert.assertTrue(jugador.cantidadDeOro()==140);


		ArrayList<Zona> zonasPosibles = aldeano.posiblesZonasAConstruirPlazaCentral();		
		Zona zonaAConstruir = zonasPosibles.get(0);
		aldeano.construirPlazaCentralEnZona(zonaAConstruir);

		//turno 3
		aldeano.realizarTareas();
		Assert.assertTrue(jugador.cantidadDeOro()==40);
		
	}
	
	@Test
	public void test06AumentaElOroLuegoDeConstruir(){		
		
		Celda celda = new Celda(15, 15);
		Jugador jugador = new Jugador(100, "Martin");
		Mapa.obtenerInstancia().insertar(celda);

		Aldeano aldeano = new Aldeano(celda,jugador);	

		ArrayList<Zona> zonasPosibles = aldeano.posiblesZonasAConstruirPlazaCentral();		
		Zona zonaAConstruir = zonasPosibles.get(0);
		aldeano.construirPlazaCentralEnZona(zonaAConstruir);			

		//turno 1
		aldeano.realizarTareas();
		Assert.assertFalse(aldeano.Libre());
		Assert.assertTrue(jugador.cantidadDeOro()==0);

		//turno 2
		aldeano.realizarTareas();
		Assert.assertFalse(aldeano.Libre());
		Assert.assertTrue(jugador.cantidadDeOro()==0);

		//turno 3
		aldeano.realizarTareas();
		Assert.assertTrue(aldeano.Libre());
		Assert.assertTrue(jugador.cantidadDeOro()==0);

		//turno 4
		aldeano.realizarTareas();		
		Assert.assertTrue(jugador.cantidadDeOro()==20);		
		
	}	

	@Test
	public void test07NoSePuedeConstruirEnCualquierZona(){		
		
		Celda celda = new Celda(15, 15);
		Jugador jugador = new Jugador(100, "Tomas");
		Mapa.obtenerInstancia().insertar(celda);

		Aldeano aldeano = new Aldeano(celda,jugador);			
		Zona zonaAConstruir = new Zona(new Celda(5,5),2,2);			
		
		try{
			aldeano.construirPlazaCentralEnZona(zonaAConstruir);			
		} catch(NoEsPosibleConstruirException e){ }			
			
		
	}	
	
	
}
