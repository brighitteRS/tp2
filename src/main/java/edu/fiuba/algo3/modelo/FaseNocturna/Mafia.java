package edu.fiuba.algo3.modelo.FaseNocturna;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Roles.Mafioso;

import java.util.List;

public class Mafia {

    private final VotacionMafia votacion = new VotacionMafia(new ContadorVotos());

    public void recolectarVotos(List<Mafioso> mafiosos) {

        if (mafiosos == null || mafiosos.isEmpty()) {
            throw new IllegalArgumentException();
        }

        for (Mafioso mafioso : mafiosos) {

            Jugador voto = mafioso.obtenerVictima();

            if (voto == null) {
                throw new IllegalStateException();
            }

            votacion.registrarVoto(voto);
        }
    }

    public Jugador resolverVictima() {
        return votacion.obtenerGanador();
    }

    public void actuarDeNoche() {

        Jugador victima = resolverVictima();

        if (victima != null) {
            victima.cambiarEstado(new Muerto());
        }
    }
}