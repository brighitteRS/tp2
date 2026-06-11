package edu.fiuba.algo3.modelo.Mazo;

import edu.fiuba.algo3.modelo.*;

import java.util.List;

public class Mazo {

    private List<Rol> cartas;
    private Mezclador mezclador;

    public Mazo(List<Rol> cartas, Mezclador mezclador) {
        this.cartas = cartas;
        this.mezclador = mezclador;
    }

    public static Mazo crear(int jugadores, Mezclador mezclador) {

        EstrategiaDeComposicion estrategia =
                FabricaDeComposicion.crear(jugadores);

        List<Rol> roles =
                estrategia.crearRoles(jugadores);

        return new Mazo(roles, mezclador);
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

    public void repartir(List<Jugador> jugadores) {
        mezclador.mezclar(cartas);

        for (int i = 0; i < jugadores.size(); i++) {
            jugadores.get(i).asignarRol(cartas.get(i));
        }
    }
}