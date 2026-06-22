package edu.fiuba.algo3.modelo.FaseNocturna;

import edu.fiuba.algo3.modelo.Jugador;

import java.util.List;

public class FaseNocturna {

    private final List<Jugador> jugadoresNocturnos;

    public FaseNocturna(List<Jugador> jugadoresNocturnos) {
        this.jugadoresNocturnos = jugadoresNocturnos;
    }

    public void ejecutar() {

        ResultadoNocturno resultado = new ResultadoNocturno();
        Mafia mafia = new Mafia(jugadoresNocturnos);

        mafia.actuarDeNoche(resultado);

        jugadoresNocturnos.forEach(
                jugador -> jugador.actuarDeNoche(resultado)
        );

        resultado.resolver();
    }
}