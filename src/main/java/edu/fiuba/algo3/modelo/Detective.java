package edu.fiuba.algo3.modelo;

public class Detective extends Rol {
    public Detective() {
        super(new BandoCiudadano());
    }

    @Override
    public Bando revelarBandoA(Jugador Solicitante) {
        return null;
    }
}
