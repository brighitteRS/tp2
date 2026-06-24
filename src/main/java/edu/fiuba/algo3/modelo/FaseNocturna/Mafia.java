package edu.fiuba.algo3.modelo.FaseNocturna;

import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.NullPattern.*;
import edu.fiuba.algo3.modelo.Urna.Urna;

import java.util.List;

public class Mafia {

    private final Urna urna = new Urna();
    private final List<Jugador> jugadores;

    public Mafia(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public void actuarDeNoche(ResultadoNocturno resultado) {

        recolectarVotos();
        resolverResultado(resultado);
    }

    private void recolectarVotos() {
        for (Jugador jugador : jugadores) {
            jugador.guardarVotoNocturno(urna);
        }
    }

    private void resolverResultado(ResultadoNocturno resultado) {
        resultado.registrarAtaque(obtenerResolucion());
    }

    public Jugador obtenerResolucion() {
        List<Jugador> ganadores = urna.getGanadores();

        if (ganadores.isEmpty()) {
            return JugadorNulo.INSTANCIA;
        }

        if (ganadores.size() == 1) {
            return ganadores.get(0);
        }

        return resolverEmpate(ganadores);
    }

    private Jugador resolverEmpate(List<Jugador> ganadores) {

        for (Jugador jugador : jugadores) {
            Jugador voto = jugador.obtenerVotoPrioritario();

            if (ganadores.contains(voto)) {
                return voto;
            }
        }

        return JugadorNulo.INSTANCIA;
    }
}