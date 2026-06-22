package edu.fiuba.algo3.modelo.Roles;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.NullPattern.BandoNulo;
import edu.fiuba.algo3.modelo.NullPattern.JugadorNulo;

import java.util.ArrayList;
import java.util.List;

public class Mafioso extends Rol {

    private List<Jugador> complices = new ArrayList<>();
    private Jugador victimaElegida = JugadorNulo.INSTANCIA;

    public Mafioso() {
        super(BandoMafia.INSTANCIA);
    }

    //usarlo en partida (ver como implementarlo bien) preguntar a ignacio
    public void reconocerComplices(List<Jugador> complices) {
        this.complices = complices;
    }

    //usarlo para los test
    public boolean esComplice(Jugador jugador){
        return complices.contains(jugador);
    }

    @Override
    public Bando revelarBandoA(Jugador solicitante) {

        if (esComplice(solicitante)) {
            return revelarBando();}

        return BandoNulo.INSTANCIA;
    }

    @Override
    protected void ejecutoEleccion(Jugador objetivo) {
        if (esComplice(objetivo)) {
            throw new IllegalArgumentException();
        }
        victimaElegida = objetivo;
    }

    @Override
    public Jugador obtenerVictima() {
        return victimaElegida;
    }
}