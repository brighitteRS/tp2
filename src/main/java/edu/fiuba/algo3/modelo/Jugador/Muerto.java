package edu.fiuba.algo3.modelo.Jugador;

public class Muerto implements EstadoJugador {

    @Override
    public boolean estaVivo() {
        return false;
    }

    //mejorar el tema de las excepciones como en el tp1
    @Override
    public void validarPuedeActuar() {
        throw new IllegalStateException();
    }

    public void validarPuedeSerObjetivo() {
        throw new IllegalArgumentException();
    }
}