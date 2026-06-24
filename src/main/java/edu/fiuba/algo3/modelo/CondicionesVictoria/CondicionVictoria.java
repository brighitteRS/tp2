package edu.fiuba.algo3.modelo.CondicionesVictoria;

import edu.fiuba.algo3.modelo.Bando;
import edu.fiuba.algo3.modelo.Jugadores;

public interface CondicionVictoria {
    Bando evaluar(Jugadores jugadores);
}