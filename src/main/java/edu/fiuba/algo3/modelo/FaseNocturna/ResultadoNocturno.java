package edu.fiuba.algo3.modelo.FaseNocturna;

import edu.fiuba.algo3.modelo.*;

import java.util.ArrayList;
import java.util.List;

public class ResultadoNocturno {

    private final List<Jugador> atacados = new ArrayList<>();
    private final List<Jugador> protegidos = new ArrayList<>();

    public void registrarAtaque(Jugador jugador) {
        atacados.add(jugador);
    }

    public void registrarProteccion(Jugador jugador) {
        protegidos.add(jugador);
    }

    public void resolver() {

        List<Jugador> victimas = new ArrayList<>(atacados);

        victimas.removeAll(protegidos);

        victimas.forEach(Jugador::eliminar);
    }
}