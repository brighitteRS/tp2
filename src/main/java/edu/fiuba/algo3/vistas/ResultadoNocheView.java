package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.modelo.FaseNocturna.Mafia;
import edu.fiuba.algo3.modelo.FaseNocturna.ResultadoNocturno;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Jugadores;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class ResultadoNocheView {

    private final Stage stage;
    private final Jugadores jugadores;

    public ResultadoNocheView(Stage stage, Jugadores jugadores) {
        this.stage = stage;
        this.jugadores = jugadores;
    }

    public Scene crearEscena() {
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

        Label titulo = new Label("Ya amanecio");
        Label mensaje;

        if (vivosAntes.isEmpty()) {
            mensaje = new Label("Esta noche no hubo victimas.");
        } else {
            int num = jugadores.todosLosJugadores().indexOf(vivosAntes.get(0)) + 1;
            mensaje = new Label("El Jugador " + num + " fue eliminado.");
        }

        Button continuar = new Button("Continuar");
        continuar.setOnAction(e -> {
            VotacionView votacion = new VotacionView(stage, jugadores);
            stage.setScene(votacion.crearEscena());
        });

        VBox layout = new VBox(10, titulo, mensaje, continuar);
        return new Scene(layout, 640, 480);
    }
}