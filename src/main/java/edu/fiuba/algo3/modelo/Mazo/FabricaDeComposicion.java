package edu.fiuba.algo3.modelo.Mazo;

public class FabricaDeComposicion {

    public static EstrategiaDeComposicion crear(int jugadores) {

        if (jugadores <= 6) return new ComposicionDe5a6Jugadores();
        if (jugadores <= 9) return new ComposicionDe7a9Jugadores();
        return new ComposicionDe10a12Jugadores();
    }
}