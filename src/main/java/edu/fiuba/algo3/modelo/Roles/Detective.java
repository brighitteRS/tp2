package edu.fiuba.algo3.modelo.Roles;

import edu.fiuba.algo3.modelo.*;

public class Detective extends Rol {

    private Jugador ultimoInvestigado;
    private String resultado;
    private Jugador investigado;

    public Detective() {
        super(new BandoCiudadano());
    }

    public void elegirInvestigado(Jugador jugador) {
        validarInvestigacion(jugador);
        this.investigado = jugador;
        this.ultimoInvestigado = jugador;
    }

    private void validarInvestigacion(Jugador jugador) {
        if (jugador == null) {
            throw new IllegalArgumentException();
        }

        if (!jugador.estaVivo() || jugador.equals(ultimoInvestigado)) {
            throw new IllegalArgumentException();
        }
    }

    public String resultadoInvestigacion() {
        return resultado;
    }

    @Override
    public Bando revelarBandoA(Jugador solicitante) {
        return revelarBando();
    }

    @Override
    public void actuarDeNoche() {
        resultado = investigado.consultarBando(investigado).obtenerNombre();
    }
}