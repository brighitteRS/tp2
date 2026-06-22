package edu.fiuba.algo3.modelo.Urna;

import edu.fiuba.algo3.modelo.Jugador;

import java.util.ArrayList;
import java.util.List;

public class SistemaNominaciones {

    private List<Jugador> candidatos;

    public SistemaNominaciones() {
        this.candidatos = new ArrayList<>();
    }

    public SistemaNominaciones(List<Jugador> candidatos) {
        this.candidatos = candidatos;
    }

    public void agregarCandidato( Jugador nuevoCandidato ) {

        if (!nuevoCandidato.estaVivo()){
            throw new IllegalArgumentException("El jugador a nominar debe estar vivo");
        }
        if ( !this.esCandidato(nuevoCandidato)) {
            candidatos.add(nuevoCandidato);
        }
    }

    public List<Jugador> obtenerCandidatos(){
        return candidatos;
    }

    public boolean esCandidato( Jugador jugador ){
        return candidatos.contains(jugador);
    }

}
