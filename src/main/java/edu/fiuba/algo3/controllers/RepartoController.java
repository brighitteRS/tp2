package edu.fiuba.algo3.controllers;

import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Jugadores;
import edu.fiuba.algo3.vistas.ReconocimientoMafiaView;
import edu.fiuba.algo3.vistas.RepartoView;
import javafx.stage.Stage;

public class RepartoController {

    private final Stage stage;
    private final RepartoView view;
    private final Jugadores jugadores;
    private int turno = 0;

    public RepartoController(Stage stage, RepartoView view, Jugadores jugadores) {
        this.stage = stage;
        this.view = view;
        this.jugadores = jugadores;

        stage.setScene(view.crearEscena(0));
        view.getBotonVerCarta().setOnAction(e -> verCarta());
        view.getBotonListo().setOnAction(e -> avanzar());
    }

    private void verCarta() {
        Jugador jugador = jugadores.todosLosJugadores().get(turno);
        String nombreRol = jugador.consultarRol(jugador).getClass().getSimpleName();
        view.mostrarRol(nombreRol);
    }

    private void avanzar() {
        turno++;
        if (turno >= jugadores.todosLosJugadores().size()) {
            ReconocimientoMafiaView reconocimiento = new ReconocimientoMafiaView();
            new ReconocimientoMafiaController(stage, reconocimiento, jugadores);
        } else {
            stage.setScene(view.crearEscena(turno));
            view.getBotonVerCarta().setOnAction(e -> verCarta());
            view.getBotonListo().setOnAction(e -> avanzar());
        }
    }
}