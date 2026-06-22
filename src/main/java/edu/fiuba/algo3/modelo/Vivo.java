package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.FaseNocturna.ResultadoNocturno;
import edu.fiuba.algo3.modelo.NullPattern.RolNulo;

public class Vivo implements EstadoJugador {

    @Override
    public void actuarDeNoche(Rol rol, ResultadoNocturno resultado) {
        rol.actuarDeNoche(resultado);
    }

    @Override
    public boolean estaVivo() {
        return true;
    }

    @Override
    public void ejecutarEleccion(Rol rol, Jugador objetivo) {
        rol.elegir(objetivo);
    }

    @Override
    public Jugador obtenerVictima(Rol rol) {
        return rol.obtenerVictima();
    }

    @Override
    public Bando consultarBando(Rol rol, Jugador propietario, Jugador solicitante) {
        return rol.revelarBandoA(solicitante);
    }

    @Override
    public Rol consultarRol(Rol rol, Jugador propietario, Jugador solicitante) {

        if (solicitante == propietario) {
            return rol;
        }
        return RolNulo.INSTANCIA;
    }

    @Override
    public void validarPuedeSerVictimaDeMafia(Rol rol) {
        rol.validarPuedeSerVictimaDeMafia();
    }
}