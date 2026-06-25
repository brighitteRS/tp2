package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.SystemInfo;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        SetupView setup = new SetupView(stage);
        stage.setScene(setup.crearEscena());
        stage.setTitle("TP2-MAFIA v1.0");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}