package edu.fiuba.algo3.modelo.Roles;

import edu.fiuba.algo3.modelo.*;

public class Padrino extends Mafioso {

    @Override
    public Bando revelarBandoInvestigado() {
        return BandoCiudadano.INSTANCIA;
    }

    @Override
    public Jugador votoPrioritario() {
        return obtenerVictima();
    }
}
