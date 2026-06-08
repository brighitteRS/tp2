package edu.fiuba.algo3.modelo;

public abstract class Rol {
    private Bando bando;

    public Rol(Bando bando) {
        this.bando = bando;
    }

    public Bando revelarBando() {
        return bando;
    }

    public abstract Bando revelarBandoA(Jugador solicitante);

    public boolean esDeLaMafia() {
        return bando instanceof BandoMafia;
    }
}