package edu.fiuba.algo3.modelo.CondicionesVictoria;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.NullPattern.BandoNulo;

public class MafiaGana implements CondicionVictoria {

    public Bando evaluar(Jugadores jugadores) {

        return jugadores.hayEmpateOMafiaDomina()
                ? BandoMafia.INSTANCIA
                : BandoNulo.INSTANCIA;
    }
}