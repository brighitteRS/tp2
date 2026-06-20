package edu.fiuba.algo3.modelo.NullPattern;

import edu.fiuba.algo3.modelo.Bando;

public class BandoNulo implements Bando {

    public static final BandoNulo INSTANCIA = new BandoNulo();

    private BandoNulo() {}

    @Override
    public boolean esMafia() {
        return false;
    }
}
