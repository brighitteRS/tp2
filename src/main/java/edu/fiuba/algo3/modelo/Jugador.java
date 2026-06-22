package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.FaseNocturna.ResultadoNocturno;
import edu.fiuba.algo3.modelo.Urna.SistemaNominaciones;
import edu.fiuba.algo3.modelo.Urna.Urna;

import java.util.List;

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

    public Bando consultarBando(Jugador solicitante) {

        return estado.consultarBando(rol, this, solicitante);
    }

    public Rol consultarRol(Jugador solicitante) {

        return estado.consultarRol(rol, this, solicitante);
    }

    public void cambiarEstado(EstadoJugador nuevoEstado) {
        this.estado = nuevoEstado;
    }

    public void actuarDeNoche(ResultadoNocturno resultado) {
        estado.actuarDeNoche(rol,resultado);
    }

    public void elegir(Jugador objetivo) {
        estado.ejecutarEleccion(rol, objetivo);
    }

    public Jugador obtenerVictima() {
        return estado.obtenerVictima(rol);
    }

    public Bando resultadoInvestigacion() {
        return rol.obtenerResultado();
    }

    public boolean estaNulo() {
        return false;
    }

    public void validarPuedeSerVictimaDeMafia() {
        estado.validarPuedeSerVictimaDeMafia(rol);
    }


    public void reconocerComplices(List<Jugador> complices) {
        rol.reconocerComplices(complices);
    }

    /*
    public void votar(Urna urna, Jugador votado) {
        if ( !this.estaVivo() ) {
            throw new UnsupportedOperationException("Un jugador muerto no puede votar");
        }
        urna.registrarVoto(this, votado);
    }

    public void nominar(Urna urna, Jugador jugadorANominar) {
        if ( this.estaVivo() ) {
            urna.agregarCandidato(jugadorANominar);
        }
    }*/

    //usar consultar rol (preguntar a ignacio cualquier cosa)

    /*public boolean puedeVerRol(Jugador objetivo) {
        return estado.puedeVerRol(objetivo);
    }*/
}
