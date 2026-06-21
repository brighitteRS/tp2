package edu.fiuba.algo3.modelo.FaseNocturna;

import edu.fiuba.algo3.modelo.Jugador;

import java.util.List;
public class FaseNocturna {

    private final List<Jugador> jugadoresNocturnos;

    public FaseNocturna(
            List<Jugador> jugadoresNocturnos) {

        this.jugadoresNocturnos = jugadoresNocturnos;
    }

    public void ejecutar() {
        Mafia mafia  = new Mafia();

        mafia.actuarDeNoche(jugadoresNocturnos);

        jugadoresNocturnos.forEach(
                Jugador::actuarDeNoche
        );
    }
}