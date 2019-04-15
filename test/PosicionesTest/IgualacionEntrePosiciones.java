package PosicionesTest;

import org.junit.Assert;
import org.junit.Test;

import Modelo.Edificio.*;
import Modelo.Unidad.*;
import Modelo.Excepciones.*;
import Modelo.Juego.*;

public class IgualacionEntrePosiciones {

	@Test
	public void test01IgualacionEntreDosCeldasIgualesEsTrue(){
		
		Celda celda1 = new Celda(5, 5);
		Celda celda2 = new Celda(5, 5);
		
		Assert.assertTrue(celda1.igualA(celda2));
	}
	
	@Test
	public void test02IgualacionEntreDosCeldasDistintasEsFalse(){
		
		Celda celda1 = new Celda(5, 5);
		Celda celda2 = new Celda(5, 6);
		
		Assert.assertFalse(celda1.igualA(celda2));
	}
	
	@Test
	public void test03IgualacionEntreZonaYCeldaYSonIgualesEsTrue(){
		
		Celda celda1 = new Celda(1, 2);
		Celda celda2 = new Celda(2, 2);
		Celda celda3 = new Celda(1, 1);
		Celda celda4 = new Celda(2, 1);
		Zona zona = new Zona(celda1, 2, 2);
		
		Assert.assertTrue(zona.igualA(celda1));
		Assert.assertTrue(zona.igualA(celda2));
		Assert.assertTrue(zona.igualA(celda3));
		Assert.assertTrue(zona.igualA(celda4));
	}
	
	@Test
	public void test04IgualacionEntreZonaYCeldaYSonDistintasEsFalse(){
		
		Zona zona = new Zona(new Celda(0, 0), 2, 2);
		Celda celda = new Celda(-1, 0);
		
		Assert.assertFalse(zona.igualA(celda));

	}
	
	@Test
	public void test05IgualacionEntreCeldaYZonaYCeldaEstaDentroDeLaZonaEsTrue(){
		
		Celda celdaInicial = new Celda(1, 2);
		Celda celdaAIgualar = new Celda(2, 2);
		
		Zona zona = new Zona(celdaInicial, 2, 2);
		
		Assert.assertTrue(celdaAIgualar.igualA(zona));
	}
	
	@Test
	public void test06IgualacionEntreCeldaYZonaYCeldaNoEstaDentroDeLaZonaEsFalse(){
		
		Celda celdaInicial = new Celda(1, 2);
		Celda celdaAIgualar = new Celda(5, 5);
		
		Zona zona = new Zona(celdaInicial, 2, 2);
		
		Assert.assertFalse(celdaAIgualar.igualA(zona));
	}
	
	@Test
	public void test07IgualacionEntreZonasIgualesEsTrue(){
		
		Celda celdaInicial = new Celda(1, 2);
		
		Zona zona1 = new Zona(celdaInicial, 2, 2);
		Zona zona2 = new Zona(celdaInicial, 2, 2);
		
		Assert.assertTrue(zona1.igualA(zona2));
	}
	
	@Test
	public void test08IgualacionEntreZonasCuandoSoloUnaCeldaEstaDentroDeLaOtraEsTrue(){
		
		Celda celdaInicial1 = new Celda(1, 3);
		Celda celdaInicial2 = new Celda(2, 4);
		
		Zona zona1 = new Zona(celdaInicial1, 2, 2);
		Zona zona2 = new Zona(celdaInicial2, 2, 2);
		
		Assert.assertTrue(zona1.igualA(zona2));
	}
	
	@Test
	public void test08IgualacionEntreZonasCuandoYNoSeIntersectanEsFalse(){
		
		Celda celdaInicial1 = new Celda(0, 0);
		Celda celdaInicial2 = new Celda(5, 5);
		
		Zona zona1 = new Zona(celdaInicial1, 2, 2);
		Zona zona2 = new Zona(celdaInicial2, 2, 2);
		
		Assert.assertFalse(zona1.igualA(zona2));
	}
}
