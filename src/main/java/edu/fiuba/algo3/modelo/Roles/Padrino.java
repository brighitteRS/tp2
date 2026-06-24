package edu.fiuba.algo3.modelo.Roles;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Jugador.Jugador;

public class Padrino extends MiembroDeLaMafia {

    @Override
    public Bando revelarBandoInvestigado() {
        return BandoCiudadano.INSTANCIA;
    }

    @Override
    public Jugador votoPrioritario() {
        return victimaElegida();
    }
}