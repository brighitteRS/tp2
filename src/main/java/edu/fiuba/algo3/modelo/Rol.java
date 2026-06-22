package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.FaseNocturna.ResultadoNocturno;
import edu.fiuba.algo3.modelo.NullPattern.*;

public abstract class Rol {
    private final Bando bando;

    public Rol(Bando bando) {
        this.bando = bando;
    }

    public Bando revelarBando() {
        return bando;
    }

    public abstract Bando revelarBandoA(Jugador solicitante);

    public void actuarDeNoche(ResultadoNocturno resultado) {
    }

    public void elegir(Jugador objetivo) {
        ejecutoEleccion(objetivo);
    }

    protected abstract void ejecutoEleccion(Jugador objetivo);

    public Jugador obtenerVictima() {
        return JugadorNulo.INSTANCIA;
    }

    public Bando obtenerResultado() {
        return BandoNulo.INSTANCIA;
    }

    public void validarPuedeSerVictimaDeMafia() {
    }
}