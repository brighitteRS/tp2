package edu.fiuba.algo3.modelo;
import java.util.*;


public class Mazo {

    private List<Rol> cartas = new ArrayList<>();

    public Mazo(int cantidadJugadores) {

        if (cantidadJugadores <= 6) {
            cartas.add(new Mafioso());
            if (Math.random() < 0.5) {
                cartas.add(new Detective());
            } else {
                cartas.add(new Medico());
            }
            for (int i = 0; i < cantidadJugadores - 2; i++) {
                cartas.add(new Ciudadano());
            }
        }

    }
    public int contarRolesDe(Class<?> tipo){

        int contador = 0;
        for (Rol r : cartas) {
            if (r.getClass().equals(tipo)) {
                contador++;
            }
        }
        return contador;

    }

    public int totalDeCartas() {
        return cartas.size();
    }

    public void repartir(List<Jugador> jugadores){

        Collections.shuffle(cartas); /* mezcla las cartas */

        for (int i=0; i< jugadores.size(); i++){

            jugadores.get(i).setRol(cartas.get(i));

        }


    }

}
