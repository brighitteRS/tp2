package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Jugadores;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class RepartoView {

    private final Stage stage;
    private final Jugadores jugadores;
    private int turno = 0;

    public RepartoView(Stage stage, Jugadores jugadores) {
        this.stage = stage;
        this.jugadores = jugadores;
    }

    public Scene crearEscena() {

        Label mensaje = new Label("Jugador " + (turno + 1) + ", es tu turno.");
        Label rol = new Label("");
        Button verCarta = new Button("Ver carta");
        Button listo = new Button("Listo");
        listo.setVisible(false);

        verCarta.setOnAction(e->{
            Jugador jugador = jugadores.todosLosJugadores().get(turno);
            String nombreRol = jugador.consultarRol(jugador).getClass().getSimpleName();
            rol.setText("Tu rol es: " + nombreRol);
            verCarta.setVisible(false);
            listo.setVisible(true);
        });

        listo.setOnAction(e->{

            turno++;
            if (turno >= jugadores.todosLosJugadores().size()) {
                ReconocimientoMafiaView reconocimiento = new ReconocimientoMafiaView(stage, jugadores);
                stage.setScene(reconocimiento.crearEscena());

            } else {
                stage.setScene(crearEscena());
            }
        });

        VBox layout = new VBox(10, mensaje, rol, verCarta, listo);
        return new Scene(layout, 640, 480);
    }
}