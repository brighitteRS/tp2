package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.FaseNocturna.ResultadoNocturno;
import edu.fiuba.algo3.modelo.NullPattern.JugadorNulo;

public class Muerto implements EstadoJugador {

    @Override
    public void actuarDeNoche(Rol rol, ResultadoNocturno resultado) {
    }

    @Override
    public boolean estaVivo() {
        return false;
    }

    @Override
    public Jugador obtenerVictima(Rol rol) {
        return JugadorNulo.INSTANCIA;
    }

    @Override
    public void ejecutarEleccion(Rol rol, Jugador objetivo) {
        throw new IllegalStateException();
    }

    @Override
    public Bando consultarBando(Rol rol, Jugador propietario, Jugador solicitante) {
        return rol.revelarBando();
    }

    @Override
    public Rol consultarRol(Rol rol, Jugador propietario, Jugador solicitante) {
        return rol;
    }

    @Override
    public void validarPuedeSerVictimaDeMafia(Rol rol) {
        throw new IllegalArgumentException();
    }
}