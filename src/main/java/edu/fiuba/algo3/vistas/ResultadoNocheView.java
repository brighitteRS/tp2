package edu.fiuba.algo3.vistas;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class ResultadoNocheView {

    private Button continuar;

    public Scene crearEscena(String mensajeResultado) {
        Label titulo = new Label("Ya amanecio");
        Label mensaje = new Label(mensajeResultado);

        continuar = new Button("Continuar");

        VBox layout = new VBox(10, titulo, mensaje, continuar);
        return new Scene(layout, 640, 480);
    }

    public Button getBotonContinuar() { return continuar; }
}