package edu.fiuba.algo3.modelo;

public class Mafioso extends Rol{
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
}
