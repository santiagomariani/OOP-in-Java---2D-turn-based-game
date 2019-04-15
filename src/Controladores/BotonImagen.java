package Controladores;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.image.*;
import Vista.*;

public class BotonImagen extends Button {

    public BotonImagen (ImageView imagen, javafx.event.EventHandler<ActionEvent> controlador){
        setImagen(imagen);
        setControlador(controlador);
        setMinHeight(80);
        setMinWidth(80);
    }   

    public void setImagen(ImageView imagen){
        imagen.setFitHeight(40);
        imagen.setFitWidth(40);
        setGraphic(imagen);
    }

    public void setControlador(javafx.event.EventHandler<ActionEvent> controlador) {
        setOnAction(controlador);
    }
}
