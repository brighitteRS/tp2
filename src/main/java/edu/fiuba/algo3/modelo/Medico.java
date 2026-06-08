package edu.fiuba.algo3.modelo;

public class Medico extends Rol{
    public Medico() {
        super(new BandoCiudadano());
    }

    @Override
    public Bando revelarBandoA(Jugador Solicitante) {
        return null;
    }
}
