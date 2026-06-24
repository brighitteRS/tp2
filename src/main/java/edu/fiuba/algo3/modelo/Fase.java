package edu.fiuba.algo3.modelo;

public interface Fase {

    void ejecutar(Jugadores jugadores);

    //Fase siguiente();

    Ronda actualizar(Ronda ronda);
}