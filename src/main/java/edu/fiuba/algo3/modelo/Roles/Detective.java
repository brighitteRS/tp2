package edu.fiuba.algo3.modelo.Roles;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.NullPattern.BandoNulo;
import edu.fiuba.algo3.modelo.NullPattern.JugadorNulo;

public class Detective extends Rol {

    private Jugador ultimoInvestigado = new JugadorNulo();
    private Jugador investigado = new JugadorNulo();
    private Bando resultado = BandoNulo.INSTANCIA;

    public Detective() {
        super(BandoCiudadano.INSTANCIA);
    }

    @Override
    public Bando revelarBandoA(Jugador solicitante) {
        return revelarBando();
    }
    @Override
    protected void ejecutoEleccion(Jugador objetivo) {

        if (objetivo.equals(ultimoInvestigado)) {
            throw new IllegalArgumentException();
        }
        ultimoInvestigado = objetivo;
        investigado = objetivo;
    }

    //solucionar el tema del null(aplicar tdd para solucionar el bug)
    @Override
    public void actuarDeNoche() {
        resultado = investigado.revelarBandoReal();
        investigado = new JugadorNulo();
    }

    @Override
    public Bando obtenerResultado() {
        return resultado;
    }
}