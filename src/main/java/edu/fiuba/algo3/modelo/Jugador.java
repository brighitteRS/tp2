package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.NullPattern.RolNulo;

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
        if (solicitante == this || !estaVivo()) {
            return rol.revelarBando();
        }
        return rol.revelarBandoA(solicitante);
    }

    public Bando revelarBandoReal() {
        return rol.revelarBandoParaInvestigacion();
    }

    public Rol consultarRol(Jugador solicitante) {
        if (solicitante == this || !estaVivo()) {
            return rol;
        }
        return new RolNulo();
    }

    //usar consultar rol (preguntar a ignacio cualquier cosa)

    /*public boolean puedeVerRol(Jugador objetivo) {
        return estado.puedeVerRol(objetivo);
    }*/

    public Rol getRol() {
        return rol;
    }

    public void cambiarEstado(EstadoJugador nuevoEstado) {
        this.estado = nuevoEstado;
    }

    public boolean esDeLaMafia() {
        return rol.esDeLaMafia();
    }

    public void actuarDeNoche() {
        estado.actuarDeNoche(rol);
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

    public void elegir(Jugador objetivo){
        estado.ejecutarEleccion(rol,objetivo);
    }

    public Jugador obtenerVictima() {
        return rol.obtenerVictima();
    }

    public Bando resultadoInvestigacion() {
        return rol.obtenerResultado();
    }

    public boolean estaNulo() {
        return false;
    }
}