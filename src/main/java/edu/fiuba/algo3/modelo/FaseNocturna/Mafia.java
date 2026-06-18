package edu.fiuba.algo3.modelo.FaseNocturna;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Roles.Mafioso;
import edu.fiuba.algo3.modelo.Urna.Urna;

import java.util.List;

public class Mafia {

    private final Urna urna = new Urna();
    public void recolectarVotos(List<Mafioso> mafiosos) {

        if (mafiosos == null || mafiosos.isEmpty()) {
            throw new IllegalArgumentException();
        }

        for (Mafioso mafioso : mafiosos) {

            Jugador victima = mafioso.obtenerVictima();

            if (victima == null) {
                throw new IllegalStateException();
            }

            urna.agregarCandidato(victima);
            urna.registrarVoto(null, victima);
        }
    }

    public Jugador resolverVictima() {

        List<Jugador> ganadores = urna.getGanadores();

        if (ganadores.size() > 1) {
            return null;
        }

        return ganadores.get(0);
    }

    public void actuarDeNoche() {

        Jugador victima = resolverVictima();

        if (victima != null) {
            victima.cambiarEstado(new Muerto());
        }
    }
}