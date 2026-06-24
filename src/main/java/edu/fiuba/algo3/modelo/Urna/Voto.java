package edu.fiuba.algo3.modelo.Urna;

import edu.fiuba.algo3.modelo.Jugador.Jugador;

public class Voto {

    private Jugador votador;
    private Jugador votado;

    public Voto(Jugador votador, Jugador votado) {
        this.votador = votador;
        this.votado = votado;
    }

    public Jugador obtenerVotado() {
        return this.votado;
    }

}
