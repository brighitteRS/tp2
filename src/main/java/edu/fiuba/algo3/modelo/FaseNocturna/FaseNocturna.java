package edu.fiuba.algo3.modelo.FaseNocturna;

import edu.fiuba.algo3.modelo.Jugador;

import java.util.List;
public class FaseNocturna {

    private final Mafia mafia;
    private final List<Jugador> jugadoresNocturnos;

    public FaseNocturna(
            Mafia mafia,
            List<Jugador> jugadoresNocturnos) {

        this.mafia = mafia;
        this.jugadoresNocturnos = jugadoresNocturnos;
    }

    public void ejecutar() {

        mafia.actuarDeNoche();

        jugadoresNocturnos.forEach(
                Jugador::actuarDeNoche
        );
    }
}