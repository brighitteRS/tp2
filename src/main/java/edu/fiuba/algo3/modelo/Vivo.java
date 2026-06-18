package edu.fiuba.algo3.modelo;

import java.util.List;

public class Vivo implements EstadoJugador {

    @Override
    public void actuarDeNoche(Rol rol) {
        rol.actuarDeNoche();
    }

    @Override
    public boolean estaVivo() {
        return true;
    }
}