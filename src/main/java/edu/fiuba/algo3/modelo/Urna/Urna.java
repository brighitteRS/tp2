package edu.fiuba.algo3.modelo.Urna;

import edu.fiuba.algo3.modelo.Jugador;

import java.util.ArrayList;
import java.util.List;


public class Urna {

    private List<Jugador> candidatos;
    private List<Voto> votos;

    public Urna() {
        this.candidatos = new ArrayList<>();
        this.votos = new ArrayList<>();
    }

    public Urna(List<Jugador> candidatos) {
        this.candidatos = candidatos;
        this.votos = new ArrayList<>();
    }

    public void agregarCandidato( Jugador nuevoCandidato ) {

        if (!nuevoCandidato.estaVivo()){
            throw new IllegalArgumentException("El jugador a nominar debe estar vivo");
        }
        if ( !this.esCandidato(nuevoCandidato)) {
            candidatos.add(nuevoCandidato);
        }
    }

    public void registrarVoto(Jugador votador,Jugador votado) {
        this.votos.add(new Voto(votador, votado));
    }

    public List<Jugador> obtenerCandidatos(){
        return candidatos;
    }

    public List<Jugador> getGanadores() {

        if (candidatos.isEmpty()) {
            // Lanzar un excepcion
        }

        List<Jugador> ganadores = new ArrayList<>();
        int votosMax = -1;

        for (Jugador c : candidatos) {
            int votosActuales = conteo(c);

            if (votosActuales > votosMax) {
                votosMax = votosActuales;
                ganadores.clear();
                ganadores.add(c);
            } else if ( votosActuales == votosMax ) {
                ganadores.add(c);
            }

        }

        return ganadores;
    }

    private int conteo(Jugador candidato) {
        int cantidadVotos = 0;
        for (Voto v : votos) {
            if (v.obtenerVotado().equals(candidato)) {
                cantidadVotos++;
            }
        }
        return cantidadVotos;
    }

    private boolean esCandidato(Jugador jugador) {
        return candidatos.contains(jugador);
    }



}
