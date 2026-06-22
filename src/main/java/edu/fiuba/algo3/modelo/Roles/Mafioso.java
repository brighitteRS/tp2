package edu.fiuba.algo3.modelo.Roles;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.NullPattern.JugadorNulo;
import edu.fiuba.algo3.modelo.Urna.Urna;

public class Mafioso extends Rol {

    private Jugador victimaElegida = JugadorNulo.INSTANCIA;

    public Mafioso() {
        super(BandoMafia.INSTANCIA);
    }

    @Override
    public Bando revelarBandoA(Jugador solicitante) {
        return revelarBando();
    }

    protected void ejecutoEleccion(Jugador objetivo) {
        objetivo.validarPuedeSerVictimaDeMafia();
        victimaElegida = objetivo;
    }

    @Override
    public void votar(Jugador self, Urna urna) {
        urna.registrarVoto(self, victimaElegida);
    }

    @Override
    public Jugador obtenerVictima() {
        return victimaElegida;
    }

    @Override
    public void validarPuedeSerVictimaDeMafia() {
        throw new IllegalArgumentException();
    }
}