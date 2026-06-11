package edu.fiuba.algo3.modelo;

public class Mafioso extends Rol implements ActorNocturno {

    private Jugador victima;

    public Mafioso() {
        super(new BandoMafia());
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
