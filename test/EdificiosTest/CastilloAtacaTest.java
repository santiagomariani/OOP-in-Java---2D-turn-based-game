package EdificiosTest;

import Modelo.Edificio.*;
import Modelo.Unidad.*;
import Modelo.Excepciones.*;
import Modelo.Juego.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class CastilloAtacaTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void reset(){
        Mapa.reset();
    }

    @Test
    public void test01CastilloPuedeAtacarEspadachinSiEstaEnSuAlcance(){
        Jugador jugador1 = new Jugador(100, "Mario");
        Jugador jugador2 = new Jugador(100, "Luis");
        jugador1.setearJugadorOponente(jugador2);
        jugador2.setearJugadorOponente(jugador1);

        Celda celdaCastillo = new Celda(7,4);
        Celda celdaEspadachin = new Celda(4,4);

        int base = Castillo.getTamanioBase();
        int altura = Castillo.getTamanioAltura();
        Zona zonaCastillo = new Zona(celdaCastillo, base, altura);

        Castillo castillo = new Castillo(celdaCastillo, jugador1);
        jugador1.agregarPieza(castillo);

        Espadachin espadachin = new Espadachin(celdaEspadachin, jugador2);
        jugador2.agregarPieza(espadachin);

        Mapa.obtenerInstancia().insertar(zonaCastillo);
        Mapa.obtenerInstancia().insertar(celdaEspadachin);

        int vidaInicial = espadachin.obtenerVida();

        castillo.atacar(); // Castillo saca 20 a unidades y edificios.

        Assert.assertEquals(vidaInicial-20,espadachin.obtenerVida());
    }

    @Test
    public void test02CastilloNoPuedeAtacarEspadachinSiNoEstaEnSuAlcance(){
        Jugador jugador1 = new Jugador(100, "Mario");
        Jugador jugador2 = new Jugador(100, "Luis");
        jugador1.setearJugadorOponente(jugador2);
        jugador2.setearJugadorOponente(jugador1);

        Celda celdaCastillo = new Celda(10,4);
        Celda celdaEspadachin = new Celda(4,4);

        int base = Castillo.getTamanioBase();
        int altura = Castillo.getTamanioAltura();
        Zona zonaCastillo = new Zona(celdaCastillo, base, altura);

        Castillo castillo = new Castillo(celdaCastillo, jugador1);
        jugador1.agregarPieza(castillo);

        Espadachin espadachin = new Espadachin(celdaEspadachin, jugador2);
        jugador2.agregarPieza(espadachin);

        Mapa.obtenerInstancia().insertar(zonaCastillo);
        Mapa.obtenerInstancia().insertar(celdaEspadachin);

        int vidaInicial = espadachin.obtenerVida();

        castillo.atacar();

        Assert.assertEquals(vidaInicial,espadachin.obtenerVida());
    }

    @Test
    public void test03CastilloPuedeAtacarArmaDeAsedioSiEstaEnSuAlcance(){
        Jugador jugador1 = new Jugador(100, "Mario");
        Jugador jugador2 = new Jugador(100, "Luis");
        jugador1.setearJugadorOponente(jugador2);
        jugador2.setearJugadorOponente(jugador1);

        Celda celdaCastillo = new Celda(7,4);
        Celda celdaArmaDeAsedio = new Celda(4,4);

        int base = Castillo.getTamanioBase();
        int altura = Castillo.getTamanioAltura();
        Zona zonaCastillo = new Zona(celdaCastillo, base, altura);

        Castillo castillo = new Castillo(celdaCastillo, jugador1);
        jugador1.agregarPieza(castillo);

        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(celdaArmaDeAsedio, jugador2);
        jugador2.agregarPieza(armaDeAsedio);

        Mapa.obtenerInstancia().insertar(zonaCastillo);
        Mapa.obtenerInstancia().insertar(celdaArmaDeAsedio);

        int vidaInicial = armaDeAsedio.obtenerVida();

        castillo.atacar(); // Castillo saca 20 a unidades y edificios.

        Assert.assertEquals(vidaInicial-20,armaDeAsedio.obtenerVida());
    }

    @Test
    public void test04CastilloNoPuedeAtacarArmaDeAsedioSiNoEstaEnSuAlcance(){
        Jugador jugador1 = new Jugador(100, "Mario");
        Jugador jugador2 = new Jugador(100, "Luis");
        jugador1.setearJugadorOponente(jugador2);
        jugador2.setearJugadorOponente(jugador1);

        Celda celdaCastillo = new Celda(10,4);
        Celda celdaArmaDeAsedio = new Celda(4,4);

        int base = Castillo.getTamanioBase();
        int altura = Castillo.getTamanioAltura();
        Zona zonaCastillo = new Zona(celdaCastillo, base, altura);

        Castillo castillo = new Castillo(celdaCastillo, jugador1);
        jugador1.agregarPieza(castillo);

        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(celdaArmaDeAsedio, jugador2);
        jugador2.agregarPieza(armaDeAsedio);

        Mapa.obtenerInstancia().insertar(zonaCastillo);
        Mapa.obtenerInstancia().insertar(celdaArmaDeAsedio);

        int vidaInicial = armaDeAsedio.obtenerVida();

        castillo.atacar();

        Assert.assertEquals(vidaInicial,armaDeAsedio.obtenerVida());
    }

    @Test
    public void test05CastilloPuedeAtacarAldeanoSiEstaEnSuAlcance(){
        Jugador jugador1 = new Jugador(100, "Mario");
        Jugador jugador2 = new Jugador(100, "Luis");
        jugador1.setearJugadorOponente(jugador2);
        jugador2.setearJugadorOponente(jugador1);

        Celda celdaCastillo = new Celda(7,4);
        Celda celdaAldeano = new Celda(4,4);

        int base = Castillo.getTamanioBase();
        int altura = Castillo.getTamanioAltura();
        Zona zonaCastillo = new Zona(celdaCastillo, base, altura);

        Castillo castillo = new Castillo(celdaCastillo, jugador1);
        jugador1.agregarPieza(castillo);

        Aldeano aldeano = new Aldeano(celdaAldeano, jugador2);
        jugador2.agregarPieza(aldeano);

        Mapa.obtenerInstancia().insertar(zonaCastillo);
        Mapa.obtenerInstancia().insertar(celdaAldeano);

        int vidaInicial = aldeano.obtenerVida();

        castillo.atacar(); // Castillo saca 20 a unidades y edificios.

        Assert.assertEquals(vidaInicial-20,aldeano.obtenerVida());
    }

    @Test
    public void test06CastilloNoPuedeAtacarAldeanoSiNoEstaEnSuAlcance(){
        Jugador jugador1 = new Jugador(100, "Mario");
        Jugador jugador2 = new Jugador(100, "Luis");
        jugador1.setearJugadorOponente(jugador2);
        jugador2.setearJugadorOponente(jugador1);

        Celda celdaCastillo = new Celda(10,4);
        Celda celdaAldeano = new Celda(4,4);

        int base = Castillo.getTamanioBase();
        int altura = Castillo.getTamanioAltura();
        Zona zonaCastillo = new Zona(celdaCastillo, base, altura);

        Castillo castillo = new Castillo(celdaCastillo, jugador1);
        jugador1.agregarPieza(castillo);

        Aldeano aldeano = new Aldeano(celdaAldeano, jugador2);
        jugador2.agregarPieza(aldeano);

        Mapa.obtenerInstancia().insertar(zonaCastillo);
        Mapa.obtenerInstancia().insertar(celdaAldeano);

        int vidaInicial = aldeano.obtenerVida();

        castillo.atacar();

        Assert.assertEquals(vidaInicial,aldeano.obtenerVida());
    }

    @Test
    public void test07CastilloPuedeAtacarCastilloSiEstaEnSuAlcance(){
        Jugador jugador1 = new Jugador(100, "Mario");
        Jugador jugador2 = new Jugador(100, "Luis");
        jugador1.setearJugadorOponente(jugador2);
        jugador2.setearJugadorOponente(jugador1);

        Celda celdaCastillo1 = new Celda(8,4);
        Celda celdaCastillo2 = new Celda(4,4);

        int base = Castillo.getTamanioBase();
        int altura = Castillo.getTamanioAltura();

        Zona zonaCastillo1 = new Zona(celdaCastillo1, base, altura);
        Zona zonaCastillo2 = new Zona(celdaCastillo2, base, altura);

        Castillo castillo1 = new Castillo(celdaCastillo1, jugador1);
        jugador1.agregarPieza(castillo1);

        Castillo castillo2 = new Castillo(celdaCastillo2, jugador2);
        jugador2.agregarPieza(castillo2);

        Mapa.obtenerInstancia().insertar(zonaCastillo1);
        Mapa.obtenerInstancia().insertar(zonaCastillo2);

        int vidaInicial = castillo2.obtenerVida();

        castillo1.atacar(); // Castillo saca 20 a unidades y edificios.

        Assert.assertEquals(vidaInicial-20,castillo2.obtenerVida());
    }

    @Test
    public void test08CastilloNoPuedeAtacarCastilloSiNoEstaEnSuAlcance(){
        Jugador jugador1 = new Jugador(100, "Mario");
        Jugador jugador2 = new Jugador(100, "Luis");
        jugador1.setearJugadorOponente(jugador2);
        jugador2.setearJugadorOponente(jugador1);

        Celda celdaCastillo1 = new Celda(13,4);
        Celda celdaCastillo2 = new Celda(4,4);

        int base = Castillo.getTamanioBase();
        int altura = Castillo.getTamanioAltura();

        Zona zonaCastillo1 = new Zona(celdaCastillo1, base, altura);
        Zona zonaCastillo2 = new Zona(celdaCastillo2, base, altura);

        Castillo castillo1 = new Castillo(celdaCastillo1, jugador1);
        jugador1.agregarPieza(castillo1);

        Castillo castillo2 = new Castillo(celdaCastillo2, jugador2);
        jugador2.agregarPieza(castillo2);

        Mapa.obtenerInstancia().insertar(zonaCastillo1);
        Mapa.obtenerInstancia().insertar(zonaCastillo2);

        int vidaInicial = castillo2.obtenerVida();

        castillo1.atacar();

        Assert.assertEquals(vidaInicial,castillo2.obtenerVida());
    }

    @Test
    public void test09CastilloPuedeAtacarPlazaCentralSiEstaEnSuAlcance(){
        Jugador jugador1 = new Jugador(100, "Mario");
        Jugador jugador2 = new Jugador(100, "Luis");
        jugador1.setearJugadorOponente(jugador2);
        jugador2.setearJugadorOponente(jugador1);

        Celda celdaCastillo = new Celda(8,4);
        Celda celdaPlazaCentral = new Celda(4,4);

        int baseCastillo = Castillo.getTamanioBase();
        int alturaCastillo = Castillo.getTamanioAltura();

        int basePlazaCentral = PlazaCentral.getTamanioBase();
        int alturaPlazaCentral = PlazaCentral.getTamanioAltura();


        Zona zonaCastillo = new Zona(celdaCastillo, baseCastillo, alturaCastillo);
        Zona zonaPlazaCentral = new Zona(celdaPlazaCentral, basePlazaCentral, alturaPlazaCentral);

        Castillo castillo = new Castillo(celdaCastillo, jugador1);
        jugador1.agregarPieza(castillo);

        PlazaCentral plazaCentral = new PlazaCentral(celdaPlazaCentral, jugador2);
        jugador2.agregarPieza(plazaCentral);

        Mapa.obtenerInstancia().insertar(zonaCastillo);
        Mapa.obtenerInstancia().insertar(zonaPlazaCentral);

        int vidaInicial = plazaCentral.obtenerVida();

        castillo.atacar(); // Castillo saca 20 a unidades y edificios.

        Assert.assertEquals(vidaInicial-20,plazaCentral.obtenerVida());
    }

    @Test
    public void test10CastilloNoPuedeAtacarPlazaCentralSiNoEstaEnSuAlcance(){
        Jugador jugador1 = new Jugador(100, "Mario");
        Jugador jugador2 = new Jugador(100, "Luis");
        jugador1.setearJugadorOponente(jugador2);
        jugador2.setearJugadorOponente(jugador1);

        Celda celdaCastillo = new Celda(11,4);
        Celda celdaPlazaCentral = new Celda(4,4);

        int baseCastillo = Castillo.getTamanioBase();
        int alturaCastillo = Castillo.getTamanioAltura();

        int basePlazaCentral = PlazaCentral.getTamanioBase();
        int alturaPlazaCentral = PlazaCentral.getTamanioAltura();


        Zona zonaCastillo = new Zona(celdaCastillo, baseCastillo, alturaCastillo);
        Zona zonaPlazaCentral = new Zona(celdaPlazaCentral, basePlazaCentral, alturaPlazaCentral);

        Castillo castillo = new Castillo(celdaCastillo, jugador1);
        jugador1.agregarPieza(castillo);

        PlazaCentral plazaCentral = new PlazaCentral(celdaPlazaCentral, jugador2);
        jugador2.agregarPieza(plazaCentral);

        Mapa.obtenerInstancia().insertar(zonaCastillo);
        Mapa.obtenerInstancia().insertar(zonaPlazaCentral);

        int vidaInicial = plazaCentral.obtenerVida();

        castillo.atacar();

        Assert.assertEquals(vidaInicial,plazaCentral.obtenerVida());
    }

    @Test
    public void test11CastilloPuedeAtacarCuartelSiEstaEnSuAlcance(){
        Jugador jugador1 = new Jugador(100, "Mario");
        Jugador jugador2 = new Jugador(100, "Luis");

        jugador1.setearJugadorOponente(jugador2);
        jugador2.setearJugadorOponente(jugador1);

        Celda celdaCastillo = new Celda(8,4);
        Celda celdaCuartel = new Celda(4,4);

        int baseCastillo = Castillo.getTamanioBase();
        int alturaCastillo = Castillo.getTamanioAltura();

        int baseCuartel = Cuartel.getTamanioBase();
        int alturaCuartel = Cuartel.getTamanioAltura();

        Zona zonaCastillo = new Zona(celdaCastillo, baseCastillo, alturaCastillo);
        Zona zonaCuartel = new Zona(celdaCuartel, baseCuartel, alturaCuartel);

        Castillo castillo = new Castillo(celdaCastillo, jugador1);
        jugador1.agregarPieza(castillo);

        Cuartel cuartel = new Cuartel(celdaCuartel, jugador2);
        jugador2.agregarPieza(cuartel);

        Mapa.obtenerInstancia().insertar(zonaCastillo);
        Mapa.obtenerInstancia().insertar(zonaCuartel);

        int vidaInicial = cuartel.obtenerVida();

        castillo.atacar(); // Castillo saca 20 a unidades y edificios.

        Assert.assertEquals(vidaInicial-20,cuartel.obtenerVida());
    }

    @Test
    public void test12CastilloNoPuedeAtacarCuartelSiNoEstaEnSuAlcance(){
        Jugador jugador1 = new Jugador(100, "Mario");
        Jugador jugador2 = new Jugador(100, "Luis");

        jugador1.setearJugadorOponente(jugador2);
        jugador2.setearJugadorOponente(jugador1);

        Celda celdaCastillo = new Celda(11,4);
        Celda celdaCuartel = new Celda(4,4);

        int baseCastillo = Castillo.getTamanioBase();
        int alturaCastillo = Castillo.getTamanioAltura();

        int baseCuartel = Cuartel.getTamanioBase();
        int alturaCuartel = Cuartel.getTamanioAltura();


        Zona zonaCastillo = new Zona(celdaCastillo, baseCastillo, alturaCastillo);
        Zona zonaCuartel = new Zona(celdaCuartel, baseCuartel, alturaCuartel);

        Castillo castillo = new Castillo(celdaCastillo, jugador1);
        jugador1.agregarPieza(castillo);

        Cuartel cuartel = new Cuartel(celdaCuartel, jugador2);
        jugador2.agregarPieza(cuartel);

        Mapa.obtenerInstancia().insertar(zonaCastillo);
        Mapa.obtenerInstancia().insertar(zonaCuartel);

        int vidaInicial = cuartel.obtenerVida();

        castillo.atacar();

        Assert.assertEquals(vidaInicial,cuartel.obtenerVida());
    }
    /*
    @Test
    public void test13CastilloAtacaVariasPiezasEnSuAlcance() {
        Juego juego = new Juego("Mario", "Lucas");

        Jugador jugador1 = juego.obtenerJugador1();
        Jugador jugador2 = juego.obtenerJugador2();

        int baseCuartel = Cuartel.getTamanioBase();
        int alturaCuartel = Cuartel.getTamanioAltura();
        Celda celdaCuartel1 = new Celda(3, 17);
        Celda celdaCuartel2 = new Celda(6, 16);
        Zona zonaCuartel1 = new Zona(celdaCuartel1,baseCuartel,alturaCuartel);
        Zona zonaCuartel2 = new Zona(celdaCuartel2,baseCuartel,alturaCuartel);

        Celda celdaEspadachin1 = new Celda(1, 17);
        Celda celdaEspadachin2 = new Celda(6, 18);

        Cuartel cuartel1 = new Cuartel(celdaCuartel1, jugador2);
        Cuartel cuartel2 = new Cuartel(celdaCuartel2, jugador2);
        Espadachin espadachin1 = new Espadachin(celdaEspadachin1, jugador2);
        Espadachin espadachin2 = new Espadachin(celdaEspadachin2, jugador2);

        jugador2.agregarPieza(cuartel1);
        jugador2.agregarPieza(cuartel2);
        jugador2.agregarPieza(espadachin1);
        jugador2.agregarPieza(espadachin2);

        Mapa.obtenerInstancia().insertar(zonaCuartel1);
        Mapa.obtenerInstancia().insertar(zonaCuartel2);
        Mapa.obtenerInstancia().insertar(celdaEspadachin1);
        Mapa.obtenerInstancia().insertar(celdaEspadachin2);

        int vidaInicialCuartel = cuartel1.obtenerVida();
        int vidaInicialEspadachin = espadachin1.obtenerVida();

        Castillo castilloJugador1 = jugador1.obtenerCastillo();
        castilloJugador1.atacar();

        Assert.assertEquals(vidaInicialCuartel-20,cuartel1.obtenerVida());
        Assert.assertEquals(vidaInicialCuartel-20,cuartel2.obtenerVida());
        Assert.assertEquals(vidaInicialEspadachin-20,espadachin1.obtenerVida());
        Assert.assertEquals(vidaInicialEspadachin-20,espadachin2.obtenerVida());
    }

    @Test
    public void test14CastilloNoAtacaVariasPiezasFueraDeSuAlcance() {
        Juego juego = new Juego("Martin", "Lucas");

        Jugador jugador1 = juego.obtenerJugador1();
        Jugador jugador2 = juego.obtenerJugador2();

        int baseCuartel = Cuartel.getTamanioBase();
        int alturaCuartel = Cuartel.getTamanioAltura();
        Celda celdaCuartel1 = new Celda(3, 15);
        Celda celdaCuartel2 = new Celda(8, 15);
        Zona zonaCuartel1 = new Zona(celdaCuartel1,baseCuartel,alturaCuartel);
        Zona zonaCuartel2 = new Zona(celdaCuartel2,baseCuartel,alturaCuartel);

        Celda celdaEspadachin1 = new Celda(1, 15);
        Celda celdaEspadachin2 = new Celda(9, 24);

        Cuartel cuartel1 = new Cuartel(celdaCuartel1, jugador2);
        Cuartel cuartel2 = new Cuartel(celdaCuartel2, jugador2);
        Espadachin espadachin1 = new Espadachin(celdaEspadachin1, jugador2);
        Espadachin espadachin2 = new Espadachin(celdaEspadachin2, jugador2);

        jugador2.agregarPieza(cuartel1);
        jugador2.agregarPieza(cuartel2);
        jugador2.agregarPieza(espadachin1);
        jugador2.agregarPieza(espadachin2);

        Mapa.obtenerInstancia().insertar(zonaCuartel1);
        Mapa.obtenerInstancia().insertar(zonaCuartel2);
        Mapa.obtenerInstancia().insertar(celdaEspadachin1);
        Mapa.obtenerInstancia().insertar(celdaEspadachin2);

        int vidaInicialCuartel = cuartel1.obtenerVida();
        int vidaInicialEspadachin = espadachin1.obtenerVida();

        Castillo castilloJugador1 = jugador1.obtenerCastillo();
        castilloJugador1.atacar();

        Assert.assertEquals(vidaInicialCuartel,cuartel1.obtenerVida());
        Assert.assertEquals(vidaInicialCuartel,cuartel2.obtenerVida());
        Assert.assertEquals(vidaInicialEspadachin,espadachin1.obtenerVida());
        Assert.assertEquals(vidaInicialEspadachin,espadachin2.obtenerVida());
    }*/
}
