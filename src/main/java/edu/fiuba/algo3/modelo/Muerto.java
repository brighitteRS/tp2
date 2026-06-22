package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.FaseNocturna.ResultadoNocturno;
import edu.fiuba.algo3.modelo.NullPattern.*;
import edu.fiuba.algo3.modelo.Urna.Urna;

public class Muerto implements EstadoJugador {

    @Override
    public boolean estaVivo() {
        return false;
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
    public void actuarDeNoche(Rol rol, ResultadoNocturno resultado) {
        throw new IllegalStateException();
    }

    @Override
    public void ejecutarEleccion(Rol rol, Jugador objetivo) {
        throw new IllegalStateException();
    }

    @Override
    public Bando obtenerResultadoInvestigacion(Rol rol) {
        return BandoNulo.INSTANCIA;
    }

    @Override
    public Bando revelarBandoInvestigado(Rol rol) {
        return BandoNulo.INSTANCIA;
    }

    @Override
    public Jugador votoPrioritario(Rol rol) {
        return JugadorNulo.INSTANCIA;
    }

    @Override
    public void aplicarVoto(Rol rol, Jugador self, Urna urna) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void validarPuedeSerVictimaDeMafia(Rol rol) {
        throw new IllegalArgumentException();
    }
}