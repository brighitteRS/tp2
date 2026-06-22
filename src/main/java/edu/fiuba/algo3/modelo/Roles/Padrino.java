package edu.fiuba.algo3.modelo.Roles;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.NullPattern.BandoNulo;

public class Padrino extends Rol {
    public Padrino() {
        super(BandoMafia.INSTANCIA);
    }

    //para que los mafiosos se conozcan
    @Override
    public Bando revelarBandoA(Jugador solicitante) {

        if (solicitante.esDeLaMafia()) {
            return revelarBando();}

        return BandoNulo.INSTANCIA;
    }

    //para el investigador
    @Override
    public Bando revelarBandoParaInvestigacion() {return BandoCiudadano.INSTANCIA;}

    @Override
    protected void ejecutoEleccion(Jugador objetivo) {
    }
}
