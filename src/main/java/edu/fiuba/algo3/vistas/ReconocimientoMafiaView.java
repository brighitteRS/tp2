package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.modelo.Jugadores;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.List;

public class ReconocimientoMafiaView {

    private final Stage stage;
    private final Jugadores jugadores;
    private final List<Jugador> mafiosos;
    private int turno = 0;

    public ReconocimientoMafiaView(Stage stage, Jugadores jugadores) {
        this.stage = stage;
        this.jugadores = jugadores;
        this.mafiosos = jugadores.mafiosos();
    }

    public Scene crearEscena() {
        int numeroJugador = jugadores.todosLosJugadores().indexOf(mafiosos.get(turno)) + 1;

        Label mensaje = new Label("Jugador " + numeroJugador + ", sos Mafioso.");
        Label complices = new Label("");
        Button ver = new Button("Ver complices");
        Button listo = new Button("listo");
        listo.setVisible(false);

        ver.setOnAction(e -> {
            StringBuilder texto = new StringBuilder("Tus complices son:\n");
            for (int i = 0; i < mafiosos.size(); i++) {
                if (i != turno) {
                    int num = jugadores.todosLosJugadores().indexOf(mafiosos.get(i)) + 1;
                    texto.append("- Jugador ").append(num).append("\n");
                }
            }
            complices.setText(texto.toString());
            ver.setVisible(false);
            listo.setVisible(true);
        });

        listo.setOnAction(e -> {
            turno++;
            if (turno >= mafiosos.size()) {
                MafiaEligeVictimaView mafia = new MafiaEligeVictimaView(stage, jugadores);
                stage.setScene(mafia.crearEscena());
            } else {
                stage.setScene(crearEscena());
            }
        });

        VBox layout = new VBox(10, mensaje, ver, complices, listo);
        return new Scene(layout, 640, 480);
    }
}