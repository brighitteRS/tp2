package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.FaseNocturna.ResultadoNocturno;

public interface EstadoJugador {

    boolean estaVivo();

    void actuarDeNoche(Rol rol, ResultadoNocturno resultado);

    void ejecutarEleccion(Rol rol, Jugador objetivo);

    Jugador obtenerVictima(Rol rol);

    Bando consultarBando(Rol rol, Jugador propietario, Jugador solicitante);

    Rol consultarRol(Rol rol, Jugador propietario, Jugador solicitante);

    void validarPuedeSerVictimaDeMafia(Rol rol);
}