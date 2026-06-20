package edu.fiuba.algo3.modelo;

public interface EstadoJugador {
    boolean puedeInteractuarCon(Jugador objetivo);
    boolean puedeVerRol(Jugador objetivo);
   boolean estaVivo();
   void actuarDeNoche(Rol rol);
   void ejecutarEleccion(Rol rol, Jugador objetivo);
}