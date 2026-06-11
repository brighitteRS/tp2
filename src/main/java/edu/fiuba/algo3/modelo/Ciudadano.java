package edu.fiuba.algo3.modelo;

public class Ciudadano extends Rol {
    public Ciudadano() {
        super(new BandoCiudadano());
    }

    @Override
    public Bando revelarBandoA(Jugador Solicitante) {
        return null;
    }
}
