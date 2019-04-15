package Vista;

import Controladores.BotonJugarEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.*;



import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;	

public class ContenedorEntrada {

	HBox contenedorPrincipal;

	public ContenedorEntrada(Stage stage){	


		// Para poner el nombre del jugador1 y jugador2
		TextField nombreJugador1 = new TextField();
		TextField nombreJugador2 = new TextField();
		nombreJugador1.setPromptText("Ingrese el nombre del jugador");
		nombreJugador2.setPromptText("Ingrese el nombre del jugador");		
		nombreJugador1.setMinWidth(250);
		nombreJugador2.setMinWidth(250);
		nombreJugador1.setPadding(new Insets(10));
		nombreJugador2.setPadding(new Insets(10));		
		
		// Boton jugar
		Button botonJugar = new Button();
		botonJugar.setText("Jugar");		
		botonJugar.setPadding(new Insets(20));		

		// Contenedor Labels
		Label label1 = new Label("Nombre Jugador 1");
		Label label2 = new Label("Nombre Jugador 2");
		label1.setTextFill(Color.WHITE);
		label2.setTextFill(Color.WHITE);
		label1.setFont(Font.font("Castellar", 24));
		label2.setFont(Font.font("Castellar", 24));			

		//Reproductor
		String path = "src/Vista/Recursos/sounds/intro.wav";
		Media media = new Media(new File(path).toURI().toString());
		MediaPlayer reproductor = new MediaPlayer(media);	

		//	Contenedor Boton
		botonJugar.setMinHeight(50);
		botonJugar.setMinWidth(300);
		botonJugar.setFont(Font.font("Castellar", 30)); 
        botonJugar.setTextFill(Color.BLACK); 
		
		VBox box1 = new VBox(label1,nombreJugador1);
		VBox box2 = new VBox(botonJugar);
		VBox box3 = new VBox(label2,nombreJugador2);

		// Contenedor principal
		this.contenedorPrincipal = new HBox(box1,box2,box3);
		this.contenedorPrincipal.setAlignment(Pos.CENTER);		
		this.contenedorPrincipal.setStyle("-fx-background-image: url('file:src/Vista/Recursos/imagenEntrada.jpg');"+"-fx-background-size: cover;");

		BotonJugarEventHandler botonJugarEventHandler = new BotonJugarEventHandler(stage, nombreJugador1, nombreJugador2 , reproductor);
		
		reproductor.play();

		botonJugar.setOnAction(botonJugarEventHandler);				

	}

	public HBox getContenedor() {
		return this.contenedorPrincipal;
	}
}
