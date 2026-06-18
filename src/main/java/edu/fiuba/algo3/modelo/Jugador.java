package edu.fiuba.algo3.modelo;

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

    public Bando consultarBando(Jugador solicitante) {
        return rol.revelarBandoA(solicitante);
    }

    public Rol consultarRol(Jugador solicitante) {
        if (solicitante.estaVivo()) {
            //salta excepcion
            return null;
        }
        return solicitante.getRol();
    }

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

    public void votar(Urna urna, Jugador votado) {
        if ( this.estaVivo() ) {
            urna.registrarVoto(this, votado);
        }
    }

    public void nominar(Urna urna, Jugador jugadorANominar) {
        if ( this.estaVivo() ) {
            urna.agregarCandidato(jugadorANominar);
        }
    }
}
