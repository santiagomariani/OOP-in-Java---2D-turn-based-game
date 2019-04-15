package PosicionesTest;

import org.junit.Assert;
import org.junit.Test;

import Modelo.Edificio.*;
import Modelo.Unidad.*;
import Modelo.Excepciones.*;
import Modelo.Juego.*;

public class InicializacionDeUnaZona {

	@Test
	public void test01InicializarUnaZonaCuadrada(){
		
		// Tiene que ser la celda de arriba izquierda de la zona a inicializar
		Celda celdaInicial = new Celda(0, 1);
		
		// Celdas hacia la derecha que se quieren contando la inicial (cantidad mayor que 0)
		int base = 2;
		
		// Celdas hacia abajo que se quieren contando la inicial (cantidad mayor que 0)
		int altura = 2;
		
		Zona zona1 = new Zona(celdaInicial, base, altura);
		Zona zona2 = new Zona(celdaInicial, base, altura);
		
		Celda celda1 = new Celda(1, 1);
		Celda celda2 = new Celda(0, 0);
		Celda celda3 = new Celda(1, 0);
		
		Assert.assertTrue(zona1.igualA(zona2));
		
		Assert.assertTrue(zona1.igualA(celdaInicial));
		Assert.assertTrue(zona1.igualA(celda1));
		Assert.assertTrue(zona1.igualA(celda2));
		Assert.assertTrue(zona1.igualA(celda3));
	}
	
	@Test
	public void test02InicializarUnaZonaRectangular1(){
		
		// Tiene que ser la celda de arriba izquierda de la zona a inicializar
		Celda celdaInicial = new Celda(0, 4);
		
		// Celdas hacia la derecha que se quieren contando la inicial (cantidad mayor que 0)
		int base = 1;
		
		// Celdas hacia abajo que se quieren contando la inicial (cantidad mayor que 0)
		int altura = 4;
		
		Zona zona1 = new Zona(celdaInicial, base, altura);
		Zona zona2 = new Zona(celdaInicial, base, altura);
		
		Celda celda1 = new Celda(0, 1);
		Celda celda2 = new Celda(0, 2);
		Celda celda3 = new Celda(0, 3);
		
		Assert.assertTrue(zona1.igualA(zona2));
		
		Assert.assertTrue(zona1.igualA(celdaInicial));
		Assert.assertTrue(zona1.igualA(celda1));
		Assert.assertTrue(zona1.igualA(celda2));
		Assert.assertTrue(zona1.igualA(celda3));
		
		//La proxima celda no esta en la zona
		Celda celda4 = new Celda(0, 0);
		
		Assert.assertFalse(zona1.igualA(celda4));
	}
	
	@Test
	public void test03InicializarUnaZonaRectangular2(){
		
		// Tiene que ser la celda de arriba izquierda de la zona a inicializar
		Celda celdaInicial = new Celda(0, 0);
		
		// Celdas hacia la derecha que se quieren contando la inicial (cantidad mayor que 0)
		int base = 4;
		
		// Celdas hacia abajo que se quieren contando la inicial (cantidad mayor que 0)
		int altura = 1;
		
		Zona zona1 = new Zona(celdaInicial, base, altura);
		Zona zona2 = new Zona(celdaInicial, base, altura);
		
		Celda celda1 = new Celda(1, 0);
		Celda celda2 = new Celda(2, 0);
		Celda celda3 = new Celda(3, 0);
		
		Assert.assertTrue(zona1.igualA(zona2));
		
		Assert.assertTrue(zona1.igualA(celdaInicial));
		Assert.assertTrue(zona1.igualA(celda1));
		Assert.assertTrue(zona1.igualA(celda2));
		Assert.assertTrue(zona1.igualA(celda3));
		
		//La proxima celda no esta en la zona
		Celda celda4 = new Celda(4, 0);
		
		Assert.assertFalse(zona1.igualA(celda4));
	}
}
