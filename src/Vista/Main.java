package Vista;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application  {


    @Override
    public void start(Stage stage) {       

    	ContenedorEntrada contenedorEntrada = new ContenedorEntrada(stage);

        Scene scene = new Scene(contenedorEntrada.getContenedor(), 1600, 800);
        stage.setTitle("Algo of Empires");
        stage.setMaximized(true);       
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}