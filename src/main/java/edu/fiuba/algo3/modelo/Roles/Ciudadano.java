package edu.fiuba.algo3.modelo.Roles;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Jugador.Rol;

public class Ciudadano extends Rol {
    public Ciudadano() {
        super(BandoCiudadano.INSTANCIA);
    }

    @Override
    public Bando revelarBandoA(Jugador solicitante) {
        return revelarBando();
    }

    @Override
    public void elegir (Jugador objetivo) {
    }
}
