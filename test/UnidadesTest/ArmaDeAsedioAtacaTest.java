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

public class ArmaDeAsedioAtacaTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void reset(){
        Mapa.reset();
    }

    @Test
    public void test01ArmaDeAsedioPuedeAtacarPlazaCentralSiEstaEnSuAlcance(){
        Jugador jugador1 = new Jugador(100, "Lucas");
        Jugador jugador2 = new Jugador(100, "Martin");

        Celda celdaArmaDeAsedio = new Celda(4,4);
        Celda celdaPlazaCentral = new Celda(9,4);

        int base = PlazaCentral.getTamanioBase();
        int altura = PlazaCentral.getTamanioAltura();
        Zona zonaPlazaCentral = new Zona(celdaPlazaCentral, base, altura);

        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(celdaArmaDeAsedio, jugador1);
        armaDeAsedio.actualizarEstado(new ArmaDeAsedioMontada());

        PlazaCentral plazaCentral = new PlazaCentral(celdaPlazaCentral, jugador2);

        Mapa.obtenerInstancia().insertar(celdaArmaDeAsedio);
        Mapa.obtenerInstancia().insertar(zonaPlazaCentral);

        int vidaInicial = plazaCentral.obtenerVida();

        armaDeAsedio.atacar(plazaCentral); // ArmaDeAsedio saca 75 a edificios.

        Assert.assertEquals(vidaInicial-75,plazaCentral.obtenerVida());
    }

    @Test
    public void test02ArmaDeAsedioNoPuedeAtacarPlazaCentralSiNoEstaEnSuAlcance(){
        Jugador jugador1 = new Jugador(100, "Lucas");
        Jugador jugador2 = new Jugador(100, "Martin");

        Celda celdaArmaDeAsedio = new Celda(4,4);

        Celda celdaPlazaCentral = new Celda(10,4);

        int base = PlazaCentral.getTamanioBase();
        int altura = PlazaCentral.getTamanioAltura();
        Zona zonaPlazaCentral = new Zona(celdaPlazaCentral, base, altura);

        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(celdaArmaDeAsedio, jugador1);
        armaDeAsedio.actualizarEstado(new ArmaDeAsedioMontada());

        PlazaCentral plazaCentral = new PlazaCentral(celdaPlazaCentral, jugador2);

        Mapa.obtenerInstancia().insertar(celdaArmaDeAsedio);
        Mapa.obtenerInstancia().insertar(zonaPlazaCentral);

        thrown.expect(NoEsPosibleAtacarEdificioFueraDelAlcanceException.class);
        armaDeAsedio.atacar(plazaCentral);
    }

    @Test
    public void test03ArmaDeAsedioPuedeAtacarCuartelSiEstaEnSuAlcance(){
        Jugador jugador1 = new Jugador(100, "Lucas");
        Jugador jugador2 = new Jugador(100, "Martin");

        Celda celdaArmaDeAsedio = new Celda(4,4);
        Celda celdaCuartel = new Celda(9,4);

        int base = Cuartel.getTamanioBase();
        int altura = Cuartel.getTamanioAltura();
        Zona zonaCuartel = new Zona(celdaCuartel, base, altura);

        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(celdaArmaDeAsedio, jugador1);
        armaDeAsedio.actualizarEstado(new ArmaDeAsedioMontada());

        Cuartel cuartel = new Cuartel(celdaCuartel, jugador2);

        Mapa.obtenerInstancia().insertar(celdaArmaDeAsedio);
        Mapa.obtenerInstancia().insertar(zonaCuartel);

        int vidaInicial = cuartel.obtenerVida();

        armaDeAsedio.atacar(cuartel); // ArmaDeAsedio saca 75 a edificios.

        Assert.assertEquals(vidaInicial-75,cuartel.obtenerVida());
    }

    @Test
    public void test04ArmaDeAsedioNoPuedeAtacarCuartelSiNoEstaEnSuAlcance(){
        Jugador jugador1 = new Jugador(100, "Lucas");
        Jugador jugador2 = new Jugador(100, "Martin");

        Celda celdaArmaDeAsedio = new Celda(4,4);

        Celda celdaCuartel = new Celda(10,4);

        int base = Cuartel.getTamanioBase();
        int altura = Cuartel.getTamanioAltura();
        Zona zonaCuartel = new Zona(celdaCuartel, base, altura);

        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(celdaArmaDeAsedio, jugador1);
        armaDeAsedio.actualizarEstado(new ArmaDeAsedioMontada());

        Cuartel cuartel = new Cuartel(celdaCuartel, jugador2);

        Mapa.obtenerInstancia().insertar(celdaArmaDeAsedio);
        Mapa.obtenerInstancia().insertar(zonaCuartel);

        thrown.expect(NoEsPosibleAtacarEdificioFueraDelAlcanceException.class);
        armaDeAsedio.atacar(cuartel);
    }

    @Test
    public void test05ArmaDeAsedioPuedeAtacarCastilloSiEstaEnSuAlcance(){
        Jugador jugador1 = new Jugador(100, "Lucas");
        Jugador jugador2 = new Jugador(100, "Martin");

        Celda celdaArmaDeAsedio = new Celda(4,4);
        Celda celdaCastillo = new Celda(9,4);

        int base = Castillo.getTamanioBase();
        int altura = Castillo.getTamanioAltura();
        Zona zonaCastillo = new Zona(celdaCastillo, base, altura);

        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(celdaArmaDeAsedio, jugador1);
        armaDeAsedio.actualizarEstado(new ArmaDeAsedioMontada());

        Castillo castillo = new Castillo(celdaCastillo, jugador2);

        Mapa.obtenerInstancia().insertar(celdaArmaDeAsedio);
        Mapa.obtenerInstancia().insertar(zonaCastillo);

        int vidaInicial = castillo.obtenerVida();

        armaDeAsedio.atacar(castillo); // ArmaDeAsedio saca 75 a edificios.

        Assert.assertEquals(vidaInicial-75,castillo.obtenerVida());
    }

    @Test
    public void test06ArmaDeAsedioNoPuedeAtacarCastilloSiNoEstaEnSuAlcance(){
        Jugador jugador1 = new Jugador(100, "Lucas");
        Jugador jugador2 = new Jugador(100, "Martin");

        Celda celdaArmaDeAsedio = new Celda(4,4);

        Celda celdaCastillo = new Celda(10,4);

        int base = Castillo.getTamanioBase();
        int altura = Castillo.getTamanioAltura();
        Zona zonaCastillo = new Zona(celdaCastillo, base, altura);

        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(celdaArmaDeAsedio, jugador1);
        armaDeAsedio.actualizarEstado(new ArmaDeAsedioMontada());

        Castillo castillo = new Castillo(celdaCastillo, jugador2);

        Mapa.obtenerInstancia().insertar(celdaArmaDeAsedio);
        Mapa.obtenerInstancia().insertar(zonaCastillo);

        thrown.expect(NoEsPosibleAtacarEdificioFueraDelAlcanceException.class);
        armaDeAsedio.atacar(castillo);
    }

}
