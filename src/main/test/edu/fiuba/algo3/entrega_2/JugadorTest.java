/*package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.FaseNocturna.FaseNocturna;
import edu.fiuba.algo3.modelo.FaseNocturna.Mafia;
import edu.fiuba.algo3.modelo.Roles.Ciudadano;
import edu.fiuba.algo3.modelo.Roles.Mafioso;
import edu.fiuba.algo3.modelo.Roles.Medico;
import edu.fiuba.algo3.modelo.Urna.Urna;
import org.junit.jupiter.api.Test;
import edu.fiuba.algo3.modelo.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class JugadorTest {

    @Test
    public void jugadorEliminadoPuedeRevelarSuRol() {
        //arrange
        Rol rolCiudadano = new Ciudadano();
        Mafia mafia = new Mafia();
        Mafioso mafioso = new Mafioso();
        Jugador victima = new Jugador(rolCiudadano);
        Jugador jugador2 = new Jugador(new Ciudadano());
        FaseNocturna fase = new FaseNocturna(mafia, List.of());

        //act
        mafioso.elegirVictima(victima);
        mafia.recolectarVotos(List.of(mafioso));
        fase.ejecutar();

        //assert
        assertEquals(rolCiudadano, jugador2.consultarRol(victima));
    }

    @Test
    public void jugadorNoEliminadoNoPuedeRevelarSuRol() {
        //arrange
        Rol rolCiudadano = new Ciudadano();
        Mafia mafia = new Mafia();
        Mafioso mafioso = new Mafioso();
        Jugador victima = new Jugador(rolCiudadano);
        Jugador jugador2 = new Jugador(new Ciudadano());
        Jugador jugador3 = new Jugador(new Ciudadano());
        FaseNocturna fase = new FaseNocturna(mafia, List.of());

        //act
        mafioso.elegirVictima(victima);
        mafia.recolectarVotos(List.of(mafioso));
        fase.ejecutar();

        //assert
        assertEquals(null, jugador2.consultarRol(jugador3));
    }
        @Test
    public void verificaQueJugadorEliminadoNoPuedeRealizarNingunaAccionNocturnaEnRondasPosteriores(){
        // arrange
        Medico rolMedico = new Medico();
        Jugador medico = new Jugador(rolMedico);
        Jugador jugador1 = new Jugador(new Ciudadano());
        Mafioso mafioso = new Mafioso();
        Mafia mafia1 = new Mafia();
        Mafia mafia2 = new Mafia();
        FaseNocturna fase1 = new FaseNocturna(mafia1, List.of(medico));
        FaseNocturna fase2 = new FaseNocturna(mafia2, List.of(medico));

        // act
        mafioso.elegirVictima(medico);
        mafia1.recolectarVotos(List.of(mafioso));
        fase1.ejecutar();

        mafioso.elegirVictima(jugador1);
        mafia2.recolectarVotos(List.of(mafioso));
        rolMedico.elegirProtegido(jugador1);
        fase2.ejecutar();

        //assert
        assertFalse(jugador1.estaVivo());
    }

    @Test
    public void verificaQueJugadorEliminadoNoPuedeRealizarNingunaAccionDiurna(){
        // arrange
        Jugador jugador1 = new Jugador(new Ciudadano());
        Jugador jugador2 = new Jugador(new Ciudadano());

        List<Jugador> candidatos = List.of(jugador1, jugador2);
        Urna urna = new Urna(candidatos);

        // act
        jugador1.cambiarEstado(new Muerto());

        //assert
        assertThrows(UnsupportedOperationException.class, () -> jugador1.votar(urna, jugador2));
    }
}*/
