package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.FaseNocturna.ResultadoNocturno;
import edu.fiuba.algo3.modelo.Urna.Urna;

public class Jugador {

    private final Rol rol;
    private EstadoJugador estado;

    public Jugador(Rol rol) {
        this.rol = rol;
        this.estado = new Vivo();
    }

    public boolean estaVivo() {
        return estado.estaVivo();
    }

    public void eliminar() {
        this.estado = new Muerto();
    }

    public Bando consultarBando(Jugador solicitante) {
        return estado.consultarBando(rol, this, solicitante);
    }

    public Rol consultarRol(Jugador solicitante) {
        return estado.consultarRol(rol, this, solicitante);
    }

    public void elegir(Jugador objetivo) {
        estado.ejecutarEleccion(rol, objetivo);
    }

    public void actuarDeNoche(ResultadoNocturno resultado) {
        estado.actuarDeNoche(rol, resultado);
    }

    public Bando resultadoInvestigacion() {
        return estado.obtenerResultadoInvestigacion(rol);
    }

    public Bando revelarBandoAInvestigacion() {
        return estado.revelarBandoInvestigado(rol);
    }

    public void guardarVotoNocturno(Urna urna) {
        estado.aplicarVoto(rol, this, urna);
    }

    public Jugador obtenerVotoPrioritario() {
        return estado.votoPrioritario(rol);
    }

    public void validarPuedeSerVictimaDeMafia() {
        estado.validarPuedeSerVictimaDeMafia(rol);
    }
}