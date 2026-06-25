package edu.fiuba.algo3.vistas;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;

import java.util.List;

public class MafiaEligeVictimaView {

    private ToggleGroup grupo;
    private Button confirmar;
    private Label error;

    public Scene crearEscena(int numeroJugador, List<String> nombresVictimas) {
        Label titulo = new Label("Fase nocturna, el mafioso " + numeroJugador + " elige victima");
        Label instruccion = new Label("Selecciona a quien eliminar:");

        grupo = new ToggleGroup();
        VBox opciones = new VBox(5);

        for (int i = 0; i < nombresVictimas.size(); i++) {
            RadioButton rb = new RadioButton(nombresVictimas.get(i));
            rb.setToggleGroup(grupo);
            rb.setUserData(i);
            opciones.getChildren().add(rb);
        }

        confirmar = new Button("Confirmar");
        error = new Label("");

        VBox layout = new VBox(10, titulo, instruccion, opciones, confirmar, error);
        return new Scene(layout, 640, 480);
    }

    public void mostrarError(String mensaje) { error.setText(mensaje); }
    public Integer getSeleccion() {
        return grupo.getSelectedToggle() == null ? null : (Integer) grupo.getSelectedToggle().getUserData();
    }
    public Button getBotonConfirmar() { return confirmar; }
}