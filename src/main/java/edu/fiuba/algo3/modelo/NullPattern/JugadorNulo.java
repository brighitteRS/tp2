package edu.fiuba.algo3.modelo.NullPattern;

import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Urna.Urna;

public class JugadorNulo extends Jugador {

    public static final JugadorNulo INSTANCIA =
            new JugadorNulo();

    private JugadorNulo() {
        super(RolNulo.INSTANCIA);
    }

    @Override
    public boolean estaVivo() {
        return false;
    }

    @Override
    public void elegir(Jugador objetivo) {
    }

    @Override
    public void guardarVotoNocturno(Urna urna) {
    }

    @Override
    public Jugador obtenerVotoPrioritario() {
        return this;
    }
}