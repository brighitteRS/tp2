package edu.fiuba.algo3.modelo.NullPattern;

import edu.fiuba.algo3.modelo.*;

public class RolNulo extends Rol {

    public RolNulo() {
        super(BandoNulo.INSTANCIA);
    }

    @Override
    public Bando revelarBandoA(Jugador solicitante) {
        return BandoNulo.INSTANCIA;
    }

    @Override
    protected void ejecutoEleccion(Jugador objetivo) {
        // no hace nada
    }
}