package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.FaseNocturna.ResultadoNocturno;
import edu.fiuba.algo3.modelo.NullPattern.RolNulo;
import edu.fiuba.algo3.modelo.Urna.Urna;

public class Vivo implements EstadoJugador {

    @Override
    public boolean estaVivo() {
        return true;
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
    public void actuarDeNoche(Rol rol, ResultadoNocturno resultado) {
        rol.actuarDeNoche(resultado);
    }

    @Override
    public void ejecutarEleccion(Rol rol, Jugador objetivo) {
        rol.elegir(objetivo);
    }

    @Override
    public Bando obtenerResultadoInvestigacion(Rol rol) {
        return rol.obtenerResultado();
    }

    @Override
    public Bando revelarBandoInvestigado(Rol rol) {
        return rol.revelarBandoInvestigado();
    }

    @Override
    public Jugador votoPrioritario(Rol rol) {
        return rol.votoPrioritario();
    }

    @Override
    public void aplicarVoto(Rol rol, Jugador self, Urna urna) {
        rol.votar(self, urna);
    }

    @Override
    public void validarPuedeSerVictimaDeMafia(Rol rol) {
        rol.validarPuedeSerVictimaDeMafia();
    }
}