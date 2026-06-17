package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Mazo.Mazo;
import java.util.List;
import java.util.stream.Collectors;

public class Partida {
    private List<Jugador> jugadores;

    public Partida(List<Jugador> jugadores, Mazo mazo) {
        this.jugadores = jugadores;
        mazo.repartir(jugadores);
        reconocerMafiosos();
    }

    private void reconocerMafiosos() {
        List<Jugador> mafiosos = jugadores.stream()
                .filter(Jugador::esDeLaMafia)
                .collect(Collectors.toList());

        for (Jugador mafioso : mafiosos) {
            mafioso.reconocerComplices(mafiosos);
        }
    }
}