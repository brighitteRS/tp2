package edu.fiuba.algo3.modelo.Jugador;

import edu.fiuba.algo3.modelo.Bando;
import edu.fiuba.algo3.modelo.NullPattern.RolNulo;

public class CartaOculta implements EstadoCarta {

    @Override
    public Rol consultarRol(Rol rol, Jugador propietario, Jugador solicitante) {

        if (propietario == solicitante) {
            return rol;
        }

        return RolNulo.INSTANCIA;
    }

    @Override
    public Bando consultarBando(Rol rol, Jugador propietario, Jugador solicitante) {

        return rol.revelarBandoA(solicitante);
    }
}
