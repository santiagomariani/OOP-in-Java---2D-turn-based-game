package PosicionesTest;

import org.junit.Assert;
import org.junit.Test;

import Modelo.Edificio.*;
import Modelo.Unidad.*;
import Modelo.Excepciones.*;
import Modelo.Juego.*;

public class InicializacionDeUnaCelda {

	@Test
	public void test01InicializarUnaCelda(){
		
		// (un x, un y)
		Celda celda1 = new Celda(0, 0);
		Celda celda2 = new Celda(0, 0);

		// Si son iguales quiere decir que se inicializa OK
		Assert.assertTrue(celda1.igualA(celda2));
		
		// Veo que con una celda distinta de False
		Celda celdaDistinta = new Celda(1, 0);
		Assert.assertFalse(celda1.igualA(celdaDistinta));
	}
}
