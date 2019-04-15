package MapaTest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

import Modelo.Edificio.*;
import Modelo.Unidad.*;
import Modelo.Excepciones.*;
import Modelo.Juego.*;

public class ColocarUnidadesYEdificiosTest {

	@Before
	public void reset(){
		Mapa.reset();
	}

	@Test
	public void test01ColocarUnidadEnMapaVacioEnPosicionValida(){		
		
		Celda posicion = new Celda(5, 6);
		
		Mapa.obtenerInstancia().insertar(posicion);
		
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(posicion));
		
	}
	
	@Test
	public void test02ColocarCuartelEnMapaAnchoYVacioEnPosicionValida(){		
		
		Celda celdaInicial= new Celda(5, 6);
		Zona zona = new Zona(celdaInicial, 2, 2);
		
		Celda celda2= new Celda(6, 6);
		Celda celda3= new Celda(5, 5);
		Celda celda4= new Celda(6, 5);
		
		Mapa.obtenerInstancia().insertar(zona);
		
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(zona));
		
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(celdaInicial));
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(celda2));
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(celda3));
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(celda4));			
	}
	
	@Test
	public void test03ColocarPlazaCentralEnMapaVacioEnPosicionValida(){		
		
		Celda celdaInicial= new Celda(5, 6);
		Zona zona = new Zona(celdaInicial, 2, 2);
		
		
		Celda celda2= new Celda(6, 6);
		Celda celda3= new Celda(5, 5);
		Celda celda4= new Celda(6, 5);
		
		Mapa.obtenerInstancia().insertar(zona);
		
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(zona));
		
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(celdaInicial));
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(celda2));
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(celda3));
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(celda4));			
	}
	
	@Test
	public void test04ColocarCastilloEnMapaVacioEnPosicionValida(){		
		
		Celda celdaInicial= new Celda(0, 3);
		Zona zona = new Zona(celdaInicial, 4, 4);
		
		Mapa.obtenerInstancia().insertar(zona);
		
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(zona));
		
		for(int i = 0 ; i < 4 ; i++){
			for(int j = 0 ; j < 4 ; j++){
				Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(new Celda(i, j)));
			}
		}		
	}
	
	@Test
	public void test05ColocarUnidadEnMapaVacioEnPosicionInvalida(){		
		
		Celda celda = new Celda(-1, 0);
		
		try{
			Mapa.obtenerInstancia().insertar(celda);
		} catch(CeldaInvalidaException e) { }
		
	}
	
	@Test
	public void test06ColocarUnidadEnMapaVacioEnPosicionOcupada(){		
		
		Celda celda = new Celda(0, 0);
		Mapa.obtenerInstancia().insertar(celda);
		
		try{
			Mapa.obtenerInstancia().insertar(celda);
		} catch(CeldaOcupadaException e) { }
		
	}
	
	@Test
	public void test07ColocarEdificioEnMapaVacioConAlgunaPosicionInvalida(){		
		
		Celda celda = new Celda(-1, 0);
		Zona zona = new Zona(celda, 2, 2);
		
		try{
			Mapa.obtenerInstancia().insertar(zona);
		} catch(CeldaInvalidaException e) { }
		
	}
	
	@Test
	public void test08ColocarEdificioEnMapaConAlgunaPosicionOcupada(){		
		
		Celda celda = new Celda(3, 3);
		Zona zona = new Zona(celda, 2, 2);
		Mapa.obtenerInstancia().insertar(celda);
		
		try{
			Mapa.obtenerInstancia().insertar(zona);
		} catch(CeldaOcupadaException e) { }
		
	}
	
}
