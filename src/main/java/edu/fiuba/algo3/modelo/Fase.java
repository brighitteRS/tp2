package edu.fiuba.algo3.modelo;

public interface Fase {

    void ejecutar(Jugadores jugadores,Ronda ronda);

    Fase siguiente();

    Ronda actualizar(Ronda ronda);
}