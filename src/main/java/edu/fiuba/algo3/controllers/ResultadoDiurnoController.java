package edu.fiuba.algo3.controllers;

import edu.fiuba.algo3.modelo.Bando;
import edu.fiuba.algo3.modelo.CondicionesVictoria.*;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Jugadores;
import edu.fiuba.algo3.modelo.NullPattern.BandoNulo;
import edu.fiuba.algo3.modelo.NullPattern.JugadorNulo;
import edu.fiuba.algo3.vistas.MafiaEligeVictimaView;
import edu.fiuba.algo3.vistas.ResultadoDiurnoView;
import javafx.stage.Stage;

import java.util.Arrays;

public class ResultadoDiurnoController {

    private final Stage stage;
    private final ResultadoDiurnoView view;
    private final Jugadores jugadores;
    private final Bando ganador;

    public ResultadoDiurnoController(Stage stage, ResultadoDiurnoView view, Jugadores jugadores, Jugador eliminado) {
        this.stage = stage;
        this.view = view;
        this.jugadores = jugadores;

        String mensajeEliminado;
        if (eliminado == JugadorNulo.INSTANCIA) {
            mensajeEliminado = "Nadie fue eliminado esta ronda.";
        } else {
            int num = jugadores.todosLosJugadores().indexOf(eliminado) + 1;
            mensajeEliminado = "El Jugador " + num + " fue eliminado.";
        }

        EstrategiaVictoria estrategia = new EstrategiaMafiaCiudadanos(Arrays.asList(
                new MafiaGana(), new CiudadanosGanan(), new UnicoMafioso(), new UnicoCiudadano()
        ));
        this.ganador = estrategia.resolver(jugadores);

        String textoContinuar = ganador.equals(BandoNulo.INSTANCIA) ? "Continuar" : "Ver resultado final";
        stage.setScene(view.crearEscena(mensajeEliminado, textoContinuar));
        view.getBotonContinuar().setOnAction(e -> continuar());
    }

    private void continuar() {
        if (!ganador.equals(BandoNulo.INSTANCIA)) {
            jugadores.revelarTodasLasCartas();
            String mensajeFin = "Fin de la partida! Gano: " + ganador.getClass().getSimpleName();
            stage.setScene(view.crearEscenaFin(mensajeFin));
        } else {
            MafiaEligeVictimaView siguienteNoche = new MafiaEligeVictimaView();
            new MafiaEligeVictimaController(stage, siguienteNoche, jugadores);
        }
    }
}