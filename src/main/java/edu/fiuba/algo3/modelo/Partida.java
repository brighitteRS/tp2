package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.CondicionesVictoria.*;
import edu.fiuba.algo3.modelo.NullPattern.BandoNulo;

import java.util.ArrayList;
import java.util.List;


public class Partida {

    private final Jugadores jugadores;
    private final EstrategiaVictoria estrategia;
    private final List<Ronda> historial = new ArrayList<>();

    private Fase faseActual;
    private Ronda rondaActual;

    public Partida(
            Jugadores jugadores,
            EstrategiaVictoria estrategia,
            Fase faseInicial) {

        this.jugadores = jugadores;
        this.estrategia = estrategia;
        this.faseActual = faseInicial;
        this.rondaActual = new Ronda(1); //ver dps si no es dato primitivo
    }

    public void ejecutar() {

        faseActual.ejecutar(jugadores,rondaActual);

        Bando ganador = estrategia.resolver(jugadores);

        if (!ganador.equals(BandoNulo.INSTANCIA)) {
            jugadores.revelarTodasLasCartas();
        }

        Ronda nuevaRonda = faseActual.actualizar(rondaActual);

        if (nuevaRonda != rondaActual) {
            historial.add(rondaActual);
        }

        rondaActual = nuevaRonda;
        faseActual = faseActual.siguiente();
    }

    public Jugadores obtenerJugadores() {
        return jugadores;
    }

    public Ronda obtenerRondaActual() {
        return rondaActual;
    }

    public Fase obtenerFaseActual() {
        return faseActual;
    }

    public Bando obtenerGanador() {
        return estrategia.resolver(jugadores);
    }

    public boolean termino() {
        return !obtenerGanador().equals(BandoNulo.INSTANCIA);
    }
}