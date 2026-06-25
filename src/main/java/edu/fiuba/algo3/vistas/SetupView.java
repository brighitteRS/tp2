package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.modelo.Mazo.Mazo;
import edu.fiuba.algo3.modelo.SetUpPartida;
import edu.fiuba.algo3.modelo.Jugadores;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class SetupView {

    private final Stage stage;

    public SetupView(Stage stage) {
        this.stage = stage;
    }

    public Scene crearEscena() {

        Label titulo = new Label("Mafia");
        Label pregunta = new Label("Cantidad de jugadores:");
        TextField campo = new TextField("5");
        Button iniciar = new Button("Iniciar");

        iniciar.setOnAction(e -> {
            int cantidad = Integer.parseInt(campo.getText());
            Mazo mazo = new Mazo(cantidad);
            SetUpPartida setup = new SetUpPartida(mazo);
            Jugadores jugadores = setup.ejecutar();
            RepartoView reparto = new RepartoView(stage, jugadores);
            stage.setScene(reparto.crearEscena());
        });

        VBox layout = new VBox(10, titulo, pregunta, campo, iniciar);

        return new Scene(layout, 640, 480);
    }
}