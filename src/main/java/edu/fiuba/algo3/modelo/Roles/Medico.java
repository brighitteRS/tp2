package edu.fiuba.algo3.modelo.Roles;

import edu.fiuba.algo3.modelo.*;

public class Medico extends Rol {

    private Jugador ultimoProtegido;
    private Jugador protegido;

    public Medico() {
        super(new BandoCiudadano());
    }

    public void elegirProtegido(Jugador jugador) {
        validarProteccion(jugador);
        this.ultimoProtegido = jugador;
        this.protegido = jugador;
    }

    private void validarProteccion(Jugador jugador) {
        if (jugador == null) {
            throw new IllegalArgumentException();
        }

        if (!jugador.estaVivo() || jugador.equals(ultimoProtegido)) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Bando revelarBandoA(Jugador solicitante) {
        return revelarBando();
    }

    @Override
    public void actuarDeNoche() {

        if (protegido != null) {
            protegido.cambiarEstado(new Vivo());
        }
    }
}