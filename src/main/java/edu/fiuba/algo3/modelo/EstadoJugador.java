package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.FaseNocturna.ResultadoNocturno;
import edu.fiuba.algo3.modelo.Urna.Urna;

public interface EstadoJugador {

    boolean estaVivo();

    Bando consultarBando(Rol rol, Jugador propietario, Jugador solicitante);

    Rol consultarRol(Rol rol, Jugador propietario, Jugador solicitante);

    void actuarDeNoche(Rol rol, ResultadoNocturno resultado);

    void ejecutarEleccion(Rol rol, Jugador objetivo);

    Bando obtenerResultadoInvestigacion(Rol rol);

    Bando revelarBandoInvestigado(Rol rol);

    void validarPuedeSerVictimaDeMafia(Rol rol);

    Jugador votoPrioritario(Rol rol);

    void aplicarVoto(Rol rol, Jugador self, Urna urna);
}