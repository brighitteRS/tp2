package edu.fiuba.algo3.modelo.Mazo;

import edu.fiuba.algo3.modelo.*;

import java.util.ArrayList;
import java.util.List;

public class Mazo {

    private List<Rol> cartas;
    private Mezclador mezclador;

    public Mazo(List<Rol> cartas, Mezclador mezclador) {
        this.cartas = cartas;
        this.mezclador = mezclador;
    }

    public Mazo(int cantJugadores) {
        
        this.mezclador = new Aleatorio();
        EstrategiaDeComposicion estrategia = FabricaDeComposicion.crear(cantJugadores);
        this.cartas = estrategia.crearRoles(cantJugadores);
    }

    public int contarRolesDe(Class<?> tipo) {

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

    // en teoria es solo para los test. repartir no deberia crear a los jugadores (preguntar a ignacio antes de tocar)
    public void repartir(int cantidadJugadores, List<Jugador> jugadores) {

        mezclador.mezclar(cartas);
        for (int i = 0; i < cantidadJugadores; i++) {
            jugadores.add(new Jugador(cartas.get(i)));
        }
    }
}