package edu.fiuba.algo3.vistas;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.util.List;

public class MedicoProtegeView {

    public Scene crearEscena(int numMedico,
                             List<String> nombresJugadores,
                             ToggleGroup grupo,
                             EventHandler<ActionEvent> handlerConfirmar) {
        Label titulo = new Label("Fase nocturna, el medico elige a quien proteger");
        Label instruccion = new Label("Jugador " + numMedico + ", selecciona a quien proteger:");

        VBox opciones = new VBox(5);

        for (int i = 0; i < nombresJugadores.size(); i++) {
            RadioButton rb = new RadioButton(nombresJugadores.get(i));
            rb.setToggleGroup(grupo);
            rb.setUserData(i);
            opciones.getChildren().add(rb);
        }

        Button confirmar = new Button("Confirmar");
        confirmar.setOnAction(handlerConfirmar);

        VBox layout = new VBox(10, titulo, instruccion, opciones, confirmar);
        return new Scene(layout, 640, 480);
    }
}