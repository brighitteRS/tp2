package edu.fiuba.algo3.modelo.Jugador;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.FaseNocturna.ResultadoNocturno;
import edu.fiuba.algo3.modelo.NullPattern.*;
import edu.fiuba.algo3.modelo.Urna.Urna;

import java.util.List;

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
        elegirObjetivo(objetivo); //probar cuando lo borro
    }

    public void validarPuedeSerVictimaDeMafia() {
    }

    public void votar(Jugador self, Urna urna) {}

    protected abstract void elegirObjetivo(Jugador objetivo);

    protected Bando obtenerResultado() {
        return BandoNulo.INSTANCIA;
    }

    protected Jugador votoPrioritario() {
        return JugadorNulo.INSTANCIA;
    }

    public void registrarseEnMafia(Jugador self, RegistroMafia registro) {
    }

    public void recibirComplices(Jugador self, List<Jugador> mafiosos) {
    }
}