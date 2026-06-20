package edu.fiuba.algo3.modelo;

public class BandoCiudadano implements Bando {

    public static final BandoCiudadano INSTANCIA = new BandoCiudadano();

    private BandoCiudadano() {}

    @Override
    public boolean esMafia() {
        return false;
    }
}