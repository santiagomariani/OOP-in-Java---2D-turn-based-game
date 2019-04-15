package Vista;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.*;


public class Alerta{

	Alert alerta;

	public Alerta(){
		alerta = new Alert(Alert.AlertType.INFORMATION);
		alerta.setHeaderText(null);		
	}

	public void AldeanoOcupado(){
		this.alerta.setTitle("Accion no valida"); 
		this.alerta.setContentText("El aldeano esta ocupado.");
	    this.alerta.showAndWait(); 
	}

	public void unidadYaMovida(){
		this.alerta.setTitle("Accion no valida"); 
		this.alerta.setContentText("Esta unidad ya se movio");
	    this.alerta.showAndWait(); 
	}

	public void fueraDeRango(){
		this.alerta.setTitle("Accion no valida"); 
		this.alerta.setContentText("Posicion fuera de rango");
	    this.alerta.showAndWait(); 
	}

	public void celdaOcupada(){
		this.alerta.setTitle("Accion no valida"); 
		this.alerta.setContentText("Posicion ocupada");
	    this.alerta.showAndWait(); 
	}

	public void noSePuedeCrearAhi(){
		this.alerta.setTitle("Accion no valida"); 
		this.alerta.setContentText("No es posible crear unidad.");
	    this.alerta.showAndWait(); 
	}

	public void noSePuedeConstruirAhi(){
		this.alerta.setTitle("Accion no valida"); 
		this.alerta.setContentText("No es posible construir edificio.");
	    this.alerta.showAndWait(); 
	}

	public void oroInsuficiente(){
		this.alerta.setTitle("Accion no valida"); 
		this.alerta.setContentText("Oro insuficiente para realizar dicha accion");
	    this.alerta.showAndWait(); 
	}

	public void poblacionExcedida(){
		this.alerta.setTitle("Poblacion excedida"); 
		this.alerta.setContentText("El limite de poblacion es 50");
	    this.alerta.showAndWait(); 
	}

	public void unidadYaAtaco(){
		this.alerta.setTitle("Accion no valida"); 
		this.alerta.setContentText("Esta unidad ya ataco");
	    this.alerta.showAndWait(); 
	}

	public void juegoTerminado(){
		this.alerta.setTitle("FELICITACIONES!"); 
		this.alerta.setContentText("Ha destruido el castillo rival y ha ganado!");
	    this.alerta.showAndWait(); 
	}


    public void noEsPosibleReparar() {
		this.alerta.setTitle("Accion no valida");
		this.alerta.setContentText("No es posible reparar.");
		this.alerta.showAndWait();
	}
}