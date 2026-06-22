package edu.fiuba.algo3.modelo.Roles;

import edu.fiuba.algo3.modelo.*;

public class Padrino extends Rol {
    public Padrino() {
        super(BandoMafia.INSTANCIA);
    }

    //para que los mafiosos se conozcan
    //Bri: Marque ese tema en el test que creaste, leelo y decime que opinas
    @Override
    public Bando revelarBandoA(Jugador solicitante) {
        return BandoCiudadano.INSTANCIA;
    }

    @Override
    protected void ejecutoEleccion(Jugador objetivo) {
    }

    @Override
    public void validarPuedeSerVictimaDeMafia() {
        throw new IllegalArgumentException();
    }
}
