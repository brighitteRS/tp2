package edu.fiuba.algo3.modelo;

public class Muerto implements EstadoJugador {
    @Override
    public boolean puedeInteractuarCon(Jugador objetivo) {
        return false;
    }

    /*@Override
    public boolean puedeVerRol(Jugador objetivo) {
        //hay que revisarlo porque cuando muere pasaba algo
        return true;
    }*/
    @Override
    public void actuarDeNoche(Rol rol) {
    }

    @Override
    public boolean estaVivo() {
        return false;
    }

    @Override
    public void ejecutarEleccion(Rol rol, Jugador objetivo){
    }
}