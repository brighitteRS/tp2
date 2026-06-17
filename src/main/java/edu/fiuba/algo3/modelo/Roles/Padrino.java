package edu.fiuba.algo3.modelo.Roles;

import edu.fiuba.algo3.modelo.*;

public class Padrino extends Rol {
    public Padrino() {
        super(new BandoMafia());
    }

    @Override
    public Bando revelarBandoA(Jugador solicitante) {
        return new BandoCiudadano();
    }
}
