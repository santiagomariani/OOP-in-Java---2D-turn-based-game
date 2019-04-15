package Modelo.Unidad;

import Modelo.Edificio.*;
import Modelo.Juego.*;
import Modelo.Excepciones.*;
import java.util.ArrayList;

public interface EstadoAldeano {
	
	public void repararEdificio(Edificio edificio,Aldeano aldeano);
	public void desocuparse(Aldeano aldeano);	
	public void construirCuartel(Zona zona, Aldeano aldeano);
	public void construirPlazaCentral(Zona zona, Aldeano aldeano);
	public void realizarTareas(Aldeano aldeano,Jugador jugador);
	public boolean aldeanoLibre();
}
