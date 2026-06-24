package edu.fiuba.algo3.modelo.Jugador;

import edu.fiuba.algo3.modelo.Bando;

public class CartaRevelada implements EstadoCarta {

    @Override
    public Rol consultarRol(Rol rol, Jugador propietario, Jugador solicitante) {
        return rol;
    }

    @Override
    public Bando consultarBando(Rol rol, Jugador propietario, Jugador solicitante) {
        return rol.revelarBando();
    }
}