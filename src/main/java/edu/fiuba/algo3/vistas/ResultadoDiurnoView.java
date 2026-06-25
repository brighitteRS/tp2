package edu.fiuba.algo3.vistas;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class ResultadoDiurnoView {

    private Button continuar;

    public Scene crearEscena(String mensajeEliminado, String textoContinuar) {
        Label titulo = new Label("Resultado de la votacion");
        Label mensaje = new Label(mensajeEliminado);

        continuar = new Button(textoContinuar);

        VBox layout = new VBox(10, titulo, mensaje, continuar);
        return new Scene(layout, 640, 480);
    }

    public Scene crearEscenaFin(String mensajeFin) {
        Label fin = new Label(mensajeFin);
        VBox layout = new VBox(10, fin);
        return new Scene(layout, 640, 480);
    }

    public Button getBotonContinuar() { return continuar; }
}