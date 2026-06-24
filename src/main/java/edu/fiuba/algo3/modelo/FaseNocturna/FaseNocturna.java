package edu.fiuba.algo3.modelo.FaseNocturna;

import edu.fiuba.algo3.modelo.Jugadores;
import edu.fiuba.algo3.modelo.*;

public class FaseNocturna implements Fase {

    @Override
    public void ejecutar(Jugadores jugadores) {

        ResultadoNocturno resultado = new ResultadoNocturno();
        Mafia mafia = new Mafia(jugadores.vivos());

        mafia.actuarDeNoche(resultado);

        jugadores.vivos().forEach(
                jugador -> jugador.actuarDeNoche(resultado)
        );

        resultado.resolver();
    }

    @Override
    public Fase siguiente() {
        return new FaseDiurna();
    }

    @Override
    public Ronda actualizar(Ronda ronda) {
        return ronda;
    }
}