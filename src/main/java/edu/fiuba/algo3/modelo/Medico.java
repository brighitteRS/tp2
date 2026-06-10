package edu.fiuba.algo3.modelo;

public class Medico extends Rol implements ActorNocturno{
    private Jugador protegido;

    public void elegirProtegido(Jugador objetivo) {
        this.protegido = objetivo;
    }

    public Medico() {
        super(new BandoCiudadano());
    }

    @Override
    public Bando revelarBandoA(Jugador Solicitante) {
        return null;
    }

    @Override
    public void actuarNoche(FaseNocturna fase) {
        fase.registrarProteccion(protegido);
    }
}
