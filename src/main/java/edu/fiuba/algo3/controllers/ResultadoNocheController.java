package edu.fiuba.algo3.controllers;

import edu.fiuba.algo3.modelo.FaseNocturna.Mafia;
import edu.fiuba.algo3.modelo.FaseNocturna.ResultadoNocturno;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Jugadores;
import edu.fiuba.algo3.vistas.ResultadoNocheView;
import edu.fiuba.algo3.vistas.VotacionView;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class ResultadoNocheController {

    private final Stage stage;
    private final Jugadores jugadores;

    public ResultadoNocheController(Stage stage, ResultadoNocheView view, Jugadores jugadores) {
        this.stage = stage;
        this.jugadores = jugadores;
        List<Jugador> vivosAntes = new ArrayList<>(jugadores.vivos());

        ResultadoNocturno resultado = new ResultadoNocturno();
        Mafia mafia = new Mafia(jugadores.vivos());
        mafia.actuarDeNoche(resultado);

        for (Jugador j : jugadores.vivos()) {
            j.actuarComoDetective(resultado);
            j.actuarComoMedico(resultado);
        }

        resultado.resolver();

        List<Jugador> vivosDespues = jugadores.vivos();
        vivosAntes.removeAll(vivosDespues);

        String mensajeResultado;
        if (vivosAntes.isEmpty()) {
            mensajeResultado = "Esta noche no hubo victimas.";
        } else {
            int num = jugadores.todosLosJugadores().indexOf(vivosAntes.get(0)) + 1;
            mensajeResultado = "El Jugador " + num + " fue eliminado.";
        }

        stage.setScene(view.crearEscena(mensajeResultado));
        view.getBotonContinuar().setOnAction(e -> irAVotacion());
    }

    private void irAVotacion() {
        VotacionView votacion = new VotacionView();
        new VotacionController(stage, votacion, jugadores);
    }
}