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

public class ArqueroAtacaTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void reset(){
        Mapa.reset();
    }

    @Test
    public void test01ArqueroPuedeAtacarEspadachinSiEstaEnSuAlcance(){
        Jugador jugador1 = new Jugador(100, "Pedro");
        Jugador jugador2 = new Jugador(100, "Lucas");

        Celda celdaArquero = new Celda(4,4);
        Celda celdaEspadachin = new Celda(7,4);

        Arquero arquero = new Arquero(celdaArquero, jugador1);
        Espadachin espadachin = new Espadachin(celdaEspadachin, jugador2);

        Mapa.obtenerInstancia().insertar(celdaArquero);
        Mapa.obtenerInstancia().insertar(celdaEspadachin);

        int vidaInicial = espadachin.obtenerVida();

        arquero.atacar(espadachin); // Arquero saca 15 a otras unidades.

        Assert.assertEquals(vidaInicial-15,espadachin.obtenerVida());
    }

    @Test
    public void test02ArqueroNoPuedeAtacarEspadachinSiNoEstaEnSuAlcance(){
        Jugador jugador1 = new Jugador(100, "German");
        Jugador jugador2 = new Jugador(100, "Hernan");

        Celda celdaArquero = new Celda(4,4);
        Celda celdaEspadachin = new Celda(8,4);

        Arquero arquero = new Arquero(celdaArquero, jugador1);
        Espadachin espadachin = new Espadachin(celdaEspadachin, jugador2);

        Mapa.obtenerInstancia().insertar(celdaArquero);
        Mapa.obtenerInstancia().insertar(celdaEspadachin);

        thrown.expect(NoEsPosibleAtacarUnidadFueraDelAlcanceException.class);
        arquero.atacar(espadachin);
    }

    @Test
    public void test03ArqueroPuedeAtacarArmaDeAsedioSiEstaEnSuAlcance(){
        Jugador jugador1 = new Jugador(100, "Juan");
        Jugador jugador2 = new Jugador(100, "Luis");

        Celda celdaArquero = new Celda(4,4);
        Celda celdaArmaDeAsedio = new Celda(7,4);

        Arquero arquero = new Arquero(celdaArquero, jugador1);
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(celdaArmaDeAsedio, jugador2);

        Mapa.obtenerInstancia().insertar(celdaArquero);
        Mapa.obtenerInstancia().insertar(celdaArmaDeAsedio);

        int vidaInicial = armaDeAsedio.obtenerVida();

        arquero.atacar(armaDeAsedio); // Arquero saca 15 a otras unidades.

        Assert.assertEquals(vidaInicial-15,armaDeAsedio.obtenerVida());
    }

    @Test
    public void test04ArqueroNoPuedeAtacarArmaDeAsedioSiNoEstaEnSuAlcance(){
        Jugador jugador1 = new Jugador(100, "Carlos");
        Jugador jugador2 = new Jugador(100, "Facundo");

        Celda celdaArquero = new Celda(4,4);
        Celda celdaArmaDeAsedio = new Celda(8,4);

        Arquero arquero = new Arquero(celdaArquero, jugador1);
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(celdaArmaDeAsedio, jugador2);

        Mapa.obtenerInstancia().insertar(celdaArquero);
        Mapa.obtenerInstancia().insertar(celdaArmaDeAsedio);

        thrown.expect(NoEsPosibleAtacarUnidadFueraDelAlcanceException.class);
        arquero.atacar(armaDeAsedio);
    }

    @Test
    public void test05ArqueroPuedeAtacarAldeanoSiEstaEnSuAlcance(){
        Jugador jugador1 = new Jugador(100, "Leandro");
        Jugador jugador2 = new Jugador(100, "Sebastian");

        Celda celdaArquero = new Celda(4,4);
        Celda celdaAldeano = new Celda(7,4);

        Arquero arquero = new Arquero(celdaArquero, jugador1);
        Aldeano aldeano = new Aldeano(celdaAldeano, jugador2);

        Mapa.obtenerInstancia().insertar(celdaArquero);
        Mapa.obtenerInstancia().insertar(celdaAldeano);

        int vidaInicial = aldeano.obtenerVida();

        arquero.atacar(aldeano); // Arquero saca 15 a otras unidades.

        Assert.assertEquals(vidaInicial-15,aldeano.obtenerVida());
    }

    @Test
    public void test06ArqueroNoPuedeAtacarAldeanoSiNoEstaEnSuAlcance(){
        Jugador jugador1 = new Jugador(100, "Lucas");
        Jugador jugador2 = new Jugador(100, "Martin");

        Celda celdaArquero = new Celda(4,4);
        Celda celdaAldeano = new Celda(8,4);

        Arquero arquero = new Arquero(celdaArquero, jugador1);
        Aldeano aldeano = new Aldeano(celdaAldeano, jugador2);

        Mapa.obtenerInstancia().insertar(celdaArquero);
        Mapa.obtenerInstancia().insertar(celdaAldeano);

        thrown.expect(NoEsPosibleAtacarUnidadFueraDelAlcanceException.class);
        arquero.atacar(aldeano);
    }

    @Test
    public void test07ArqueroPuedeAtacarArqueroSiEstaEnSuAlcance(){
        Jugador jugador1 = new Jugador(100, "Lucas");
        Jugador jugador2 = new Jugador(100, "Martin");

        Celda celdaArquero1 = new Celda(4,4);
        Celda celdaArquero2 = new Celda(7,4);

        Arquero arquero1 = new Arquero(celdaArquero1, jugador1);
        Arquero arquero2 = new Arquero(celdaArquero2, jugador2);

        Mapa.obtenerInstancia().insertar(celdaArquero1);
        Mapa.obtenerInstancia().insertar(celdaArquero2);

        int vidaInicial = arquero2.obtenerVida();

        arquero1.atacar(arquero2); // Arquero saca 15 a otras unidades.

        Assert.assertEquals(vidaInicial-15,arquero2.obtenerVida());
    }

    @Test
    public void test08ArqueroNoPuedeAtacarArqueroSiNoEstaEnSuAlcance(){
        Jugador jugador1 = new Jugador(100, "Lucas");
        Jugador jugador2 = new Jugador(100, "Martin");

        Celda celdaArquero1 = new Celda(4,4);
        Celda celdaArquero2 = new Celda(8,4);

        Arquero arquero1 = new Arquero(celdaArquero1, jugador1);
        Arquero arquero2 = new Arquero(celdaArquero2, jugador2);

        Mapa.obtenerInstancia().insertar(celdaArquero1);
        Mapa.obtenerInstancia().insertar(celdaArquero2);

        thrown.expect(NoEsPosibleAtacarUnidadFueraDelAlcanceException.class);
        arquero1.atacar(arquero2);
    }

    @Test
    public void test09ArqueroPuedeAtacarPlazaCentralSiEstaEnSuAlcance(){
        Jugador jugador1 = new Jugador(100, "Lucas");
        Jugador jugador2 = new Jugador(100, "Martin");

        Celda celdaArquero = new Celda(4,4);
        Celda celdaPlazaCentral = new Celda(7,4);

        int base = PlazaCentral.getTamanioBase();
        int altura = PlazaCentral.getTamanioAltura();
        Zona zonaPlazaCentral = new Zona(celdaPlazaCentral, base, altura);

        Arquero arquero = new Arquero(celdaArquero, jugador1);
        PlazaCentral plazaCentral = new PlazaCentral(celdaPlazaCentral, jugador2);

        Mapa.obtenerInstancia().insertar(celdaArquero);
        Mapa.obtenerInstancia().insertar(zonaPlazaCentral);

        int vidaInicial = plazaCentral.obtenerVida();

        arquero.atacar(plazaCentral); // Arquero saca 10 a edificios.

        Assert.assertEquals(vidaInicial-10,plazaCentral.obtenerVida());
    }

    @Test
    public void test10ArqueroNoPuedeAtacarPlazaCentralSiNoEstaEnSuAlcance(){
        Jugador jugador1 = new Jugador(100, "Lucas");
        Jugador jugador2 = new Jugador(100, "Martin");

        Celda celdaArquero = new Celda(4,4);

        Celda celdaPlazaCentral = new Celda(8,4);

        int base = PlazaCentral.getTamanioBase();
        int altura = PlazaCentral.getTamanioAltura();
        Zona zonaPlazaCentral = new Zona(celdaPlazaCentral, base, altura);

        Arquero arquero = new Arquero(celdaArquero, jugador1);
        PlazaCentral plazaCentral = new PlazaCentral(celdaPlazaCentral, jugador2);

        Mapa.obtenerInstancia().insertar(celdaArquero);
        Mapa.obtenerInstancia().insertar(zonaPlazaCentral);

        thrown.expect(NoEsPosibleAtacarEdificioFueraDelAlcanceException.class);
        arquero.atacar(plazaCentral);
    }

    @Test
    public void test11ArqueroPuedeAtacarCuartelSiEstaEnSuAlcance(){
        Jugador jugador1 = new Jugador(100, "Lucas");
        Jugador jugador2 = new Jugador(100, "Martin");

        Celda celdaArquero = new Celda(4,4);
        Celda celdaCuartel = new Celda(7,4);

        int base = Cuartel.getTamanioBase();
        int altura = Cuartel.getTamanioAltura();
        Zona zonaCuartel = new Zona(celdaCuartel, base, altura);

        Arquero arquero = new Arquero(celdaArquero, jugador1);
        Cuartel cuartel = new Cuartel(celdaCuartel, jugador2);

        Mapa.obtenerInstancia().insertar(celdaArquero);
        Mapa.obtenerInstancia().insertar(zonaCuartel);

        int vidaInicial = cuartel.obtenerVida();

        arquero.atacar(cuartel); // Arquero saca 10 a edificios.

        Assert.assertEquals(vidaInicial-10,cuartel.obtenerVida());
    }

    @Test
    public void test12ArqueroNoPuedeAtacarCuartelSiNoEstaEnSuAlcance(){
        Jugador jugador1 = new Jugador(100, "Lucas");
        Jugador jugador2 = new Jugador(100, "Martin");

        Celda celdaArquero = new Celda(4,4);

        Celda celdaCuartel = new Celda(8,4);

        int base = Cuartel.getTamanioBase();
        int altura = Cuartel.getTamanioAltura();
        Zona zonaCuartel = new Zona(celdaCuartel, base, altura);

        Arquero arquero = new Arquero(celdaArquero, jugador1);
        Cuartel cuartel = new Cuartel(celdaCuartel, jugador2);

        Mapa.obtenerInstancia().insertar(celdaArquero);
        Mapa.obtenerInstancia().insertar(zonaCuartel);

        thrown.expect(NoEsPosibleAtacarEdificioFueraDelAlcanceException.class);
        arquero.atacar(cuartel);
    }

    @Test
    public void test13ArqueroPuedeAtacarCastilloSiEstaEnSuAlcance(){
        Jugador jugador1 = new Jugador(100, "Lucas");
        Jugador jugador2 = new Jugador(100, "Martin");

        Celda celdaArquero = new Celda(4,4);
        Celda celdaCastillo = new Celda(7,4);

        int base = Castillo.getTamanioBase();
        int altura = Castillo.getTamanioAltura();
        Zona zonaCastillo = new Zona(celdaCastillo, base, altura);

        Arquero arquero = new Arquero(celdaArquero, jugador1);
        Castillo castillo = new Castillo(celdaCastillo, jugador2);

        Mapa.obtenerInstancia().insertar(celdaArquero);
        Mapa.obtenerInstancia().insertar(zonaCastillo);

        int vidaInicial = castillo.obtenerVida();

        arquero.atacar(castillo); // Arquero saca 10 a edificios.

        Assert.assertEquals(vidaInicial-10,castillo.obtenerVida());
    }

    @Test
    public void test14ArqueroNoPuedeAtacarCastilloSiNoEstaEnSuAlcance(){
        Jugador jugador1 = new Jugador(100, "Lucas");
        Jugador jugador2 = new Jugador(100, "Martin");

        Celda celdaArquero = new Celda(4,4);

        Celda celdaCastillo = new Celda(8,4);

        int base = Castillo.getTamanioBase();
        int altura = Castillo.getTamanioAltura();
        Zona zonaCastillo = new Zona(celdaCastillo, base, altura);

        Arquero arquero = new Arquero(celdaArquero, jugador1);
        Castillo castillo = new Castillo(celdaCastillo, jugador2);

        Mapa.obtenerInstancia().insertar(celdaArquero);
        Mapa.obtenerInstancia().insertar(zonaCastillo);

        thrown.expect(NoEsPosibleAtacarEdificioFueraDelAlcanceException.class);
        arquero.atacar(castillo);
    }

}
