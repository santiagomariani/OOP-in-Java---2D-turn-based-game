package PosicionesTest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

import Modelo.Edificio.*;
import Modelo.Unidad.*;
import Modelo.Excepciones.*;
import Modelo.Juego.*;

public class PosicionesEnRangoDelMapa {

	@Before
	public void reset(){
		Mapa.reset();
	}
	
	@Test
	public void test01CeldaEstaDentroDelRangoDelMapaEsTrue(){		
		
		int base = Mapa.obtenerInstancia().getTamanioBase();
		int altura = Mapa.obtenerInstancia().getTamanioAltura();
		
		Celda celdaInterior = new Celda(5, 5);
		Celda celdaBorde1 = new Celda(0, 0);
		Celda celdaBorde2 = new Celda(base, altura);
		
		Assert.assertTrue(Mapa.obtenerInstancia().enRango(celdaInterior));
		Assert.assertTrue(Mapa.obtenerInstancia().enRango(celdaBorde1));
		Assert.assertTrue(Mapa.obtenerInstancia().enRango(celdaBorde2));
		
	}
	
	@Test
	public void test02CeldaNoEstaDentroDelRangoDelMapaEsFalse(){		
		
		int base = Mapa.obtenerInstancia().getTamanioBase();
		int altura = Mapa.obtenerInstancia().getTamanioAltura();
		
		Celda celda1 = new Celda(-1, 0);
		Celda celda2 = new Celda(base + 1, 0);
		Celda celda3 = new Celda(0, -1);
		Celda celda4 = new Celda(0, altura + 1);
		
		Assert.assertFalse(Mapa.obtenerInstancia().enRango(celda1));
		Assert.assertFalse(Mapa.obtenerInstancia().enRango(celda2));
		Assert.assertFalse(Mapa.obtenerInstancia().enRango(celda3));
		Assert.assertFalse(Mapa.obtenerInstancia().enRango(celda4));
	}
	
	@Test
	public void test03ZonaEstaEnElInteriorDelRangoDelMapaEsTrue(){		
		
		Celda celdaInicial = new Celda(5, 5);
		Zona zona = new Zona(celdaInicial, 2, 2);
		
		Assert.assertTrue(Mapa.obtenerInstancia().enRango(zona));	
	}
	
	@Test
	public void test04ZonaEstaEnElBordeDelRangoDelMapaEsTrue(){		
		
		int base = Mapa.obtenerInstancia().getTamanioBase();
		int altura = Mapa.obtenerInstancia().getTamanioAltura();
		
		Celda celda1 = new Celda(0, 0);
		Zona zona1 = new Zona(celda1, 2, 1);
		
		Celda celda2 = new Celda(base - 1, altura - 1);
		Zona zona2 = new Zona(celda2, 1, 2);
		
		Assert.assertTrue(Mapa.obtenerInstancia().enRango(zona1));
		Assert.assertTrue(Mapa.obtenerInstancia().enRango(zona2));
	}
	
	@Test
	public void test05ZonaCompletaAfueraDelRangoDelMapaEsFalse(){		
		
		Celda celdaInicial = new Celda(-10, 0);
		Zona zona = new Zona(celdaInicial, 2, 2);		
		
		Assert.assertFalse(Mapa.obtenerInstancia().enRango(zona));
	}
	
	@Test
	public void test06ZonaConUnaSolaCeldaDentroDelRangoDelMapaEsFalse(){		
		
		Celda celdaInicial = new Celda(-1, -1);
		Zona zona = new Zona(celdaInicial, 2, 2);		
		
		Assert.assertFalse(Mapa.obtenerInstancia().enRango(zona));
	}
	
	@Test
	public void test07ZonaConAlgunaCeldaAfueraDelRangoDelMapaEsFalse(){		
		
		int base = Mapa.obtenerInstancia().getTamanioBase();
		int altura = Mapa.obtenerInstancia().getTamanioAltura();
		
		Celda celdaInicial = new Celda(base, altura);
		Zona zona = new Zona(celdaInicial, 2, 2);		
		
		Assert.assertFalse(Mapa.obtenerInstancia().enRango(zona));
	}
	
	@Test
	public void test08ZonaConSoloUnaCeldaAfueraDelRangoDelMapaEsFalse(){		
		
		int altura = Mapa.obtenerInstancia().getTamanioAltura();
		
		Celda celdaInicial = new Celda(0, 0);
		Zona zona = new Zona(celdaInicial, 1, altura + 2);		
		
		Assert.assertFalse(Mapa.obtenerInstancia().enRango(zona));
	}
}
