package edu.fiuba.algo3.modelo;

public class Voto {

    private final Jugador candidato;
    private int cantidad;

    public Voto(Jugador candidato) {
        this.candidato = candidato;
        this.cantidad = 1;
    }

    public void sumar() {
        this.cantidad++;
    }

    public Jugador obtenerCandidato() {
        return candidato;
    }

    public int obtenerCantidad() {
        return cantidad;
    }
}