package edu.fiuba.algo3.controllers;

import edu.fiuba.algo3.modelo.Jugadores;
import edu.fiuba.algo3.modelo.Mazo.Mazo;
import edu.fiuba.algo3.modelo.SetUpPartida;
import edu.fiuba.algo3.vistas.RepartoView;
import edu.fiuba.algo3.vistas.SetupView;
import javafx.stage.Stage;

public class SetupController {

    private final Stage stage;
    private final SetupView view;

    public SetupController(Stage stage, SetupView view) {
        this.stage = stage;
        this.view = view;

        view.getBotonIniciar().setOnAction(e -> iniciarPartida());
    }

    private void iniciarPartida() {

        int cantidad = view.getCantidadJugadores();
        Mazo mazo = new Mazo(cantidad);
        SetUpPartida setup = new SetUpPartida(mazo);
        Jugadores jugadores = setup.ejecutar();

        RepartoView repartoView = new RepartoView();
        new RepartoController(stage, repartoView, jugadores);
    }
}