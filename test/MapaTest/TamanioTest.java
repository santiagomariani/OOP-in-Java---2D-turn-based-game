package MapaTest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

import Modelo.Edificio.*;
import Modelo.Unidad.*;
import Modelo.Excepciones.*;
import Modelo.Juego.*;

public class TamanioTest {

		@Before
		public void reset(){
			Mapa.reset();
		}

		@Test
		public void test01TamanioDelMapa(){			
			
			Assert.assertEquals(Mapa.obtenerInstancia().getTamanioBase(), 20);
			Assert.assertEquals(Mapa.obtenerInstancia().getTamanioAltura(), 20);

		}

}
