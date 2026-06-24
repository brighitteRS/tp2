package edu.fiuba.algo3.modelo.Roles;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.FaseNocturna.ResultadoNocturno;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Jugador.Rol;
import edu.fiuba.algo3.modelo.NullPattern.JugadorNulo;

public class Medico extends Rol {

    private Jugador ultimoProtegido = JugadorNulo.INSTANCIA;
    private Jugador protegido = JugadorNulo.INSTANCIA;

    public Medico() {
        super(BandoCiudadano.INSTANCIA);
    }

    @Override
    public Bando revelarBandoA(Jugador solicitante) {
        return revelarBando();
    }

    @Override
    protected void elegirObjetivo(Jugador objetivo) {

        if (objetivo == ultimoProtegido) {
            throw new IllegalArgumentException();
        }

        ultimoProtegido = objetivo;
        protegido = objetivo;
    }

    @Override
    public void actuarDeNoche(ResultadoNocturno resultado) {
        resultado.registrarProteccion(protegido);
        protegido = JugadorNulo.INSTANCIA;
    }
}