package edu.fiuba.algo3.modelo.NullPattern;

import edu.fiuba.algo3.modelo.*;

public class JugadorNulo extends Jugador {

    public JugadorNulo() {
        super(new RolNulo());
    }

    @Override
    public boolean estaVivo() {
        return false;
    }

    @Override
    public void elegir(Jugador objetivo) {
        // no hace nada
    }

    @Override
    public boolean estaNulo() {
        return true;
    }
}