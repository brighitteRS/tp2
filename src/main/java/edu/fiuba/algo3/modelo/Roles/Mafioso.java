package edu.fiuba.algo3.modelo.Roles;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.NullPattern.BandoNulo;
import edu.fiuba.algo3.modelo.NullPattern.JugadorNulo;

public class Mafioso extends Rol {

    private Jugador victimaElegida = new JugadorNulo();

    public Mafioso() {
        super(BandoMafia.INSTANCIA);
    }


    @Override
    public Bando revelarBandoA(Jugador solicitante) {

        if (solicitante.esDeLaMafia()) {
            return revelarBando();}

        return BandoNulo.INSTANCIA;
    }

    @Override
    protected void ejecutoEleccion(Jugador objetivo) {
        if (objetivo.esDeLaMafia()) {
            throw new IllegalArgumentException();
        }
        victimaElegida = objetivo;
    }

    @Override
    public Jugador obtenerVictima() {
        return victimaElegida;
    }
}