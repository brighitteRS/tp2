package edu.fiuba.algo3.modelo.FaseNocturna;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.NullPattern.JugadorNulo;
import edu.fiuba.algo3.modelo.Urna.Urna;

import java.util.List;

public class Mafia {

    private final Urna urna = new Urna();

    public void actuarDeNoche(List<Jugador> jugadores, ResultadoNocturno resultado) {

        recolectarVotos(jugadores);

        resolverResultado(resultado);
    }

    private void recolectarVotos(List<Jugador> jugadores) {

        for (Jugador jugador : jugadores) {

            Jugador victima = jugador.obtenerVictima();

            if (victima.estaNulo()) continue;

            urna.registrarVoto(jugador, victima);
        }
    }

    private void resolverResultado(ResultadoNocturno resultado) {

        Jugador victima = obtenerResolucion();

        if (victima.estaNulo()) return;

        resultado.registrarAtaque(victima);
    }

    public Jugador obtenerResolucion() {

        List<Jugador> ganadores = urna.getGanadores();

        if (ganadores.size() != 1) {
            return JugadorNulo.INSTANCIA;
        }

        return ganadores.get(0);
    }
}