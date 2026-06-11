package edu.fiuba.algo3.modelo;

public class Medico extends Rol implements ActorNocturno {
    private Jugador protegido;

    public Medico() {
        super(new BandoCiudadano());
    }


    @Override
    public void elegirProtegido(Jugador protegido) {
        this.protegido = protegido;
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
