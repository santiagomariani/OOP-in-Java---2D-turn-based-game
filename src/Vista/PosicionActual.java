package Vista;

import Modelo.Juego.Celda;

public class PosicionActual{
	int x ;
	int y;		
	Celda celda;

	private static PosicionActual instancia = new PosicionActual();
	
	public void actualizar(int x, int y){
		this.x = x;
		this.y = y;	
		this.celda = new Celda(x,y);		
	}	

	public static PosicionActual obtenerInstancia(){		
		return instancia;
	}

	public int getX(){
		return this.x;
	}

	public int getY(){
		return this.y;
	}

	public Celda celda(){
		return this.celda;
	}
	


}