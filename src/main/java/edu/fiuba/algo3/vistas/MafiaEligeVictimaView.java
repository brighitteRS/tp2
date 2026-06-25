package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.modelo.BandoMafia;
import edu.fiuba.algo3.modelo.Jugadores;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.NullPattern.JugadorNulo;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.List;

public class MafiaEligeVictimaView {

    private final Stage stage;
    private final Jugadores jugadores;
    private final List<Jugador> mafiosos;
    private int turno = 0;

    public MafiaEligeVictimaView(Stage stage, Jugadores jugadores) {
        this.stage = stage;
        this.jugadores = jugadores;
        this.mafiosos = jugadores.mafiosos();
    }

    public Scene crearEscena() {
        int numeroJugador = jugadores.todosLosJugadores().indexOf(mafiosos.get(turno)) + 1;

        Label titulo = new Label("Fase nocturna, el mafioso " + numeroJugador + " elige victima");
        Label instruccion = new Label("Selecciona a quien eliminar:");

        ToggleGroup grupo = new ToggleGroup();
        VBox opciones = new VBox(5);

        for (Jugador j : jugadores.vivos()) {
            if (!j.perteneceA(BandoMafia.INSTANCIA)) {
                int num = jugadores.todosLosJugadores().indexOf(j) + 1;
                RadioButton rb = new RadioButton("Jugador " + num);
                rb.setToggleGroup(grupo);
                rb.setUserData(j);
                opciones.getChildren().add(rb);
            }
        }

        Button confirmar = new Button("Confirmar");
        Label error = new Label("");

        confirmar.setOnAction(e -> {
            if (grupo.getSelectedToggle() == null) {
                error.setText("Selecciona una victima.");
                return;
            }
            Jugador victima = (Jugador) grupo.getSelectedToggle().getUserData();
            mafiosos.get(turno).elegir(victima);
            turno++;
            if (turno >= mafiosos.size()) {
                DetectiveInvestigaView detective = new DetectiveInvestigaView(stage, jugadores);
                stage.setScene(detective.crearEscena());
            } else {
                stage.setScene(crearEscena());
            }
        });

        VBox layout = new VBox(10, titulo, instruccion, opciones, confirmar, error);
        return new Scene(layout, 640, 480);
    }
}