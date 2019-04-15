package Modelo.Juego;

import Modelo.Edificio.*;
import Modelo.Unidad.*;
import Modelo.Excepciones.*;
import java.util.ArrayList;

public class Jugador {

	ArrayList<Aldeano> aldeanos;
	ArrayList<Edificio> edificios;
	ArrayList<Unidad> unidades;
	int cantidadDeOro;
	Castillo castillo;
	Jugador jugadorOponente;
	String nombre;


	public Jugador(int cantidadDeOro, String nombreJugador){
		this.aldeanos = new ArrayList<Aldeano>();
		this.unidades= new ArrayList<Unidad>();
		this.edificios= new ArrayList<Edificio>();
		this.cantidadDeOro = cantidadDeOro;
		this.nombre = nombreJugador;
	}

	public void setearJugadorOponente(Jugador jugadorOponente) {
		this.jugadorOponente = jugadorOponente;
	}

	public Jugador obtenerJugadorOponente(){
		return this.jugadorOponente;
	}

	public void setearCastillo(Castillo castillo){
		this.castillo = castillo;
	}

	public Castillo obtenerCastillo(){
		return this.castillo;
	}

	public Pieza obtenerPieza(Celda celda){
		for(Edificio edificio : edificios){
			if(edificio.estaEnPosicion(celda)){
				return edificio;
			}
		}
		for(Unidad unidad: unidades){
			if(unidad.estaEnPosicion(celda)){
				return unidad;
			}
		}
		if(this.castillo.estaEnPosicion(celda)){
			return this.castillo;
		}
		return null;
	}


	public void agregarPieza(Aldeano aldeano){
		if(unidades.size() == 50){
			throw new PoblacionExcedidaException();
		}
		aldeanos.add(aldeano);
		unidades.add(aldeano);

	}

	public void agregarPieza(Unidad unidad){
		if(unidades.size() == 50){
			throw new PoblacionExcedidaException();
		}
		unidades.add(unidad);
	}

	public void agregarPieza(Edificio edificio){
		edificios.add(edificio);
	}

	public void eliminarPieza(Pieza pieza){
		
		aldeanos.remove(pieza);
		unidades.remove(pieza);			
		edificios.remove(pieza);		
	}

	public void aumentarOro(int monto){
		this.cantidadDeOro += monto;
	}

	public void disminuirOro(int monto){
		if(monto <= this.cantidadDeOro){
			this.cantidadDeOro -= monto;
		}
		else{
			throw new OroInsuficienteException();
		}
	}

	public int cantidadDeOro(){
		return this.cantidadDeOro;
	}

	public int poblacion(){
		return unidades.size();
	}

	public void habilitarMovimientoUnidades(){

		for(Unidad unidad: unidades){
			unidad.habilitarMovimiento();
		}
	}

	public void habilitarAtaqueUnidades(){

		for(Unidad unidad: unidades){
			unidad.habilitarAtaque();
		}
	}

	public void realizarTareas(){
		for(Aldeano aldeano : aldeanos){
			aldeano.habilitarReparacionEdificio();
			aldeano.realizarTareas();
		}
		this.habilitarMovimientoUnidades();
		this.habilitarAtaqueUnidades();
		this.castillo.atacar();
	}

	public Edificio obtenerEdificio(Zona zona){
		for(Edificio edificio : edificios){
			if(edificio.estaEnPosicion(zona)){
				return edificio;
			}
		}
		return null;
	}

	public Unidad obtenerUnidad(Celda celda){
		for(Unidad unidad: unidades){
			if(unidad.estaEnPosicion(celda)){
				return unidad;
			}
		}
		return null;
	}

	public ArrayList<Unidad> obtenerUnidades() {
		return this.unidades;
	}

	public ArrayList<Edificio> obtenerEdificios() {
		return this.edificios;
	}

	public String getNombre(){
		return this.nombre;
	}


}