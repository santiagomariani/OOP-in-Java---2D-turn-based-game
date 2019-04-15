package Modelo.Edificio;

import Modelo.Juego.*;
import Modelo.Unidad.*;
import Modelo.Excepciones.*;
import java.util.ArrayList;

public class Castillo extends Edificio implements AtacanteDeEdificios,AtacanteDeUnidades, EdificioAtacable{

	private int alcance = 3;

	public Castillo(Celda celdaInicial, Jugador jugador) {
		super(new Zona(celdaInicial, base, altura), 1000, 0,jugador, 15, 0);
	}

	static int base = 4;
	static int altura = 4;

	public static int getTamanioBase() {
		return base;
	}
	
	public static int getTamanioAltura() {
		return altura;
	}

	public ArrayList<Celda> posiblesCeldasParaCrearArmaDeAsedio(){

		ArrayList<Celda> celdasPosibles = super.posiblesCeldasParaCrearUnidad((Zona)this.posicion, base + 2, altura + 2);

		if(celdasPosibles.isEmpty()){
			throw new NoEsPosibleCrearException();
		}

		return celdasPosibles;
	}

	public void crearArmaDeAsedio(Celda unaCelda) {
		ArrayList<Celda> celdasPosibles = this.posiblesCeldasParaCrearArmaDeAsedio();
		for(Celda celda : celdasPosibles){
			if(celda.igualA(unaCelda)){				
				ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(celda, this.jugador);
				this.jugador.disminuirOro(armaDeAsedio.obtenerCosto());
				this.jugador.agregarPieza(armaDeAsedio);				
				Mapa.obtenerInstancia().insertar(celda);
				return;
			}
		}
		throw new NoEsPosibleCrearException();
		
	}

	public boolean derrumbado() {
		return (this.vida < 1);
	}


	public void atacar(){
		Jugador jugadorOponente = this.jugador.obtenerJugadorOponente();
		ArrayList<Unidad> unidadesOponente = jugadorOponente.obtenerUnidades();
		ArrayList<Edificio> edificiosOponente = jugadorOponente.obtenerEdificios();

		// Ataco unidades.
		for(Unidad unidad: unidadesOponente){
			if(this.distanciaAPiezaEsMenorIgualA(this.alcance,unidad)){
				this.atacar((UnidadAtacable)unidad);
			}
		}

		// Ataco edificios.
		for(Edificio edificio: edificiosOponente){
			if(this.distanciaAPiezaEsMenorIgualA(this.alcance,edificio)){
				this.atacar((EdificioAtacable)edificio);
			}
		}
	}

	public void atacar(UnidadAtacable unidadAtacable){
		unidadAtacable.recibirDanio(this);
	}

	public void atacar(EdificioAtacable edificioAtacable){
		edificioAtacable.recibirDanio(this);
	}

	public void recibirDanio(Arquero arquero){
		this.reducirVidaEn(10);
		this.verificarVida();
	}

	public void recibirDanio(Espadachin espadachin){
		this.reducirVidaEn(15);
		this.verificarVida();
	}

	public void recibirDanio(ArmaDeAsedio armaDeAsedio){
		this.reducirVidaEn(75);
		this.verificarVida();
	}

	public void recibirDanio(Castillo castillo){
		this.reducirVidaEn(20);
		this.verificarVida();
	}

	public void verificarVida(){
		if(this.vida < 1 ){
			throw new JuegoTerminado();
		}
	}

}
