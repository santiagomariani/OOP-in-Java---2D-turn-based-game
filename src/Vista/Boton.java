package Vista;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.text.*;
import Controladores.*;

public class Boton extends Button {

    public Boton (String texto, javafx.event.EventHandler<ActionEvent> controlador){
        setTexto(texto);
        setControlador(controlador);
    }   

    public void setTexto(String texto){
        setFont(Font.font("Castellar", 20)); 
        setText(texto);
    }
    public void setControlador(javafx.event.EventHandler<ActionEvent> controlador) {
        setOnAction(controlador);
    }
}
