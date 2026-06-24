package edu.fiuba.algo3.modelo.Mazo;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Jugador.Rol;
import java.util.List;

public class Mazo {

    private final List<Rol> cartas;
    private final Mezclador mezclador;

    public Mazo(List<Rol> cartas, Mezclador mezclador) {
        this.cartas = cartas;
        this.mezclador = mezclador;
    }

    public Mazo(int cantJugadores) {
        this.mezclador = new Aleatorio();

        EstrategiaDeComposicion estrategia =
                FabricaDeComposicion.crear(cantJugadores);

        this.cartas = estrategia.crearRoles(cantJugadores);
    }

    public void mezclar() {
        mezclador.mezclar(cartas);
    }

    public Rol sacarCarta() {

        if (cartas.isEmpty()) {
            throw new IllegalStateException();
        }

        return cartas.remove(0);
    }

    public int totalDeCartas() {
        return cartas.size();
    }

    public int contarRolesDe(Class<?> tipo) {

        int contador = 0;

        for (Rol rol : cartas) {
            if (rol.getClass().equals(tipo)) {
                contador++;
            }
        }
        return contador;
    }

    public boolean tieneCartas(){
        return !cartas.isEmpty();
    }
}