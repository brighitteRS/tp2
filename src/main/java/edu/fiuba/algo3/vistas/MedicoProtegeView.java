package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.modelo.Jugadores;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class MedicoProtegeView {

    private final Stage stage;
    private final Jugadores jugadores;

    public MedicoProtegeView(Stage stage, Jugadores jugadores) {
        this.stage = stage;
        this.jugadores = jugadores;
    }

    public Scene crearEscena() {
        Jugador medico = jugadores.vivos().stream()
                .filter(j -> j.consultarRol(j).getClass().getSimpleName().equals("Medico"))
                .findFirst()
                .orElse(null);

        if (medico == null) {

            ResultadoNocheView resultado = new ResultadoNocheView(stage, jugadores);
            return resultado.crearEscena();
        }

        int numMedico = jugadores.todosLosJugadores().indexOf(medico) + 1;

        Label titulo = new Label("Fase nocturna, el medico elige a quien proteger");
        Label instruccion = new Label("Jugador " + numMedico + ", selecciona a quien proteger:");

        ToggleGroup grupo = new ToggleGroup();
        VBox opciones = new VBox(5);

        for (Jugador j : jugadores.vivos()) {
            int num = jugadores.todosLosJugadores().indexOf(j) + 1;
            RadioButton rb = new RadioButton("Jugador " + num);
            rb.setToggleGroup(grupo);
            rb.setUserData(j);
            opciones.getChildren().add(rb);
        }

        Button confirmar = new Button("Confirmar");

        Jugador medicoFinal = medico;
        confirmar.setOnAction(e -> {
            if (grupo.getSelectedToggle() == null) return;
            Jugador protegido = (Jugador) grupo.getSelectedToggle().getUserData();
            medicoFinal.elegir(protegido);
            ResultadoNocheView resultado = new ResultadoNocheView(stage, jugadores);
            stage.setScene(resultado.crearEscena());
        });

        VBox layout = new VBox(10, titulo, instruccion, opciones, confirmar);
        return new Scene(layout, 640, 480);
    }
}