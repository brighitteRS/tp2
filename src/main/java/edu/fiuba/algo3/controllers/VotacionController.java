package edu.fiuba.algo3.controllers;

import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Jugadores;
import edu.fiuba.algo3.modelo.NullPattern.JugadorNulo;
import edu.fiuba.algo3.modelo.Urna.SistemaNominaciones;
import edu.fiuba.algo3.modelo.Urna.Urna;
import edu.fiuba.algo3.vistas.ResultadoDiurnoView;
import edu.fiuba.algo3.vistas.VotacionView;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class VotacionController {

    private final Stage stage;
    private final VotacionView view;
    private final Jugadores jugadores;
    private final SistemaNominaciones nominaciones;
    private final Urna urna;
    private final List<Jugador> vivos;
    private int turno;

    public VotacionController(Stage stage, VotacionView view, Jugadores jugadores) {
        this(stage, view, jugadores, new SistemaNominaciones(), new Urna(), 0);
    }

    private VotacionController(Stage stage, VotacionView view, Jugadores jugadores,
                               SistemaNominaciones nominaciones, Urna urna, int turno) {
        this.stage = stage;
        this.view = view;
        this.jugadores = jugadores;
        this.nominaciones = nominaciones;
        this.urna = urna;
        this.vivos = jugadores.vivos();
        this.turno = turno;

        mostrarTurnoActual();
    }

    private void mostrarTurnoActual() {
        if (turno < vivos.size()) {
            mostrarNominacion();
        } else {
            continuarConVotacionOResultado();
        }
    }

    private void mostrarNominacion() {
        Jugador nominador = vivos.get(turno);
        int numNominador = jugadores.todosLosJugadores().indexOf(nominador) + 1;

        List<String> nombres = new ArrayList<>();
        for (Jugador j : vivos) {
            nombres.add("Jugador " + (jugadores.todosLosJugadores().indexOf(j) + 1));
        }

        stage.setScene(view.crearEscenaNominacion(numNominador, nombres));

        view.getBotonConfirmar().setOnAction(e -> {
            Integer seleccion = view.getSeleccion();
            if (seleccion == null) return;
            nominaciones.agregarCandidato(vivos.get(seleccion));
            avanzar();
        });

        view.getBotonSecundario().setOnAction(e -> avanzar());
    }

    private void continuarConVotacionOResultado() {
        List<Jugador> candidatos = nominaciones.obtenerCandidatos();

        if (candidatos.isEmpty()) {
            irAResultado(JugadorNulo.INSTANCIA);
            return;
        }

        if (turno - vivos.size() >= vivos.size()) {
            resolverVotacion();
            return;
        }

        mostrarVotacion(candidatos);
    }

    private void mostrarVotacion(List<Jugador> candidatos) {
        int indiceVotador = turno - vivos.size();
        Jugador votador = vivos.get(indiceVotador);
        int numVotador = jugadores.todosLosJugadores().indexOf(votador) + 1;

        List<String> nombres = new ArrayList<>();
        for (Jugador c : candidatos) {
            nombres.add("Jugador " + (jugadores.todosLosJugadores().indexOf(c) + 1));
        }

        stage.setScene(view.crearEscenaVotacion(numVotador, nombres));

        view.getBotonConfirmar().setOnAction(e -> {
            Integer seleccion = view.getSeleccion();
            if (seleccion == null) return;
            urna.registrarVoto(votador, candidatos.get(seleccion));
            avanzar();
        });

        view.getBotonSecundario().setOnAction(e -> avanzar());
    }

    private void avanzar() {
        turno++;
        mostrarTurnoActual();
    }

    // no se si matarlo aca esta bien. verlo con fasediurna
    private void resolverVotacion() {
        List<Jugador> ganadores = urna.getGanadores();
        Jugador eliminado = (ganadores.size() == 1) ? ganadores.get(0) : null;
        if (eliminado != JugadorNulo.INSTANCIA) {
            eliminado.eliminar();
        }
        irAResultado(eliminado);
    }

    private void irAResultado(Jugador eliminado) {
        ResultadoDiurnoView resultado = new ResultadoDiurnoView();
        new ResultadoDiurnoController(stage, resultado, jugadores, eliminado);
    }
}