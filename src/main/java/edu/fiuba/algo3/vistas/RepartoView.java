package edu.fiuba.algo3.vistas;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class RepartoView {

    private Label mensaje;
    private Label rol;
    private Button verCarta;
    private Button listo;

    public Scene crearEscena(int turno) {
        mensaje = new Label("Jugador " + (turno + 1) + ", es tu turno.");
        rol = new Label("");
        verCarta = new Button("Ver carta");
        listo = new Button("Listo");
        listo.setVisible(false);

        VBox layout = new VBox(10, mensaje, rol, verCarta, listo);
        return new Scene(layout, 640, 480);
    }

    public void mostrarRol(String nombreRol) {
        rol.setText("Tu rol es: " + nombreRol);
        verCarta.setVisible(false);
        listo.setVisible(true);
    }

    public Button getBotonVerCarta() { return verCarta; }
    public Button getBotonListo() { return listo; }
}