package edu.fiuba.algo3.modelo.CondicionesVictoria;

import edu.fiuba.algo3.modelo.Bando;
import edu.fiuba.algo3.modelo.Jugadores;
import edu.fiuba.algo3.modelo.NullPattern.BandoNulo;

import java.util.List;

public class EstrategiaMafiaCiudadanos implements EstrategiaVictoria {

    private final List<CondicionVictoria> condiciones;

    public EstrategiaMafiaCiudadanos(List<CondicionVictoria> condiciones) {
        this.condiciones = condiciones;
    }

    @Override
    public Bando resolver(Jugadores jugadores) {

        for (CondicionVictoria c : condiciones) {

            Bando resultado = c.evaluar(jugadores);

            if (!resultado.equals(BandoNulo.INSTANCIA)) {
                return resultado;
            }
        }

        return BandoNulo.INSTANCIA;
    }
}