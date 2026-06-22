package edu.fiuba.algo3.modelo.Roles;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.NullPattern.BandoNulo;

public class Ciudadano extends Rol {
    public Ciudadano() {
        super(BandoCiudadano.INSTANCIA);
    }


    @Override
    public Bando revelarBandoA(Jugador solicitante) {
        return BandoNulo.INSTANCIA;
    }
    @Override
    protected void ejecutoEleccion(Jugador objetivo) {
    }
}
