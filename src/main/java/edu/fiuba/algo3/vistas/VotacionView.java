package edu.fiuba.algo3.vistas;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;

import java.util.List;

public class VotacionView {

    private ToggleGroup grupo;
    private Button confirmar;
    private Button secundario; // "Pasar" o "Abstenerse"

    public Scene crearEscenaNominacion(int numNominador, List<String> nombres) {
        Label titulo = new Label("Fase diurna, nominaciones");
        Label instruccion = new Label("Jugador " + numNominador + ", elegi a quien nominar (o pasa):");

        grupo = new ToggleGroup();
        VBox opciones = construirOpciones(nombres);

        confirmar = new Button("Nominar");
        secundario = new Button("Pasar");

        VBox layout = new VBox(10, titulo, instruccion, opciones, confirmar, secundario);
        return new Scene(layout, 640, 480);
    }

    public Scene crearEscenaVotacion(int numVotador, List<String> nombres) {
        Label titulo = new Label("Fase diurna, votacion");
        Label instruccion = new Label("Jugador " + numVotador + ", vota a un nominado (o pasar):");

        grupo = new ToggleGroup();
        VBox opciones = construirOpciones(nombres);

        confirmar = new Button("Votar");
        secundario = new Button("Pasar");

        VBox layout = new VBox(10, titulo, instruccion, opciones, confirmar, secundario);
        return new Scene(layout, 640, 480);
    }

    private VBox construirOpciones(List<String> nombres) {
        VBox opciones = new VBox(5);
        for (int i = 0; i < nombres.size(); i++) {
            RadioButton rb = new RadioButton(nombres.get(i));
            rb.setToggleGroup(grupo);
            rb.setUserData(i);
            opciones.getChildren().add(rb);
        }
        return opciones;
    }

    public Integer getSeleccion() {
        return grupo.getSelectedToggle() == null ? null : (Integer) grupo.getSelectedToggle().getUserData();
    }

    public Button getBotonConfirmar() { return confirmar; }
    public Button getBotonSecundario() { return secundario; }
}