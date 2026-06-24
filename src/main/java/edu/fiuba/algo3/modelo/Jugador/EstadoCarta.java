package edu.fiuba.algo3.modelo.Jugador;

import edu.fiuba.algo3.modelo.Bando;

public interface EstadoCarta {

    Rol consultarRol(Rol rol, Jugador propietario, Jugador solicitante);

    Bando consultarBando(Rol rol, Jugador propietario, Jugador solicitante);
}