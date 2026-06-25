package edu.fiuba.algo3.controllers;

import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Jugadores;
import edu.fiuba.algo3.modelo.NullPattern.JugadorNulo;
import edu.fiuba.algo3.vistas.*;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.ArrayList;
import java.util.List;

public class MedicoProtegeController implements EventHandler<ActionEvent> {

    private final Stage stage;
    private final MedicoProtegeView view;
    private final Jugadores jugadores;
    private final Jugador medico;
    private List<Jugador> candidatos;
    private final ToggleGroup grupo = new ToggleGroup();

    public MedicoProtegeController(Stage stage, MedicoProtegeView view, Jugadores jugadores) {
        this.stage = stage;
        this.view = view;
        this.jugadores = jugadores;

        this.medico = jugadores.vivos().stream()
                .filter(j -> j.consultarRol(j).getClass().getSimpleName().equals("Medico"))
                .findFirst()
                .orElse(JugadorNulo.INSTANCIA);

        if (medico == JugadorNulo.INSTANCIA) {
            irAResultado();
            return;
        }

        this.candidatos = new ArrayList<>(jugadores.vivos());

        int numMedico = jugadores.todosLosJugadores().indexOf(medico) + 1;

        List<String> nombres = new ArrayList<>();
        for (Jugador j : candidatos) {
            nombres.add("Jugador " + (jugadores.todosLosJugadores().indexOf(j) + 1));
        }

        stage.setScene(view.crearEscena(numMedico, nombres,grupo,this));
    }

    @Override
    public void handle(ActionEvent event) {

        if (grupo.getSelectedToggle() == null) return;

        Integer seleccion =
                (Integer) grupo.getSelectedToggle().getUserData();

        Jugador protegido = candidatos.get(seleccion);
        medico.elegir(protegido);

        irAResultado();
    }

    private void irAResultado() {
        ResultadoNocheView resultado = new ResultadoNocheView();
        new ResultadoNocheController(stage, resultado, jugadores);
    }
}