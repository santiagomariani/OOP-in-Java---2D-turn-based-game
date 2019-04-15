package Modelo.Unidad;

import Modelo.Edificio.*;
import Modelo.Juego.*;
import Modelo.Excepciones.*;

public interface EstadoArmaDeAsedio {

	public void moverArriba(ArmaDeAsedio arma);
	public void moverAbajo(ArmaDeAsedio arma);
	public void moverDerecha(ArmaDeAsedio arma);
	public void moverIzquierda(ArmaDeAsedio arma);
	public void moverArribaDerecha(ArmaDeAsedio arma);
	public void moverArribaIzquierda(ArmaDeAsedio arma);
	public void moverAbajoDerecha(ArmaDeAsedio arma);
	public void moverAbajoIzquierda(ArmaDeAsedio arma);
    public void atacar(EdificioAtacable edificioAtacable, ArmaDeAsedio armaDeAsedio, Jugador jugador, int alcance);
}
