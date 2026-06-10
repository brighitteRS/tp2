package edu.fiuba.algo3.modelo;

public class FaseNocturna {

    private Jugador victimaMafia;
    private Jugador protegidoMedico;

    public void registrarVictimaMafia(Jugador objetivo) {

       if (!objetivo.estaVivo() || objetivo.esDeLaMafia()) {
                throw new IllegalArgumentException();
            }
            victimaMafia = objetivo;
    }

    public void registrarProteccion(Jugador objetivo) {
        if (!objetivo.estaVivo()) {
            throw new IllegalArgumentException();
        }
        protegidoMedico = objetivo;
    }

    public Jugador obtenerVictimaMafia() {
        return victimaMafia;
    }

    public void ejecutar() {
        if (victimaMafia != protegidoMedico) {
            victimaMafia.eliminar();
        }

        victimaMafia = null;
        protegidoMedico = null;
    }
}