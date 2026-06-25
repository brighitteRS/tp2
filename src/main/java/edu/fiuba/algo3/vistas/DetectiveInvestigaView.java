package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.modelo.Bando;
import edu.fiuba.algo3.modelo.BandoCiudadano;
import edu.fiuba.algo3.modelo.BandoMafia;
import edu.fiuba.algo3.modelo.Jugadores;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Roles.Detective;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class DetectiveInvestigaView {

    private final Stage stage;
    private final Jugadores jugadores;

    public DetectiveInvestigaView(Stage stage, Jugadores jugadores) {
        this.stage = stage;
        this.jugadores = jugadores;
    }

    public Scene crearEscena() {
        Jugador detective = jugadores.vivos().stream()
                .filter(j -> j.consultarRol(j).getClass().getSimpleName().equals("Detective"))
                .findFirst()
                .orElse(null);

        if (detective == null) {

            MedicoProtegeView medico = new MedicoProtegeView(stage, jugadores);
            return medico.crearEscena();
        }

        int numDetective = jugadores.todosLosJugadores().indexOf(detective) + 1;

        Label titulo = new Label("Fase nocturna, el detective elige a quien investigar");
        Label instruccion = new Label("Jugador " + numDetective + ", selecciona a quien investigar:");

        ToggleGroup grupo = new ToggleGroup();
        VBox opciones = new VBox(5);

        for (Jugador j : jugadores.vivos()) {
            if (j != detective) {
                int num = jugadores.todosLosJugadores().indexOf(j) + 1;
                RadioButton rb = new RadioButton("Jugador " + num);
                rb.setToggleGroup(grupo);
                rb.setUserData(j);
                opciones.getChildren().add(rb);
            }
        }

        Button confirmar = new Button("Confirmar");

        Jugador detectiveFinal = detective;
        confirmar.setOnAction(e -> {
            if (grupo.getSelectedToggle() == null) return;
            Jugador investigado = (Jugador) grupo.getSelectedToggle().getUserData();
            try {
                detectiveFinal.elegir(investigado);
            } catch (IllegalArgumentException ex) {
                Alert alerta = new Alert(Alert.AlertType.WARNING);
                alerta.setTitle("Investigacion invalida");
                alerta.setHeaderText(null);
                alerta.setContentText("Ya investigaste a ese jugador la noche anterior.");
                alerta.showAndWait();
                return;
            }

            Bando bando = investigado.revelarBandoAInvestigacion();
            String texto = bando.equals(BandoMafia.INSTANCIA) ? "Mafia" : "Ciudadano";

            Alert info = new Alert(Alert.AlertType.INFORMATION);
            info.setTitle("Resultado de la investigacion");
            info.setHeaderText(null);
            info.setContentText("Jugador " + numDetective + ", el jugador investigado pertenece a: " + texto);
            info.showAndWait();

            MedicoProtegeView medico = new MedicoProtegeView(stage, jugadores);
            stage.setScene(medico.crearEscena());
        });

        VBox layout = new VBox(10, titulo, instruccion, opciones, confirmar);
        return new Scene(layout, 640, 480);
    }
}