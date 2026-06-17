package edu.fiuba.algo3.modelo;

import java.util.List;

public class ContadorVotos {

    public Jugador obtenerGanador(List<Voto> votos) {

        Jugador ganador = null;
        int max = 0;

        for (Voto voto : votos) {
            if (voto.obtenerCantidad() > max) {
                max = voto.obtenerCantidad();
                ganador = voto.obtenerCandidato();
            }
        }

        return ganador;
    }

    public boolean hayEmpate(List<Voto> votos) {

        int max = 0;
        int candidatosConMismaCantVotos = 0;

        for (Voto voto : votos) {
            int cantidad = voto.obtenerCantidad();

            if (cantidad > max) {
                max = cantidad;
                candidatosConMismaCantVotos = 1;

            } else if (cantidad == max) {
                candidatosConMismaCantVotos++;
            }
        }

        return candidatosConMismaCantVotos > 1;
    }
}
