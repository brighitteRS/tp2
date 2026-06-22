package edu.fiuba.algo3.modelo;

import java.util.List;
import java.util.stream.Collectors;

public class Partida {
    private List<Jugador> jugadores;

    public Partida(List<Jugador> jugadores) {
        this.jugadores = jugadores;
        reconocerMafiosos();
    }

    private void reconocerMafiosos() {

        List<Jugador> mafiosos = jugadores.stream()
                .filter(j -> j.consultarBando(j) == BandoMafia.INSTANCIA)
                .collect(Collectors.toList());

        for (Jugador mafioso : mafiosos) {
            mafioso.reconocerComplices(mafiosos);
        }
    }
}

