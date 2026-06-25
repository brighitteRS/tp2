package edu.fiuba.algo3.controllers;

import edu.fiuba.algo3.modelo.Bando;
import edu.fiuba.algo3.modelo.BandoMafia;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Jugadores;
import edu.fiuba.algo3.modelo.NullPattern.JugadorNulo;
import edu.fiuba.algo3.vistas.DetectiveInvestigaView;
import edu.fiuba.algo3.vistas.MedicoProtegeView;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class DetectiveInvestigaController {

    private final Stage stage;
    private final DetectiveInvestigaView view;
    private final Jugadores jugadores;
    private final Jugador detective;
    private final List<Jugador> candidatos;

    public DetectiveInvestigaController(Stage stage, DetectiveInvestigaView view, Jugadores jugadores) {
        this.stage = stage;
        this.view = view;
        this.jugadores = jugadores;

        this.detective = jugadores.vivos().stream()
                .filter(j -> j.consultarRol(j).getClass().getSimpleName().equals("Detective"))
                .findFirst()
                .orElse(null);

        this.candidatos = new ArrayList<>();

        if (detective == JugadorNulo.INSTANCIA) {
            irAMedico();
            return;
        }

        for (Jugador j : jugadores.vivos()) {
            if (j != detective) candidatos.add(j);
        }

        int numDetective = jugadores.todosLosJugadores().indexOf(detective) + 1;
        List<String> nombres = new ArrayList<>();
        for (Jugador j : candidatos) {
            nombres.add("Jugador " + (jugadores.todosLosJugadores().indexOf(j) + 1));
        }
        stage.setScene(view.crearEscena(numDetective, nombres));

        view.getBotonConfirmar().setOnAction(e -> confirmar());
    }

    private void confirmar() {
        Integer seleccion = view.getSeleccion();
        if (seleccion == null) return;

        Jugador investigado = candidatos.get(seleccion);
        try {
            detective.elegir(investigado);
        } catch (IllegalArgumentException ex) {
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setContentText("Ya investigaste a ese jugador la noche anterior.");
            alerta.showAndWait();
            return;
        }

        Bando bando = investigado.revelarBandoAInvestigacion();
        String texto = bando.equals(BandoMafia.INSTANCIA) ? "Mafia" : "Ciudadano";

        Alert info = new Alert(Alert.AlertType.INFORMATION);
        info.setContentText("El jugador investigado pertenece a: " + texto);
        info.showAndWait();

        irAMedico();
    }

    private void irAMedico() {
        MedicoProtegeView medico = new MedicoProtegeView();
        new MedicoProtegeController(stage, medico, jugadores);
    }
}