package edu.fiuba.algo3.modelo.Jugador;

public interface EstadoJugador {

    boolean estaVivo();

    void validarPuedeActuar();

    void validarPuedeSerObjetivo();

}