package edu.fiuba.algo3.vistas;
import javafx.application.Application;
import javafx.stage.Stage;
import edu.fiuba.algo3.controllers.SetupController;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        SetupView view = new SetupView();
        stage.setScene(view.crearEscena());
        new SetupController(stage, view);
        stage.setTitle("TP2-MAFIA v1.1");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}