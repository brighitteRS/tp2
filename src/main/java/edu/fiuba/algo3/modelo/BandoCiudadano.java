package edu.fiuba.algo3.modelo;

public class BandoCiudadano implements Bando {
    @Override
    public String obtenerNombre() {
        return "Ciudadano";
    }

    @Override
    public boolean esMafia() {
        return false;
    }
}
