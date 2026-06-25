package edu.fiuba.algo3.modelo.FaseNocturna;

import edu.fiuba.algo3.modelo.Jugador.Jugador;

import java.util.ArrayList;
import java.util.List;

public class ResultadoNocturno {

    private final List<Jugador> atacados = new ArrayList<>();
    private final List<Jugador> protegidos = new ArrayList<>();
    private final List<Jugador> investigados = new ArrayList<>();
    private final List<Jugador> victimas = new ArrayList<>();

    public void registrarInvestigado(Jugador jugador) {investigados.add(jugador);}

    public void registrarAtaque(Jugador jugador) {
        atacados.add(jugador);
    }

    public void registrarProteccion(Jugador jugador) {
        protegidos.add(jugador);
    }

    public void resolver() {

        List<Jugador> victimasFinales = new ArrayList<>(atacados);

        victimasFinales.removeAll(protegidos);

        victimas.addAll(victimasFinales);

        victimasFinales.forEach(Jugador::eliminar);
    }
}