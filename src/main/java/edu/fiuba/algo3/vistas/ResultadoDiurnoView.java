package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.modelo.Bando;
import edu.fiuba.algo3.modelo.CondicionesVictoria.*;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Jugadores;
import edu.fiuba.algo3.modelo.NullPattern.BandoNulo;
import edu.fiuba.algo3.modelo.NullPattern.JugadorNulo;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.Arrays;

public class ResultadoDiurnoView {

    private final Stage stage;
    private final Jugadores jugadores;
    private final Jugador eliminado;

    public ResultadoDiurnoView(Stage stage, Jugadores jugadores, Jugador eliminado) {
        this.stage = stage;
        this.jugadores = jugadores;
        this.eliminado = eliminado;
    }

    public Scene crearEscena() {
        Label titulo = new Label("Resultado de la votacion");
        Label mensaje;

        if (eliminado == JugadorNulo.INSTANCIA) {
            mensaje = new Label("Nadie fue eliminado esta ronda.");
        } else {
            int num = jugadores.todosLosJugadores().indexOf(eliminado) + 1;
            mensaje = new Label("El Jugador " + num + " fue eliminado.");
        }

        EstrategiaVictoria estrategia = new EstrategiaMafiaCiudadanos(Arrays.asList(
                new MafiaGana(), new CiudadanosGanan(), new UnicoMafioso(), new UnicoCiudadano()
        ));
        Bando ganador = estrategia.resolver(jugadores);

        Button continuar = new Button(ganador.equals(BandoNulo.INSTANCIA) ? "Continuar" : "Ver resultado final");
        continuar.setOnAction(e -> {
            if (!ganador.equals(BandoNulo.INSTANCIA)) {
                jugadores.revelarTodasLasCartas();
                Label fin = new Label("Fin de la partida. Gano: " + ganador.getClass().getSimpleName());
                VBox layoutFin = new VBox(10, fin);
                stage.setScene(new Scene(layoutFin, 640, 480));
            } else {
                MafiaEligeVictimaView siguienteNoche = new MafiaEligeVictimaView(stage, jugadores);
                stage.setScene(siguienteNoche.crearEscena());
            }
        });

        VBox layout = new VBox(10, titulo, mensaje, continuar);
        return new Scene(layout, 640, 480);
    }
}