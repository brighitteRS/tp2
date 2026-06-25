package edu.fiuba.algo3.vistas;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;

import java.util.List;

public class DetectiveInvestigaView {

    private ToggleGroup grupo;
    private Button confirmar;

    public Scene crearEscena(int numDetective, List<String> nombresJugadores) {
        Label titulo = new Label("Fase nocturna, el Detective elige a quien investigar");
        Label instruccion = new Label("Jugador " + numDetective + ", selecciona a quien investigar:");

        grupo = new ToggleGroup();
        VBox opciones = new VBox(5);

        for (int i = 0; i < nombresJugadores.size(); i++) {
            RadioButton rb = new RadioButton(nombresJugadores.get(i));
            rb.setToggleGroup(grupo);
            rb.setUserData(i);
            opciones.getChildren().add(rb);
        }

        confirmar = new Button("Confirmar");

        VBox layout = new VBox(10, titulo, instruccion, opciones, confirmar);
        return new Scene(layout, 640, 480);
    }

    public Integer getSeleccion() {
        return grupo.getSelectedToggle() == null ? null : (Integer) grupo.getSelectedToggle().getUserData();
    }

    public Button getBotonConfirmar() { return confirmar; }
}