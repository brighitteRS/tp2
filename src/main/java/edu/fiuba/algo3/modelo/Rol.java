package edu.fiuba.algo3.modelo;


import edu.fiuba.algo3.modelo.NullPattern.BandoNulo;
import edu.fiuba.algo3.modelo.NullPattern.JugadorNulo;

public abstract class Rol {
    private final Bando bando;

    public Rol(Bando bando) {
        this.bando = bando;
    }

    public Bando revelarBando() {
        return bando;
    }

    public abstract Bando revelarBandoA(Jugador solicitante);

    public boolean esDeLaMafia() {
        return bando.esMafia();
    }

    public void actuarDeNoche() {
    }

    public void elegir(Jugador objetivo) {
        ejecutoEleccion(objetivo);
    }

    protected abstract void ejecutoEleccion(Jugador objetivo);

    public Jugador obtenerVictima() {
        return new JugadorNulo();
    }

    public Bando obtenerResultado() {
        return BandoNulo.INSTANCIA;
    }
}