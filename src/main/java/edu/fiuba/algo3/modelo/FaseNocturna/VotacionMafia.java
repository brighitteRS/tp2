package edu.fiuba.algo3.modelo.FaseNocturna;

import edu.fiuba.algo3.modelo.*;

import java.util.ArrayList;
import java.util.List;

public class VotacionMafia {

    private final List<Voto> votos = new ArrayList<>();
    private final ContadorVotos contador;

    public VotacionMafia(ContadorVotos contador) {
        this.contador = contador;
    }

    public void registrarVoto(Jugador jugador) {

        for (Voto voto : votos) {
            if (voto.obtenerCandidato().equals(jugador)) {
                voto.sumar();
                return;
            }
        }
        Voto voto = new Voto(jugador);
        votos.add(voto);
    }

    public Jugador obtenerGanador() {

        if (contador.hayEmpate(votos)) {
            return null;
        }

        return contador.obtenerGanador(votos);
    }
}