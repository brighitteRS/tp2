package edu.fiuba.algo3.vistas;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.List;

public class MafiaEligeVictimaView {

    private Label error;
    public Scene crearEscena(int numeroJugador,
                             List<String> nombresVictimas,
                             ToggleGroup grupo,
                             EventHandler<ActionEvent> handlerConfirmar)
    {
        Label titulo = new Label("Fase nocturna, el mafioso " + numeroJugador + " elige victima");
        Label instruccion = new Label("Selecciona a quien eliminar:");

        VBox opciones = new VBox(5);

        for (int i = 0; i < nombresVictimas.size(); i++) {
            RadioButton rb = new RadioButton(nombresVictimas.get(i));
            rb.setToggleGroup(grupo);
            rb.setUserData(i);
            opciones.getChildren().add(rb);
        }

        Button confirmar = new Button("Confirmar");
        confirmar.setOnAction(handlerConfirmar);

        error = new Label("");

        VBox layout = new VBox(10, titulo, instruccion, opciones, confirmar, error);
        return new Scene(layout, 640, 480);
    }

    public void mostrarError(String mensaje) { error.setText(mensaje); }
}