package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.FaseNocturna.ResultadoNocturno;
import edu.fiuba.algo3.modelo.NullPattern.*;
import edu.fiuba.algo3.modelo.Urna.Urna;

public abstract class Rol {
    private final Bando bando;

    public Rol(Bando bando) {
        this.bando = bando;
    }

    public Bando revelarBando() {
        return bando;
    }

    public abstract Bando revelarBandoA(Jugador solicitante);

    public Bando revelarBandoInvestigado() {
        return revelarBando();
    }

    public void actuarDeNoche(ResultadoNocturno resultado) {
    }

    public void elegir(Jugador objetivo) {
        ejecutoEleccion(objetivo);
    }

    public void validarPuedeSerVictimaDeMafia() {
    }

    public void votar(Jugador self, Urna urna) {}

    protected abstract void ejecutoEleccion(Jugador objetivo);

    protected Jugador obtenerVictima() {
        return JugadorNulo.INSTANCIA;
    }

    protected Bando obtenerResultado() {
        return BandoNulo.INSTANCIA;
    }

    protected Jugador votoPrioritario() {
        return JugadorNulo.INSTANCIA;
    }
}