package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.FaseNocturna.ResultadoNocturno;
import edu.fiuba.algo3.modelo.Jugador.Jugador;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Jugadores {

    private final List<Jugador> jugadores;

    public Jugadores(List<Jugador> jugadores) {
        this.jugadores = new ArrayList<>(jugadores);
    }

    public List<Jugador> vivos() {
        return jugadores.stream()
                .filter(Jugador::estaVivo)
                .collect(Collectors.toList());
    }

    public long mafiososVivos() {
        return vivos().stream()
                .filter(j -> j.perteneceA(BandoMafia.INSTANCIA))
                .count();
    }

    public long ciudadanosVivos() {
        return vivos().stream()
                .filter(j -> j.perteneceA(BandoCiudadano.INSTANCIA))
                .count();
    }

    public boolean hayEmpateOMafiaDomina() {
        return mafiososVivos() >= ciudadanosVivos();
    }

    public boolean noQuedanMafiosos() {
        return mafiososVivos() == 0;
    }

    public boolean unicoMafioso() {
        return vivos().size() == 1 &&
                mafiososVivos() == 1;
    }

    public boolean unicoCiudadano() {
        return vivos().size() == 1 &&
                ciudadanosVivos() == 1;
    }

    public void revelarTodasLasCartas() {
        for (Jugador jugador : jugadores) {
            jugador.revelarCarta();
        }
    }
    public List<Jugador> todosLosJugadores() {
        return new ArrayList<>(jugadores);
    }
}