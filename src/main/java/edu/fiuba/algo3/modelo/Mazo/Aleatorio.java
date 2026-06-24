package edu.fiuba.algo3.modelo.Mazo;

import edu.fiuba.algo3.modelo.Jugador.Rol;

import java.util.Collections;
import java.util.List;

public class Aleatorio implements Mezclador {

    @Override
    public void mezclar(List<Rol> cartas) {
        Collections.shuffle(cartas);
    }
}