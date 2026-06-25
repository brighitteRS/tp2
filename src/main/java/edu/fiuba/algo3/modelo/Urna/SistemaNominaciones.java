package edu.fiuba.algo3.modelo.Urna;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Jugador.Jugador;

import java.util.ArrayList;
import java.util.List;

public class SistemaNominaciones {

    private List<Jugador> candidatos;

    public SistemaNominaciones() {
        this.candidatos = new ArrayList<>();
    }

    public void agregarCandidato( Jugador nuevoCandidato ) {
        nuevoCandidato.validarSiPuedeActuar();

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