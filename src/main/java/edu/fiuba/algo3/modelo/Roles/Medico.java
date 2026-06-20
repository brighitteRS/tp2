package edu.fiuba.algo3.modelo.Roles;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.NullPattern.JugadorNulo;

public class Medico extends Rol {

    private Jugador ultimoProtegido = new JugadorNulo();
    private Jugador protegido = new JugadorNulo();

    public Medico() {
        super(BandoCiudadano.INSTANCIA);
    }

    @Override
    public Bando revelarBandoA(Jugador solicitante) {
        return revelarBando();
    }

    @Override
    protected void ejecutoEleccion(Jugador objetivo) {

        if (objetivo.equals(ultimoProtegido)) {
            throw new IllegalArgumentException();
        }

        ultimoProtegido = objetivo;
        protegido = objetivo;
    }

    @Override
    public void actuarDeNoche() {
        protegido.cambiarEstado(new Vivo());
        protegido = new JugadorNulo();
    }

}