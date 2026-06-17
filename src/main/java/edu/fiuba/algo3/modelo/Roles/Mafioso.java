package edu.fiuba.algo3.modelo.Roles;

import edu.fiuba.algo3.modelo.*;

public class Mafioso extends Rol {

    private Jugador victimaElegida;

    public Mafioso() {
        super(new BandoMafia());
    }

    public void elegirVictima(Jugador jugador) {
        validarVictima(jugador);
        this.victimaElegida = jugador;
    }

    private void validarVictima(Jugador jugador) {
        if (jugador == null) {
            throw new IllegalArgumentException();
        }

        if (!jugador.estaVivo() || jugador.esDeLaMafia()) {
            throw new IllegalArgumentException();
        }
    }

    public Jugador obtenerVictima() {
        return victimaElegida;
    }

    @Override
    public Bando revelarBandoA(Jugador solicitante) {
        return revelarBando();
    }
}