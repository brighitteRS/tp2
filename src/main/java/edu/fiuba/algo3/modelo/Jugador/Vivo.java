package edu.fiuba.algo3.modelo.Jugador;

public class Vivo implements EstadoJugador {

    @Override
    public boolean estaVivo() {
        return true;
    }

    @Override
    public void validarPuedeActuar() {
    }

    public void validarPuedeSerObjetivo() {
    }
}