package EdificiosTest;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

import Modelo.Edificio.*;
import Modelo.Excepciones.*;
import Modelo.Juego.*;

public class CuartelCreaArquerosYEspadachinesTest {

	@Before
	public void reset(){
		Mapa.reset();
	}
	
	@Test
	public void test01CuartelCreaArqueroAlLadoSuyoSiEstanVaciasLasCeldas(){		
		
		Jugador jugador = new Jugador(100, "Lucas");
		Celda celda = new Celda(17, 8);
		
		int base = Cuartel.getTamanioBase();
		int altura = Cuartel.getTamanioAltura();
		Zona zona = new Zona(celda, base, altura);
		
		Cuartel cuartel = new Cuartel(celda,jugador);
		
		Mapa.obtenerInstancia().insertar(zona);
		
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(zona));
		
		// Busca las celdas posibles donde puede respawnear el Arquero
		ArrayList<Celda> posiblesCeldas = cuartel.posiblesCeldasParaCrearArquero();
		
		celda.desplazarArribaIzquierda();
		Assert.assertFalse(Mapa.obtenerInstancia().posicionOcupada(celda));
		
		// Elijo una (la primera que encontro)
		Celda posibleCelda = posiblesCeldas.get(0);
		
		cuartel.crearArquero(posibleCelda);
		
