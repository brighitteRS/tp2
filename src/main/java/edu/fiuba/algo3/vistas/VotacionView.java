package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.modelo.Jugadores;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.NullPattern.JugadorNulo;
import edu.fiuba.algo3.modelo.Urna.SistemaNominaciones;
import edu.fiuba.algo3.modelo.Urna.Urna;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.List;

public class VotacionView {

    private final Stage stage;
    private final Jugadores jugadores;
    private final SistemaNominaciones nominaciones;
    private final Urna urna;
    private final List<Jugador> vivos;
    private final int turno;

    public VotacionView(Stage stage, Jugadores jugadores) {
        this(stage, jugadores, new SistemaNominaciones(), new Urna(), 0);
    }

    private VotacionView(Stage stage, Jugadores jugadores, SistemaNominaciones nominaciones, Urna urna, int turno) {
        this.stage = stage;
        this.jugadores = jugadores;
        this.nominaciones = nominaciones;
        this.urna = urna;
        this.vivos = jugadores.vivos();
        this.turno = turno;
    }

    public Scene crearEscena() {
        if (turno < vivos.size()) {
            return crearEscenaNominacion();
        }
        return continuarConVotacionOResultado();
    }

    private Scene crearEscenaNominacion() {
        Jugador nominador = vivos.get(turno);
        int numNominador = jugadores.todosLosJugadores().indexOf(nominador) + 1;

        Label titulo = new Label("Fase diurna, nominaciones");
        Label instruccion = new Label("Jugador " + numNominador + ", elegi a quien nominar (o pasa):");

        ToggleGroup grupo = new ToggleGroup();
        VBox opciones = new VBox(5);

        for (Jugador j : vivos) {
            int num = jugadores.todosLosJugadores().indexOf(j) + 1;
            RadioButton rb = new RadioButton("Jugador " + num);
            rb.setToggleGroup(grupo);
            rb.setUserData(j);
            opciones.getChildren().add(rb);
        }

        Button confirmar = new Button("Nominar");
        Button pasar = new Button("Pasar");

        confirmar.setOnAction(e -> {
            if (grupo.getSelectedToggle() == null) return;
            Jugador nominado = (Jugador) grupo.getSelectedToggle().getUserData();
            nominaciones.agregarCandidato(nominado);
            avanzarNominacion();
        });

        pasar.setOnAction(e -> avanzarNominacion());

        VBox layout = new VBox(10, titulo, instruccion, opciones, confirmar, pasar);
        return new Scene(layout, 640, 480);
    }

    private void avanzarNominacion() {
        VotacionView siguiente = new VotacionView(stage, jugadores, nominaciones, urna, turno + 1);
        stage.setScene(siguiente.crearEscena());
    }

    private Scene continuarConVotacionOResultado() {
        List<Jugador> candidatos = nominaciones.obtenerCandidatos();

        if (candidatos.isEmpty()) {
            return irAResultado(JugadorNulo.INSTANCIA);
        }

        if (turno - vivos.size() >= vivos.size()) {
            return resolverVotacion();
        }

        return crearEscenaVotacion(candidatos);
    }

    private Scene crearEscenaVotacion(List<Jugador> candidatos) {
        int indiceVotador = turno - vivos.size();
        Jugador votador = vivos.get(indiceVotador);
        int numVotador = jugadores.todosLosJugadores().indexOf(votador) + 1;

        Label titulo = new Label("Fase diurna, votacion");
        Label instruccion = new Label("Jugador " + numVotador + ", vota a un nominado (o pasar):");

        ToggleGroup grupo = new ToggleGroup();
        VBox opciones = new VBox(5);

        for (Jugador c : candidatos) {
            int num = jugadores.todosLosJugadores().indexOf(c) + 1;
            RadioButton rb = new RadioButton("Jugador " + num);
            rb.setToggleGroup(grupo);
            rb.setUserData(c);
            opciones.getChildren().add(rb);
        }

        Button confirmar = new Button("Votar");
        Button abstenerse = new Button("Pasar");

        confirmar.setOnAction(e -> {
            if (grupo.getSelectedToggle() == null) return;
            Jugador votado = (Jugador) grupo.getSelectedToggle().getUserData();
            urna.registrarVoto(votador, votado);
            avanzarVotacion();
        });

        abstenerse.setOnAction(e -> avanzarVotacion());

        VBox layout = new VBox(10, titulo, instruccion, opciones, confirmar, abstenerse);
        return new Scene(layout, 640, 480);
    }

    private void avanzarVotacion() {
        VotacionView siguiente = new VotacionView(stage, jugadores, nominaciones, urna, turno + 1);
        stage.setScene(siguiente.crearEscena());
    }

    private Scene resolverVotacion() {
        List<Jugador> ganadores = urna.getGanadores();
        Jugador eliminado = (ganadores.size() == 1) ? ganadores.get(0) : null;
        if (eliminado != JugadorNulo.INSTANCIA) {
            eliminado.eliminar();
        }
        return irAResultado(eliminado);
    }

    private Scene irAResultado(Jugador eliminado) {
        ResultadoDiurnoView resultado = new ResultadoDiurnoView(stage, jugadores, eliminado);
        return resultado.crearEscena();
    }
}