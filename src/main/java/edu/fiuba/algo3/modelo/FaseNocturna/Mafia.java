package edu.fiuba.algo3.modelo.FaseNocturna;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.NullPattern.JugadorNulo;
import edu.fiuba.algo3.modelo.Urna.Urna;

import java.util.List;

public class Mafia {

    private final Urna urna = new Urna();

    public void actuarDeNoche(List<Jugador> jugadores) {

        recolectarVotos(jugadores);

        resolverResultado();
    }

    private void recolectarVotos(List<Jugador> jugadores) {

        for (Jugador jugador : jugadores) {

            Jugador victima = jugador.obtenerVictima();

            if (victima.estaNulo()) continue;

            urna.registrarVoto(jugador, victima);
        }
    }

    private void resolverResultado() {

        Jugador victima = obtenerResolucion();

        if (victima.estaNulo()) return;

        victima.cambiarEstado(new Muerto());
    }

    public Jugador obtenerResolucion() {

        List<Jugador> ganadores = urna.getGanadores();

        if (ganadores.size() != 1) {
            return new JugadorNulo();
        }

        return ganadores.get(0);
    }
}