package edu.fiuba.algo3.modelo.CondicionesVictoria;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.NullPattern.BandoNulo;

public class UnicoCiudadano implements CondicionVictoria {

    public Bando evaluar(Jugadores jugadores) {

        return jugadores.unicoCiudadano()
                ? BandoCiudadano.INSTANCIA
                : BandoNulo.INSTANCIA;
    }
}
