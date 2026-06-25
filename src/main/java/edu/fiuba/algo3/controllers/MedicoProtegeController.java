package edu.fiuba.algo3.controllers;

import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Jugadores;
import edu.fiuba.algo3.modelo.NullPattern.JugadorNulo;
import edu.fiuba.algo3.vistas.MedicoProtegeView;
import edu.fiuba.algo3.vistas.ResultadoNocheView;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class MedicoProtegeController {

    private final Stage stage;
    private final MedicoProtegeView view;
    private final Jugadores jugadores;
    private final Jugador medico;
    private List<Jugador> candidatos;

    public MedicoProtegeController(Stage stage, MedicoProtegeView view, Jugadores jugadores) {
        this.stage = stage;
        this.view = view;
        this.jugadores = jugadores;

        this.medico = jugadores.vivos().stream()
                .filter(j -> j.consultarRol(j).getClass().getSimpleName().equals("Medico"))
                .findFirst()
                .orElse(null);

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

        stage.setScene(view.crearEscena(numMedico, nombres));
        view.getBotonConfirmar().setOnAction(e -> confirmar());
    }

    private void confirmar() {
        Integer seleccion = view.getSeleccion();
        if (seleccion == null) return;

        Jugador protegido = candidatos.get(seleccion);
        medico.elegir(protegido);

        irAResultado();
    }

    private void irAResultado() {
        ResultadoNocheView resultado = new ResultadoNocheView();
        new ResultadoNocheController(stage, resultado, jugadores);
    }
}