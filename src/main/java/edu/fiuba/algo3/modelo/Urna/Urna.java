package edu.fiuba.algo3.modelo.Urna;

import edu.fiuba.algo3.modelo.Jugador;

import java.util.ArrayList;
import java.util.List;

public class Urna {
    private List<Jugador> votados;
    private List<Voto> votos;

    public Urna() {
        this.votados = new ArrayList<>();
        this.votos = new ArrayList<>();
    }

    public void registrarVoto(Jugador votador,Jugador votado) {
        this.agregarVotado(votado);
        this.votos.add(new Voto(votador, votado));
    }

    public List<Jugador> getGanadores() {

        List<Jugador> ganadores = new ArrayList<>();
        int votosMax = -1;

        for (Jugador v : votados) {
            int votosActuales = conteo(v);

            if (votosActuales > votosMax) {
                votosMax = votosActuales;
                ganadores.clear();
                ganadores.add(v);
            } else if ( votosActuales == votosMax ) {
                ganadores.add(v);
            }
        }
        return ganadores;
    }

    private int conteo(Jugador votado) {
        int cantidadVotos = 0;
        for (Voto v : votos) {
            if (v.obtenerVotado().equals(votado)) {
                cantidadVotos++;
            }
        }
        return cantidadVotos;
    }

    private boolean fueVotado(Jugador jugador) {
        return votados.contains(jugador);
    }

    private void agregarVotado(Jugador votado) {
        if ( !this.fueVotado(votado) ){
            votados.add(votado);
        }
}}
