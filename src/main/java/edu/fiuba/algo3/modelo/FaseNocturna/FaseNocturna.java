package edu.fiuba.algo3.modelo.FaseNocturna;

import edu.fiuba.algo3.modelo.FaseDiurna.FaseDiurna;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Jugadores;
import edu.fiuba.algo3.modelo.*;

import java.util.List;

public class FaseNocturna implements Fase {

    @Override
    public void ejecutar(Jugadores jugadores) {

        ResultadoNocturno resultado = new ResultadoNocturno();
        List<Jugador> listaJugadores = jugadores.todosLosJugadores();

        Mafia mafia = new Mafia(listaJugadores);
        mafia.actuarDeNoche(resultado);

        for (Jugador jugador : listaJugadores) {
            jugador.actuarComoDetective(resultado);
        }

        for (Jugador jugador : listaJugadores) {
            jugador.actuarComoMedico(resultado);
        }

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