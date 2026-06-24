package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Mazo.Mazo;

import java.util.ArrayList;
import java.util.List;

public class SetUpPartida {

    private final Mazo mazo;

    public SetUpPartida(Mazo mazo) {
        this.mazo = mazo;
    }

    public Jugadores ejecutar() {

        mazo.mezclar();

        List<Jugador> jugadores = new ArrayList<>();
        RegistroMafia registro = new RegistroMafia();

        while (mazo.tieneCartas()) {

            Jugador jugador = new Jugador(mazo.sacarCarta());

            jugador.registrarseEnMafia(registro);

            jugadores.add(jugador);
        }

        registro.informarComplices();

        return new Jugadores(jugadores);
    }
}