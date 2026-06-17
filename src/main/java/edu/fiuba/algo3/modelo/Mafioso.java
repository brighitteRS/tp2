package edu.fiuba.algo3.modelo;
import java.util.ArrayList;
import java.util.List;

public class Mafioso extends Rol implements ActorNocturno {

    private List<Jugador> complices = new ArrayList<>();
    private Jugador victima;

    public Mafioso() {
        super(new BandoMafia());
    }

    @Override
    public void reconocerComplices(List<Jugador> complices) {
        this.complices = complices;
    }

    @Override
    public boolean esComplice(Jugador jugador) {
        return complices.contains(jugador);
    }

    @Override
    public Bando revelarBandoA(Jugador solicitante) {
        if (solicitante.esDeLaMafia()) {
            return revelarBando();
        }
        return null;
    }

    @Override
    public void actuarNoche(FaseNocturna fase) {
        fase.registrarVictimaMafia(victima);
    }

    @Override
    public void elegirVictima(Jugador victima) {

        if (!victima.puedeSerVictima()) {
            throw new IllegalArgumentException();
        }
        this.victima = victima;
    }

}
