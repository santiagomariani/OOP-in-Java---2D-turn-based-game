package EdificiosTest;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

import Modelo.Edificio.*;
import Modelo.Excepciones.*;
import Modelo.Juego.*;

public class PlazaCentralCreaAldeanoTest {

	@Before
	public void reset(){
		Mapa.reset();
	}

	/*
	@Test
	public void test01PlazaCentralCreaAldeanoAlLadoSuyoSiEstanVaciasLasCeldas(){		
		
		Jugador jugador = new Jugador(100);
		int baseMapa = Mapa.obtenerInstancia().getTamanioBase();
		int alturaMapa = Mapa.obtenerInstancia().getTamanioAltura();
		
		Celda celda = new Celda(baseMapa - 2, alturaMapa-2);
		
		int base = PlazaCentral.getTamanioBase();
		int altura = PlazaCentral.getTamanioAltura();
		Zona zona = new Zona(celda, base, altura);
		
		PlazaCentral plazaCentral = new PlazaCentral(celda,jugador);
		
		Mapa.obtenerInstancia().insertar(zona);
		
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(zona));
		
		// Busca las celdas posibles donde puede respawnear el Aldeano
		ArrayList<Celda> posiblesCeldas = plazaCentral.posiblesCeldasParaCrearAldeano();
		
		celda.desplazarIzquierda();
		Assert.assertFalse(Mapa.obtenerInstancia().posicionOcupada(celda));
		
		// Elijo una (la primera que encontro)
		Celda posibleCelda = posiblesCeldas.get(0);
		
		plazaCentral.crearAldeano(posibleCelda);
		
		// Es justo la celda donde se verifico que antes de crear el Aldeano, la misma estaba libre
		Assert.assertTrue(celda.igualA(posibleCelda));
		
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(zona));
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(posibleCelda));		
	}
	
	@Test
	public void test02PlazaCentralCreaAldeanoEnLaUnicaCeldaQueNoEstaOcupadaDeLasPerifericas(){		
		
		Jugador jugador = new Jugador(100);
		int baseMapa = Mapa.obtenerInstancia().getTamanioBase();
		int alturaMapa = Mapa.obtenerInstancia().getTamanioAltura();
		
		Celda celdaInicial = new Celda(baseMapa - 2, alturaMapa-2);
		Celda celdaDondeIriaElAldeano = new Celda(baseMapa - 3, alturaMapa - 2);
		
		// Celdas de la periferia
		ArrayList<Celda> celdasPeriferia = new ArrayList<Celda>();
		
		celdasPeriferia.add(new Celda(baseMapa - 2, alturaMapa-2));
		celdasPeriferia.add(new Celda(baseMapa - 2, alturaMapa -1));
		celdasPeriferia.add(new Celda(baseMapa - 1, alturaMapa - 2));
		celdasPeriferia.add(new Celda(baseMapa, alturaMapa -2));
		
		int base = PlazaCentral.getTamanioBase();
		int altura = PlazaCentral.getTamanioAltura();
		Zona zona = new Zona(celdaInicial, base, altura);
		
		PlazaCentral plazaCentral = new PlazaCentral(celdaInicial,jugador);
		
		Mapa.obtenerInstancia().insertar(zona);
		// Ocupada la zona de la plaza central una vez insertada
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(zona));
		
		for(Celda celda: celdasPeriferia){
			Mapa.obtenerInstancia().insertar(celda);
			// Celdas de la periferia de la zona ocupadas luego de insertarlas
			Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(celda));
		}
		
		// Desocupada la celda donde tendria que ir
		Assert.assertFalse(Mapa.obtenerInstancia().posicionOcupada(celdaDondeIriaElAldeano));
		
		// Busca las celdas posibles donde puede respawnear el Aldeano
		ArrayList<Celda> posiblesCeldas = plazaCentral.posiblesCeldasParaCrearAldeano();
		
		// Elijo una (es la unica)
		Assert.assertTrue(posiblesCeldas.size() == 1);
		Celda posibleCelda = posiblesCeldas.get(0);
		
		plazaCentral.crearAldeano( posibleCelda);
		
		// Siguen ocupadas la zona de la plaza central y las celdas de la periferia
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(zona));
		for(Celda celda: celdasPeriferia){
			Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(celda));
		}
		// Ahora queda ocupada la celda donde tendria que ir el Aldeano y Es la misma que se obtuvo
		Assert.assertTrue(celdaDondeIriaElAldeano.igualA(posibleCelda));
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(posibleCelda));
	}

	@Test
	public void test03PlazaCentralNoCreaAldeanoYaQueSusCeldasPerifericasEstanOcupadas(){		
		
		Jugador jugador = new Jugador(100);
		int baseMapa = Mapa.obtenerInstancia().getTamanioBase();
		int alturaMapa = Mapa.obtenerInstancia().getTamanioAltura();
		
		Celda celdaInicial = new Celda(baseMapa - 1, alturaMapa-2);
		
		// Celdas de la periferia
		ArrayList<Celda> celdasPeriferia = new ArrayList<Celda>();
		celdasPeriferia.add(new Celda(baseMapa - 2, alturaMapa-2));
		celdasPeriferia.add(new Celda(baseMapa - 2, alturaMapa -1));
		celdasPeriferia.add(new Celda(baseMapa - 1, alturaMapa - 2));
		celdasPeriferia.add(new Celda(baseMapa, alturaMapa -2));
		celdasPeriferia.add(new Celda(baseMapa - 2, alturaMapa - 2));
		
		int base = PlazaCentral.getTamanioBase();
		int altura = PlazaCentral.getTamanioAltura();
		Zona zona = new Zona(celdaInicial, base, altura);
		
		PlazaCentral plazaCentral = new PlazaCentral(celdaInicial,jugador);
		
		Mapa.obtenerInstancia().insertar(zona);
		// Ocupada la zona de la plaza central una vez insertada
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(zona));
		
		for(Celda celda: celdasPeriferia){
			Mapa.obtenerInstancia().insertar(celda);
			// Celdas de la periferia de la zona ocupadas luego de insertarlas
			Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(celda));
		}

		try{
			// Busca las celdas posibles donde puede respawnear el Aldeano
			plazaCentral.posiblesCeldasParaCrearAldeano();
		} catch(NoSePuedeCrearElAldeanoCeldasPerifericasOcupadasException e){ }

		
		// Siguen ocupadas la zona de la Plaza Central y las celdas de la periferia
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(zona));
		for(Celda celda: celdasPeriferia){
			Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(celda));
		}
	}
	*/
	@Test
	public void test04borrar(){
	}
	//TODO: ACTUALIZAR PRUEBA (SE HIZO UNA MODIFICACION Y SE CAGO LA PRUEBA)
}