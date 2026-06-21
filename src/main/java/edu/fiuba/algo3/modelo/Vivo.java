package edu.fiuba.algo3.modelo;

public class Vivo implements EstadoJugador {
    @Override
    public boolean puedeInteractuarCon(Jugador objetivo) {
        return objetivo.estaVivo();
    }

    /*@Override
    public boolean puedeVerRol(Jugador objetivo) {
        return false;
    }*/

    @Override
    public void actuarDeNoche(Rol rol) {
        rol.actuarDeNoche();
    }

    @Override
    public boolean estaVivo() {
        return true;
    }

    @Override
    public void ejecutarEleccion(Rol rol, Jugador objetivo) {
        if (!puedeInteractuarCon(objetivo)) {
            throw new IllegalArgumentException();
        }

        rol.elegir(objetivo);
    }
}