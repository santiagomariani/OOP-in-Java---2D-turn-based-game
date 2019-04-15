package Controladores;

import Modelo.Juego.Juego;
import Vista.ContenedorPrincipal;
import Vista.ContenedorEntrada;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.Screen;
import javafx.geometry.*;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;

public class BotonJugarEventHandler implements EventHandler<ActionEvent>{

	TextField nombreJugador1;
	TextField nombreJugador2;
	Stage stage;
	MediaPlayer mediaPlayer;

	public BotonJugarEventHandler(Stage stage, TextField nombreJugador1, TextField nombreJugador2 , MediaPlayer mediaPlayer){
		this.stage = stage;
		this.nombreJugador1 = nombreJugador1;
		this.nombreJugador2 = nombreJugador2;
		this.mediaPlayer = mediaPlayer;
	}

	@Override
	public void handle(ActionEvent event) {
		Screen screen = Screen.getPrimary();
		Rectangle2D bounds = screen.getVisualBounds();		
		Juego juego = new Juego(nombreJugador1.getText(), nombreJugador2.getText());
        HBox root = new HBox(5);
        root.setStyle("-fx-background-image: url('file:src/Vista/Recursos/background.jpg');");
        root.setAlignment(Pos.CENTER_RIGHT);
        ControladorDeTurno.getInstance().asignarJugadores(juego.obtenerJugadores());
        ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal(juego, root,(int)bounds.getHeight());
        ControladorDeTurno.getInstance().setearContenedor(contenedorPrincipal);
   		this.mediaPlayer.stop();

        Scene scene = new Scene(root, 1600, 800);
        stage.setTitle("Algo of Empires");
        

		stage.setX(bounds.getMinX());
		stage.setY(bounds.getMinY());
		stage.setWidth(bounds.getWidth());
		stage.setHeight(bounds.getHeight());       
        stage.setScene(scene);
	}


}
