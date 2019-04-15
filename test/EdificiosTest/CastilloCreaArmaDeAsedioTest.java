package EdificiosTest;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

import Modelo.Edificio.*;
import Modelo.Excepciones.*;
import Modelo.Juego.*;

public class CastilloCreaArmaDeAsedioTest {

	@Before
	public void reset(){
		Mapa.reset();
	}
	
	@Test
	public void test01CastilloCreaArmaDeAsedioAlLadoSuyoSiEstanVaciasLasCeldas(){		
		
		Jugador jugador = new Jugador(100, "Lucas");
		Celda celda = new Celda(8, 5);
		
		int base = Castillo.getTamanioBase();
		int altura = Castillo.getTamanioAltura();
		Zona zona = new Zona(celda, base, altura);
		
		Castillo castillo = new Castillo(celda,jugador);
		
		Mapa.obtenerInstancia().insertar(zona);
		
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(zona));
		
		// Busca las celdas posibles donde puede respawnear el Arma de Asedio
		ArrayList<Celda> posiblesCeldas = castillo.posiblesCeldasParaCrearArmaDeAsedio();
		
		celda.desplazarArribaIzquierda();
		Assert.assertFalse(Mapa.obtenerInstancia().posicionOcupada(celda));
		
		// Elijo una (la primera que encontro)
		Celda posibleCelda = posiblesCeldas.get(0);
		jugador.aumentarOro(200);
		castillo.crearArmaDeAsedio(posibleCelda);
		
		// Es justo la celda donde se verifico que antes de crear el Arma de Asedio, la misma estaba libre
		Assert.assertTrue(celda.igualA(posibleCelda));
		
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(zona));
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(posibleCelda)); 
	}	
	
	@Test 
	public void test02CastilloCreaArmaDeAsedioEnLaUnicaCeldaQueNoEstaOcupadaDeLasPerifericas(){		
		
		Jugador jugador = new Jugador(100, "Lucas");
		Celda celdaInicial = new Celda(8, 5);
		Celda celdaDondeIriaElArmaDeAsedio = new Celda(10, 1);
		
		// Celdas de la periferia
		ArrayList<Celda> celdasPeriferia = new ArrayList<Celda>();
		for(int j = 1 ; j < 7 ; j += 5){
			for(int i = 7 ; i < 13 ; i++){
				if(i != 10 || j != 1){
					celdasPeriferia.add(new Celda(i, j));
				}
			}	
		}
		
		for(int j = 2 ; j < 6 ; j++){
			for(int i = 7 ; i < 13 ; i += 5){
				celdasPeriferia.add(new Celda(i, j));
			}
		}
		
		int base = Castillo.getTamanioBase();
		int altura = Castillo.getTamanioAltura();
		Zona zona = new Zona(celdaInicial, base, altura);
		
		Castillo castillo = new Castillo(celdaInicial,jugador);
		
		Mapa.obtenerInstancia().insertar(zona);
		// Ocupada la zona del castillo una vez insertada
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(zona));
		
		for(Celda celda: celdasPeriferia){
			Mapa.obtenerInstancia().insertar(celda);
			// Celdas de la periferia de la zona ocupadas luego de insertarlas
			Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(celda));
		}
		
		// Desocupada la celda donde tendria que ir
		Assert.assertFalse(Mapa.obtenerInstancia().posicionOcupada(celdaDondeIriaElArmaDeAsedio));
		
		// Busca las celdas posibles donde puede respawnear el Arma de Asedio
		ArrayList<Celda> posiblesCeldas = castillo.posiblesCeldasParaCrearArmaDeAsedio();
		
		// Elijo una (es la unica)
		Assert.assertTrue(posiblesCeldas.size() == 1);			
		Celda posibleCelda = posiblesCeldas.get(0);
		jugador.aumentarOro(200);
		castillo.crearArmaDeAsedio(posibleCelda);
		
		// Siguen ocupadas la zona del castillo y las celdas de la periferia
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(zona));
		for(Celda celda: celdasPeriferia){
			Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(celda));
		}
		// Ahora queda ocupada la celda donde tendria que ir el ArmaDeAsedio y Es la misma que se obtuvo
		Assert.assertTrue(celdaDondeIriaElArmaDeAsedio.igualA(posibleCelda));
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(posibleCelda));
	}
	
	
	@Test
	public void test03CastilloNoCreaArmaDeAsedioYaQueSusCeldasPerifericasEstanOcupadas(){		
		
		Jugador jugador = new Jugador(100, "Lucas");
		Celda celdaInicial = new Celda(8, 5);
		
		// Celdas de la periferia
		ArrayList<Celda> celdasPeriferia = new ArrayList<Celda>();
		for(int j = 1 ; j < 7 ; j += 5){
			for(int i = 7 ; i < 13 ; i++){
				celdasPeriferia.add(new Celda(i, j));
			}	
		}
		
		for(int j = 2 ; j < 6 ; j++){
			for(int i = 7 ; i < 13 ; i += 5){
				celdasPeriferia.add(new Celda(i, j));
			}
		}
		
		int base = Castillo.getTamanioBase();
		int altura = Castillo.getTamanioAltura();
		Zona zona = new Zona(celdaInicial, base, altura);
		
		Castillo castillo = new Castillo(celdaInicial,jugador);
		
		Mapa.obtenerInstancia().insertar(zona);
		// Ocupada la zona del castillo una vez insertada
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(zona));
		
		for(Celda celda: celdasPeriferia){
			Mapa.obtenerInstancia().insertar(celda);
			// Celdas de la periferia de la zona ocupadas luego de insertarlas
			Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(celda));
		}
		
		// Busca las celdas posibles donde puede respawnear el Arma de Asedio
		try{
			castillo.posiblesCeldasParaCrearArmaDeAsedio();
		} catch(NoEsPosibleCrearException e){ }
		
		// Siguen ocupadas la zona del castillo y las celdas de la periferia
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(zona));
		for(Celda celda: celdasPeriferia){
			Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(celda));
		}
	}
}
