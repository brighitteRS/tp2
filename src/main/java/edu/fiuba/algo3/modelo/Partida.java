package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.CondicionesVictoria.*;
import edu.fiuba.algo3.modelo.NullPattern.BandoNulo;


public class Partida {

    private final Jugadores jugadores;
    private final EstrategiaVictoria estrategia;

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

        faseActual.ejecutar(jugadores);

        Bando ganador = estrategia.resolver(jugadores);

        if (!ganador.equals(BandoNulo.INSTANCIA)) {
            jugadores.revelarTodasLasCartas();
        }

        rondaActual = faseActual.actualizar(rondaActual);

        faseActual = faseActual.siguiente();
    }
}