		// Es justo la celda donde se verifico que antes de crear el Arquero, la misma estaba libre
		Assert.assertTrue(celda.igualA(posibleCelda));
		
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(zona));
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(posibleCelda)); 
	}
	
	@Test
	public void test02CuartelCreaArqueroEnLaUnicaCeldaQueNoEstaOcupadaDeLasPerifericas(){		
		
		Jugador jugador = new Jugador(100, "Lucas");
		Celda celdaInicial = new Celda(0, 1);
		Celda celdaDondeIriaElArquero = new Celda(2, 1);
		
		// Celdas de la periferia
		ArrayList<Celda> celdasPeriferia = new ArrayList<Celda>();
		
		for(int i = 0 ; i < 3 ; i++){
			celdasPeriferia.add(new Celda(i, 2));
		}
		celdasPeriferia.add(new Celda(2, 0));
		
		int base = Cuartel.getTamanioBase();
		int altura = Cuartel.getTamanioAltura();
		Zona zona = new Zona(celdaInicial, base, altura);
		
		Cuartel cuartel = new Cuartel(celdaInicial,jugador);
		
		Mapa.obtenerInstancia().insertar(zona);
		// Ocupada la zona del cuartel una vez insertada
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(zona));
		
		for(Celda celda: celdasPeriferia){
			Mapa.obtenerInstancia().insertar(celda);
			// Celdas de la periferia de la zona ocupadas luego de insertarlas
			Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(celda));
		}
		
		// Desocupada la celda donde tendria que ir
		Assert.assertFalse(Mapa.obtenerInstancia().posicionOcupada(celdaDondeIriaElArquero));
		
		// Busca las celdas posibles donde puede respawnear el Arquero
		ArrayList<Celda> posiblesCeldas = cuartel.posiblesCeldasParaCrearArquero();
		
		// Elijo una (es la unica)
		Assert.assertTrue(posiblesCeldas.size() == 1);
		Celda posibleCelda = posiblesCeldas.get(0);
		
		cuartel.crearArquero(posibleCelda);
		
		// Siguen ocupadas la zona del cuartel y las celdas de la periferia
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(zona));
		for(Celda celda: celdasPeriferia){
			Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(celda));
		}
		// Ahora queda ocupada la celda donde tendria que ir el Arquero y Es la misma que se obtuvo
		Assert.assertTrue(celdaDondeIriaElArquero.igualA(posibleCelda));
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(posibleCelda));
	}
	
	@Test
	public void test03CuartelNoCreaArqueroYaQueSusCeldasPerifericasEstanOcupadas(){		
		
		Jugador jugador = new Jugador(100, "Lucas");
		Celda celdaInicial = new Celda(8, 5);
		
		// Celdas de la periferia
		ArrayList<Celda> celdasPeriferia = new ArrayList<Celda>();
		for(int i = 0 ; i < 3 ; i++){
			celdasPeriferia.add(new Celda(i, 2));
		}
		celdasPeriferia.add(new Celda(2, 0));
		celdasPeriferia.add(new Celda(2, 1));
		
		int base = Cuartel.getTamanioBase();
		int altura = Cuartel.getTamanioAltura();
		Zona zona = new Zona(celdaInicial, base, altura);
		
		Cuartel cuartel = new Cuartel(celdaInicial,jugador);
		
		Mapa.obtenerInstancia().insertar(zona);
		// Ocupada la zona del cuartel una vez insertada
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(zona));
		
		for(Celda celda: celdasPeriferia){
			Mapa.obtenerInstancia().insertar(celda);
			// Celdas de la periferia de la zona ocupadas luego de insertarlas
			Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(celda));
		}

		
		try{
			// Busca las celdas posibles donde puede respawnear el Arquero
			cuartel.posiblesCeldasParaCrearArquero();
		} catch(NoEsPosibleCrearException e){ }
		
		// Siguen ocupadas la zona del cuartel y las celdas de la periferia
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(zona));
		for(Celda celda: celdasPeriferia){
			Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(celda));
		}
	}
	
	@Test
	public void test04CuartelCreaEspadachinAlLadoSuyoSiEstanVaciasLasCeldas(){		
		
		Jugador jugador = new Jugador(100, "Lucas");
		Celda celda = new Celda(17, 8);
		
		int base = Cuartel.getTamanioBase();
		int altura = Cuartel.getTamanioAltura();
		Zona zona = new Zona(celda, base, altura);
		
		Cuartel cuartel = new Cuartel(celda,jugador);
		
		Mapa.obtenerInstancia().insertar(zona);
		
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(zona));
		
		// Busca las celdas posibles donde puede respawnear el Espadachin
		ArrayList<Celda> posiblesCeldas = cuartel.posiblesCeldasParaCrearEspadachin();
		
		celda.desplazarArribaIzquierda();
		Assert.assertFalse(Mapa.obtenerInstancia().posicionOcupada(celda));
		
		// Elijo una (la primera que encontro)
		Celda posibleCelda = posiblesCeldas.get(0);
		
		cuartel.crearEspadachin(posibleCelda);
		
		// Es justo la celda donde se verifico que antes de crear el Espadachin, la misma estaba libre

		Assert.assertTrue(celda.igualA(posibleCelda)); 							
		
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(zona));
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(posibleCelda)); 					
	}
	
	@Test
	public void test05CuartelCreaEspadachinEnLaUnicaCeldaQueNoEstaOcupadaDeLasPerifericas(){		
		
		Jugador jugador = new Jugador(100, "Lucas");
		Celda celdaInicial = new Celda(17, 8);
		Celda celdaDondeIriaElEspadachin = new Celda(16, 6);
		
		// Celdas de la periferia
		ArrayList<Celda> celdasPeriferia = new ArrayList<Celda>();
		
		for(int j = 6 ; j < 10 ; j += 3){
			for(int i = 16 ; i < 20 ; i++){
				if(i != 16 || j != 6){
					celdasPeriferia.add(new Celda(i, j));
				}
			}	
		}
		
		for(int j = 7 ; j < 9 ; j++){
			for(int i = 16 ; i < 20 ; i += 3){
				celdasPeriferia.add(new Celda(i, j));
			}
		}
		
		int base = Cuartel.getTamanioBase();
		int altura = Cuartel.getTamanioAltura();
		Zona zona = new Zona(celdaInicial, base, altura);
		
		Cuartel cuartel = new Cuartel(celdaInicial,jugador);
		
		Mapa.obtenerInstancia().insertar(zona);
		// Ocupada la zona del cuartel una vez insertada
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(zona));
		
		for(Celda celda: celdasPeriferia){
			Mapa.obtenerInstancia().insertar(celda);
			// Celdas de la periferia de la zona ocupadas luego de insertarlas
			Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(celda));
		}
		
		// Desocupada la celda donde tendria que ir
		Assert.assertFalse(Mapa.obtenerInstancia().posicionOcupada(celdaDondeIriaElEspadachin));
		
		// Busca las celdas posibles donde puede respawnear el Espadachin
		ArrayList<Celda> posiblesCeldas = cuartel.posiblesCeldasParaCrearEspadachin();
		
		// Elijo una (es la unica)
		Assert.assertTrue(posiblesCeldas.size() == 1);
		Celda posibleCelda = posiblesCeldas.get(0);
		
		cuartel.crearEspadachin(posibleCelda);
		
		// Siguen ocupadas la zona del cuartel y las celdas de la periferia
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(zona));
		for(Celda celda: celdasPeriferia){
			Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(celda));
		}
		// Ahora queda ocupada la celda donde tendria que ir el Espadachin y Es la misma que se obtuvo
		Assert.assertTrue(celdaDondeIriaElEspadachin.igualA(posibleCelda));
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(posibleCelda));
	}
	
	@Test
	public void test06CuartelNoCreaEspadachinYaQueSusCeldasPerifericasEstanOcupadas(){		
		
		Jugador jugador = new Jugador(100, "Lucas");
		Celda celdaInicial = new Celda(8, 5);
		
		// Celdas de la periferia
		ArrayList<Celda> celdasPeriferia = new ArrayList<Celda>();
		for(int j = 6 ; j < 10 ; j += 3){
			for(int i = 16 ; i < 20 ; i++){
				celdasPeriferia.add(new Celda(i, j));
			}	
		}
		
		for(int j = 7 ; j < 9 ; j++){
			for(int i = 16 ; i < 20 ; i += 3){
				celdasPeriferia.add(new Celda(i, j));
			}
		}
		
		int base = Cuartel.getTamanioBase();
		int altura = Cuartel.getTamanioAltura();
		Zona zona = new Zona(celdaInicial, base, altura);
		
		Cuartel castillo = new Cuartel(celdaInicial,jugador);
		
		Mapa.obtenerInstancia().insertar(zona);
		// Ocupada la zona del cuartel una vez insertada
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(zona));
		
		for(Celda celda: celdasPeriferia){
			Mapa.obtenerInstancia().insertar(celda);
			// Celdas de la periferia de la zona ocupadas luego de insertarlas
			Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(celda));
		}
		
		
		try{
			// Busca las celdas posibles donde puede respawnear el Espadachin
			castillo.posiblesCeldasParaCrearEspadachin();
		} catch(NoEsPosibleCrearException e){ }
		
		// Siguen ocupadas la zona del cuartel y las celdas de la periferia
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(zona));
		for(Celda celda: celdasPeriferia){
			Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(celda));
		}
	}
	
}
