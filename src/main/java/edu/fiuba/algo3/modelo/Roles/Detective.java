package edu.fiuba.algo3.modelo.Roles;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.FaseNocturna.ResultadoNocturno;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Jugador.Rol;
import edu.fiuba.algo3.modelo.NullPattern.*;

public class Detective extends Rol {

    private Jugador ultimoInvestigado = JugadorNulo.INSTANCIA;
    private Jugador investigado = JugadorNulo.INSTANCIA;
    private Bando resultado = BandoNulo.INSTANCIA;

    public Detective() {
        super(BandoCiudadano.INSTANCIA);
    }

    @Override
    public Bando revelarBandoA(Jugador solicitante) {
        return revelarBando();
    }

    @Override
    protected void elegirObjetivo(Jugador objetivo) {

        if (objetivo == ultimoInvestigado) {
            throw new IllegalArgumentException();
        }

        ultimoInvestigado = objetivo;
        investigado = objetivo;
    }

    @Override
    public void actuarDeNoche(ResultadoNocturno resultado) {
        this.resultado = investigado.revelarBandoAInvestigacion();
        investigado = JugadorNulo.INSTANCIA;
    }

    @Override
    public Bando obtenerResultado() {
        return resultado;
    }
}