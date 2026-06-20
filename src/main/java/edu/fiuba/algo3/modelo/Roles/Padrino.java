package edu.fiuba.algo3.modelo.Roles;

import edu.fiuba.algo3.modelo.*;

public class Padrino extends Rol {
    public Padrino() {
        super(BandoMafia.INSTANCIA);
    }

    @Override
    public Bando revelarBandoA(Jugador solicitante) {
        return BandoCiudadano.INSTANCIA;
    }
    @Override
    protected void ejecutoEleccion(Jugador objetivo) {
    }
}
