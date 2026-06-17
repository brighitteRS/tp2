package edu.fiuba.algo3.modelo;

import java.util.List;

public class Muerto implements EstadoJugador {

    @Override
    public void actuarDeNoche(Rol rol) {
    }

    @Override
    public boolean estaVivo() {
        return false;
    }
}