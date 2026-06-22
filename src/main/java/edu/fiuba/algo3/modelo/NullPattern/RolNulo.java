package edu.fiuba.algo3.modelo.NullPattern;

import edu.fiuba.algo3.modelo.*;

public class RolNulo extends Rol {

    public static final RolNulo INSTANCIA = new RolNulo();

    private RolNulo() {
        super(BandoNulo.INSTANCIA);
    }

    @Override
    public Bando revelarBandoA(Jugador solicitante) {
        return BandoNulo.INSTANCIA;
    }

    @Override
    protected void ejecutoEleccion(Jugador objetivo) {
    }
}