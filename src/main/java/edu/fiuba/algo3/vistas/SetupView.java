package edu.fiuba.algo3.vistas;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class SetupView {

    private TextField campo;
    private Button iniciar;

    public Scene crearEscena() {
        Label titulo = new Label("Mafia");
        Label pregunta = new Label("Cantidad de jugadores:");
        campo = new TextField("5");
        iniciar = new Button("Iniciar");

        VBox layout = new VBox(10, titulo, pregunta, campo, iniciar);
        return new Scene(layout, 640, 480);
    }

    public int getCantidadJugadores() {
        return Integer.parseInt(campo.getText());
    }

    public Button getBotonIniciar() {
        return iniciar;
    }
}