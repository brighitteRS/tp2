package edu.fiuba.algo3.modelo.Roles;

import edu.fiuba.algo3.modelo.*;

public class Ciudadano extends Rol {
    public Ciudadano() {
        super(BandoCiudadano.INSTANCIA);
    }

    @Override
    public Bando revelarBandoA(Jugador solicitante) {
        return revelarBando();
    }

    @Override
    protected void ejecutoEleccion(Jugador objetivo) {
    }
}
