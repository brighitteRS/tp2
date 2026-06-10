package edu.fiuba.algo3.modelo;

public class Mafioso extends Rol implements ActorNocturno{
    private Jugador victima;

    public void elegirVictima(Jugador objetivo) {
        this.victima = objetivo;
    }

    public Mafioso(){
        super(new BandoMafia());
    }

    @Override
    public Bando revelarBandoA(Jugador solicitante){
        if (solicitante.esDeLaMafia()) {
            return revelarBando();
        }
        return null;
    }

    @Override
    public void actuarNoche(FaseNocturna fase) {
        fase.registrarVictimaMafia(victima);
    }
}
