package edu.fiuba.algo3.controllers;

import edu.fiuba.algo3.modelo.BandoMafia;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Jugadores;
import edu.fiuba.algo3.vistas.DetectiveInvestigaView;
import edu.fiuba.algo3.vistas.MafiaEligeVictimaView;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class MafiaEligeVictimaController {

    private final Stage stage;
    private final MafiaEligeVictimaView view;
    private final Jugadores jugadores;
    private final List<Jugador> mafiosos;
    private final List<Jugador> victimas;
    private int turno = 0;

    public MafiaEligeVictimaController(Stage stage, MafiaEligeVictimaView view, Jugadores jugadores) {
        this.stage = stage;
        this.view = view;
        this.jugadores = jugadores;
        this.mafiosos = jugadores.mafiosos();
        this.victimas = jugadores.vivos().stream()
                .filter(j -> !j.perteneceA(BandoMafia.INSTANCIA))
                .collect(java.util.stream.Collectors.toList());

        mostrarTurno();
    }

    private void mostrarTurno() {
        int numeroJugador = jugadores.todosLosJugadores().indexOf(mafiosos.get(turno)) + 1;
        List<String> nombres = new ArrayList<>();
        for (Jugador v : victimas) {
            nombres.add("Jugador " + (jugadores.todosLosJugadores().indexOf(v) + 1));
        }
        stage.setScene(view.crearEscena(numeroJugador, nombres));
        view.getBotonConfirmar().setOnAction(e -> confirmar());
    }

    private void confirmar() {
        Integer seleccion = view.getSeleccion();
        if (seleccion == null) {
            view.mostrarError("Selecciona una victima.");
            return;
        }
        mafiosos.get(turno).elegir(victimas.get(seleccion));
        turno++;
        if (turno >= mafiosos.size()) {
            DetectiveInvestigaView detective = new DetectiveInvestigaView();
            new DetectiveInvestigaController(stage, detective, jugadores);
        } else {
            mostrarTurno();
        }
    }
}