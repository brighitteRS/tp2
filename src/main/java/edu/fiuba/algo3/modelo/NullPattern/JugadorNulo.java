package edu.fiuba.algo3.modelo.NullPattern;

import edu.fiuba.algo3.modelo.*;
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
    public void cambiarEstado(EstadoJugador nuevoEstado) {
    }

    @Override
    public void elegir(Jugador objetivo) {
    }

    @Override
    public boolean estaNulo() {
        return true;
    }
    public void registrarVotoEn(Urna urna, Jugador votado) {}
}