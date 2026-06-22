package edu.fiuba.algo3.modelo.Roles;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.NullPattern.BandoNulo;

public class Sheriff extends Rol {

    public Sheriff() {super(BandoCiudadano.INSTANCIA);}

    @Override
    protected void ejecutoEleccion(Jugador objetivo) {
    }

    @Override
    public Bando revelarBandoA(Jugador solicitante) {
        return BandoNulo.INSTANCIA; //por ahora esta asi pero verlo
    }
}