package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Jugador.Jugador;

import java.util.ArrayList;
import java.util.List;

public class RegistroMafia {

    private final List<Jugador> mafiosos = new ArrayList<>();

    public void registrar(Jugador jugador) {
        mafiosos.add(jugador);
    }

    public void informarComplices() {

        mafiosos.forEach(mafioso ->
                mafioso.recibirComplices(mafiosos));
    }
}
