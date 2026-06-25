package edu.fiuba.algo3.vistas;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class ReconocimientoMafiaView {

    private Label mensaje;
    private Label complices;
    private Button ver;
    private Button listo;

    public Scene crearEscena(int numeroJugador) {
        mensaje = new Label("Jugador " + numeroJugador + ", sos Mafioso.");
        complices = new Label("");
        ver = new Button("Ver complices");
        listo = new Button("Listo");
        listo.setVisible(false);

        VBox layout = new VBox(10, mensaje, ver, complices, listo);
        return new Scene(layout, 640, 480);
    }

    public void mostrarComplices(String texto) {
        complices.setText(texto);
        ver.setVisible(false);
        listo.setVisible(true);
    }

    public Button getBotonVer() { return ver; }
    public Button getBotonListo() { return listo; }
}