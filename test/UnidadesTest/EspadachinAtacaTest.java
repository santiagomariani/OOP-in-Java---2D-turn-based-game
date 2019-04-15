package UnidadesTest;

import Modelo.Edificio.*;
import Modelo.Unidad.*;
import Modelo.Excepciones.*;
import Modelo.Juego.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class EspadachinAtacaTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void reset(){
        Mapa.reset();
    }

    @Test
    public void test01EspadachinPuedeAtacarArqueroSiEstaEnSuAlcance(){
        Jugador jugador1 = new Jugador(100, "Mario");
	Jugador jugador2 = new Jugador(100, "Hernan");

        Celda celdaEspadachin = new Celda(4,4);
        Celda celdaArquero = new Celda(5,4);

        Espadachin espadachin = new Espadachin(celdaEspadachin, jugador1);
        Arquero arquero = new Arquero(celdaArquero, jugador2);

        Mapa.obtenerInstancia().insertar(celdaEspadachin);
        Mapa.obtenerInstancia().insertar(celdaArquero);

        int vidaInicial = arquero.obtenerVida();

        espadachin.atacar(arquero); // Espadachin saca 25 a otras unidades.

        Assert.assertEquals(vidaInicial-25,arquero.obtenerVida());
    }

    @Test
    public void test02EspadachinNoPuedeAtacarArqueroSiNoEstaEnSuAlcance(){
        Jugador jugador1 = new Jugador(100, "Mario");
	Jugador jugador2 = new Jugador(100, "Hernan");

        Celda celdaEspadachin = new Celda(4,4);
        Celda celdaArquero = new Celda(6,4);

        Espadachin espadachin = new Espadachin(celdaEspadachin, jugador1);
        Arquero arquero = new Arquero(celdaArquero, jugador2);

        Mapa.obtenerInstancia().insertar(celdaEspadachin);
        Mapa.obtenerInstancia().insertar(celdaArquero);

        //thrown.expect(NoEsPosibleAtacarUnidadFueraDelAlcanceException.class);
        //espadachin.atacar(arquero);
    }

    @Test
    public void test03EspadachinPuedeAtacarArmaDeAsedioSiEstaEnSuAlcance(){
        Jugador jugador1 = new Jugador(100, "Mario");
	Jugador jugador2 = new Jugador(100, "Hernan");

        Celda celdaEspadachin = new Celda(4,4);
        Celda celdaArmaDeAsedio = new Celda(5,4);

        Espadachin espadachin = new Espadachin(celdaEspadachin, jugador1);
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(celdaArmaDeAsedio, jugador2);

        Mapa.obtenerInstancia().insertar(celdaEspadachin);
        Mapa.obtenerInstancia().insertar(celdaArmaDeAsedio);

        int vidaInicial = armaDeAsedio.obtenerVida();

        espadachin.atacar(armaDeAsedio); // Espadachin saca 25 a otras unidades.

        Assert.assertEquals(vidaInicial-25,armaDeAsedio.obtenerVida());
    }

    @Test
    public void test04EspadachinNoPuedeAtacarArmaDeAsedioSiNoEstaEnSuAlcance(){
        Jugador jugador1 = new Jugador(100, "Mario");
	Jugador jugador2 = new Jugador(100, "Hernan");

        Celda celdaEspadachin = new Celda(4,4);
        Celda celdaArmaDeAsedio = new Celda(6,4);

        Espadachin espadachin = new Espadachin(celdaEspadachin, jugador1);
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(celdaArmaDeAsedio, jugador2);

        Mapa.obtenerInstancia().insertar(celdaEspadachin);
        Mapa.obtenerInstancia().insertar(celdaArmaDeAsedio);

        thrown.expect(NoEsPosibleAtacarUnidadFueraDelAlcanceException.class);
        espadachin.atacar(armaDeAsedio);
    }

    @Test
    public void test05EspadachinPuedeAtacarAldeanoSiEstaEnSuAlcance(){
        Jugador jugador1 = new Jugador(100, "Mario");
	Jugador jugador2 = new Jugador(100, "Hernan");

        Celda celdaEspadachin = new Celda(4,4);
        Celda celdaAldeano = new Celda(5,4);

        Espadachin espadachin = new Espadachin(celdaEspadachin, jugador1);
        Aldeano aldeano = new Aldeano(celdaAldeano, jugador2);

        Mapa.obtenerInstancia().insertar(celdaEspadachin);
        Mapa.obtenerInstancia().insertar(celdaAldeano);

        int vidaInicial = aldeano.obtenerVida();

        espadachin.atacar(aldeano); // Espadachin saca 25 a otras unidades.

        Assert.assertEquals(vidaInicial-25,aldeano.obtenerVida());
    }

    @Test
    public void test06EspadachinNoPuedeAtacarAldeanoSiNoEstaEnSuAlcance(){
        Jugador jugador1 = new Jugador(100, "Mario");
	Jugador jugador2 = new Jugador(100, "Hernan");

        Celda celdaEspadachin = new Celda(4,4);
        Celda celdaAldeano = new Celda(6,4);

        Espadachin espadachin = new Espadachin(celdaEspadachin, jugador1);
        Aldeano aldeano = new Aldeano(celdaAldeano, jugador2);

        Mapa.obtenerInstancia().insertar(celdaEspadachin);
        Mapa.obtenerInstancia().insertar(celdaAldeano);

        thrown.expect(NoEsPosibleAtacarUnidadFueraDelAlcanceException.class);
        espadachin.atacar(aldeano);
    }

    @Test
    public void test07EspadachinPuedeAtacarEspadachinSiEstaEnSuAlcance(){
        Jugador jugador1 = new Jugador(100, "Mario");
	Jugador jugador2 = new Jugador(100, "Hernan");

        Celda celdaEspadachin1 = new Celda(4,4);
        Celda celdaEspadachin2 = new Celda(5,4);

        Espadachin espadachin1 = new Espadachin(celdaEspadachin1, jugador1);
        Espadachin espadachin2 = new Espadachin(celdaEspadachin2, jugador2);

        Mapa.obtenerInstancia().insertar(celdaEspadachin1);
        Mapa.obtenerInstancia().insertar(celdaEspadachin2);

        int vidaInicial = espadachin2.obtenerVida();

        espadachin1.atacar(espadachin2); // Espadachin saca 25 a otras unidades.

        Assert.assertEquals(vidaInicial-25,espadachin2.obtenerVida());
    }

    @Test
    public void test08EspadachinNoPuedeAtacarEspadachinSiNoEstaEnSuAlcance(){
        Jugador jugador1 = new Jugador(100, "Mario");
	Jugador jugador2 = new Jugador(100, "Hernan");

        Celda celdaEspadachin1 = new Celda(4,4);
        Celda celdaEspadachin2 = new Celda(6,4);

        Espadachin espadachin1 = new Espadachin(celdaEspadachin1, jugador1);
        Espadachin espadachin2 = new Espadachin(celdaEspadachin2, jugador2);

        Mapa.obtenerInstancia().insertar(celdaEspadachin1);
        Mapa.obtenerInstancia().insertar(celdaEspadachin2);

        thrown.expect(NoEsPosibleAtacarUnidadFueraDelAlcanceException.class);
        espadachin1.atacar(espadachin2);
    }

    @Test
    public void test09EspadachinPuedeAtacarPlazaCentralSiEstaEnSuAlcance(){
        Jugador jugador1 = new Jugador(100, "Mario");
	Jugador jugador2 = new Jugador(100, "Hernan");

        Celda celdaEspadachin = new Celda(4,4);
        Celda celdaPlazaCentral = new Celda(5,4);

        int base = PlazaCentral.getTamanioBase();
        int altura = PlazaCentral.getTamanioAltura();
        Zona zonaPlazaCentral = new Zona(celdaPlazaCentral, base, altura);

        Espadachin espadachin = new Espadachin(celdaEspadachin, jugador1);
        PlazaCentral plazaCentral = new PlazaCentral(celdaPlazaCentral, jugador2);

        Mapa.obtenerInstancia().insertar(celdaEspadachin);
        Mapa.obtenerInstancia().insertar(zonaPlazaCentral);

        int vidaInicial = plazaCentral.obtenerVida();

        espadachin.atacar(plazaCentral); // Espadachin saca 15 a edificios.

        Assert.assertEquals(vidaInicial-15,plazaCentral.obtenerVida());
    }

    @Test
    public void test10EspadachinNoPuedeAtacarPlazaCentralSiNoEstaEnSuAlcance(){
        Jugador jugador1 = new Jugador(100, "Mario");
	Jugador jugador2 = new Jugador(100, "Hernan");

        Celda celdaEspadachin = new Celda(4,4);

        Celda celdaPlazaCentral = new Celda(6,4);

        int base = PlazaCentral.getTamanioBase();
        int altura = PlazaCentral.getTamanioAltura();
        Zona zonaPlazaCentral = new Zona(celdaPlazaCentral, base, altura);

        Espadachin espadachin = new Espadachin(celdaEspadachin, jugador1);
        PlazaCentral plazaCentral = new PlazaCentral(celdaPlazaCentral, jugador2);

        Mapa.obtenerInstancia().insertar(celdaEspadachin);
        Mapa.obtenerInstancia().insertar(zonaPlazaCentral);

        thrown.expect(NoEsPosibleAtacarEdificioFueraDelAlcanceException.class);
        espadachin.atacar(plazaCentral);
    }

    @Test
    public void test11EspadachinPuedeAtacarCuartelSiEstaEnSuAlcance(){
        Jugador jugador1 = new Jugador(100, "Mario");
	Jugador jugador2 = new Jugador(100, "Hernan");

        Celda celdaEspadachin = new Celda(4,4);
        Celda celdaCuartel = new Celda(5,4);

        int base = Cuartel.getTamanioBase();
        int altura = Cuartel.getTamanioAltura();
        Zona zonaCuartel = new Zona(celdaCuartel, base, altura);

        Espadachin espadachin = new Espadachin(celdaEspadachin, jugador1);
        Cuartel cuartel = new Cuartel(celdaCuartel, jugador2);

        Mapa.obtenerInstancia().insertar(celdaEspadachin);
        Mapa.obtenerInstancia().insertar(zonaCuartel);

        int vidaInicial = cuartel.obtenerVida();

        espadachin.atacar(cuartel); // Espadachin saca 15 a edificios.

        Assert.assertEquals(vidaInicial-15,cuartel.obtenerVida());
    }

    @Test
    public void test12EspadachinNoPuedeAtacarCuartelSiNoEstaEnSuAlcance(){
        Jugador jugador1 = new Jugador(100, "Mario");
	Jugador jugador2 = new Jugador(100, "Hernan");

        Celda celdaEspadachin = new Celda(4,4);

        Celda celdaCuartel = new Celda(6,4);

        int base = Cuartel.getTamanioBase();
        int altura = Cuartel.getTamanioAltura();
        Zona zonaCuartel = new Zona(celdaCuartel, base, altura);

        Espadachin espadachin = new Espadachin(celdaEspadachin, jugador1);
        Cuartel cuartel = new Cuartel(celdaCuartel, jugador2);

        Mapa.obtenerInstancia().insertar(celdaEspadachin);
        Mapa.obtenerInstancia().insertar(zonaCuartel);

        thrown.expect(NoEsPosibleAtacarEdificioFueraDelAlcanceException.class);
        espadachin.atacar(cuartel);
    }

    @Test
    public void test13EspadachinPuedeAtacarCastilloSiEstaEnSuAlcance(){
        Jugador jugador1 = new Jugador(100, "Mario");
	Jugador jugador2 = new Jugador(100, "Hernan");

        Celda celdaEspadachin = new Celda(4,4);
        Celda celdaCastillo = new Celda(5,4);

        int base = Castillo.getTamanioBase();
        int altura = Castillo.getTamanioAltura();
        Zona zonaCastillo = new Zona(celdaCastillo, base, altura);

        Espadachin espadachin = new Espadachin(celdaEspadachin, jugador1);
        Castillo castillo = new Castillo(celdaCastillo, jugador2);

        Mapa.obtenerInstancia().insertar(celdaEspadachin);
        Mapa.obtenerInstancia().insertar(zonaCastillo);

        int vidaInicial = castillo.obtenerVida();

        espadachin.atacar(castillo); // Espadachin saca 15 a edificios.

        Assert.assertEquals(vidaInicial-15,castillo.obtenerVida());
    }

    @Test
    public void test14EspadachinNoPuedeAtacarCastilloSiNoEstaEnSuAlcance(){
        Jugador jugador1 = new Jugador(100, "Mario");
	Jugador jugador2 = new Jugador(100, "Hernan");

        Celda celdaEspadachin = new Celda(4,4);

        Celda celdaCastillo = new Celda(6,4);

        int base = Castillo.getTamanioBase();
        int altura = Castillo.getTamanioAltura();
        Zona zonaCastillo = new Zona(celdaCastillo, base, altura);

        Espadachin espadachin = new Espadachin(celdaEspadachin, jugador1);
        Castillo castillo = new Castillo(celdaCastillo, jugador2);

        Mapa.obtenerInstancia().insertar(celdaEspadachin);
        Mapa.obtenerInstancia().insertar(zonaCastillo);

        thrown.expect(NoEsPosibleAtacarEdificioFueraDelAlcanceException.class);
        espadachin.atacar(castillo);
    }

}
