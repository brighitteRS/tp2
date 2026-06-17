package edu.fiuba.algo3.modelo;

public class BandoMafia implements Bando {

    @Override
    public String obtenerNombre() {
        return "Mafia";
    }

    @Override
    public boolean esMafia() {
        return true;
    }
}
