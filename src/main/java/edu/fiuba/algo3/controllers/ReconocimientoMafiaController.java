package edu.fiuba.algo3.controllers;

import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Jugadores;
import edu.fiuba.algo3.vistas.MafiaEligeVictimaView;
import edu.fiuba.algo3.vistas.ReconocimientoMafiaView;
import javafx.stage.Stage;


import java.util.List;

public class ReconocimientoMafiaController {

    private final Stage stage;
    private final ReconocimientoMafiaView view;
    private final Jugadores jugadores;
    private final List<Jugador> mafiosos;
    private int turno = 0;

    public ReconocimientoMafiaController(Stage stage, ReconocimientoMafiaView view, Jugadores jugadores) {
        this.stage = stage;
        this.view = view;
        this.jugadores = jugadores;
        this.mafiosos = jugadores.mafiosos();

        int numeroJugador = jugadores.todosLosJugadores().indexOf(mafiosos.get(0)) + 1;
        stage.setScene(view.crearEscena(numeroJugador));
        view.getBotonVer().setOnAction(e -> mostrarComplices());
        view.getBotonListo().setOnAction(e -> avanzar());
    }

    private void mostrarComplices() {
        StringBuilder texto = new StringBuilder("Tus complices son:\n");
        for (int i = 0; i < mafiosos.size(); i++) {
            if (i != turno) {
                int num = jugadores.todosLosJugadores().indexOf(mafiosos.get(i)) + 1;
                texto.append("- Jugador ").append(num).append("\n");
            }
        }
        view.mostrarComplices(texto.toString());
    }

    private void avanzar() {
        turno++;
        if (turno >= mafiosos.size()) {
            MafiaEligeVictimaView mafia = new MafiaEligeVictimaView();
            new MafiaEligeVictimaController(stage, mafia, jugadores);
        } else {
            int numeroJugador = jugadores.todosLosJugadores().indexOf(mafiosos.get(turno)) + 1;
            stage.setScene(view.crearEscena(numeroJugador));
            view.getBotonVer().setOnAction(e -> mostrarComplices());
            view.getBotonListo().setOnAction(e -> avanzar());
        }
    }
}