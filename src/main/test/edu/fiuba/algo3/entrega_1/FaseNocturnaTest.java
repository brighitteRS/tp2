package edu.fiuba.algo3.entrega_1;

import org.junit.jupiter.api.Test;
import edu.fiuba.algo3.modelo.*;

import static org.junit.jupiter.api.Assertions.*;


public class FaseNocturnaTest {

    @Test
    public void test05laMafiaPuedeSeleccionarUnaVictimaValida() {

        // Arrange
        Jugador jugador1 = new Jugador("Jugador 1");
        jugador1.asignarRol(new Ciudadano());

        Jugador jugador2 = new Jugador("Jugador 2");
        jugador2.asignarRol(new Mafioso());

        FaseNocturna fase = new FaseNocturna();

        //act
        jugador2.elegirVictima(jugador1);
        jugador2.ejecutarAccionNocturna(fase);
        fase.ejecutar();

        //assert
        assertFalse(jugador1.estaVivo());
    }

    @Test
    public void test06laMafiaNoPuedeSeleccionarJugadorMuertoOMafioso() {

        // arrange
        Jugador jugador1 = new Jugador("Jugador 1");
        jugador1.asignarRol(new Ciudadano());
        jugador1.eliminar();

        Jugador jugador2 = new Jugador("Jugador 2");
        jugador2.asignarRol(new Mafioso());

        Jugador jugador3 = new Jugador("Jugador 3");
        jugador3.asignarRol(new Mafioso());

        //act y assert
        assertThrows(IllegalArgumentException.class, () ->
                jugador2.elegirVictima(jugador1));


        assertThrows(IllegalArgumentException.class, () ->
                jugador2.elegirVictima(jugador3));

    }

    @Test
    public void test07elMedicoSalvaAlJugadorAtacadoPorLaMafia() {

        // arrange
        Jugador jugador1 = new Jugador("Jugador 1");
        jugador1.asignarRol(new Ciudadano());

        Jugador jugador2 = new Jugador("Jugador 2");
        jugador2.asignarRol(new Mafioso());

        Jugador jugador3 = new Jugador("Jugador 3");
        jugador3.asignarRol(new Medico());

        FaseNocturna fase = new FaseNocturna();

        // act
        jugador2.elegirVictima(jugador1);
        jugador3.elegirProtegido(jugador1);

        jugador2.ejecutarAccionNocturna(fase);
        jugador3.ejecutarAccionNocturna(fase);

        fase.ejecutar();

        //assert
        assertTrue(jugador1.estaVivo());
    }

    @Test
    public void test08laMafiaEliminaAlJugadorSiNoEstaProtegido() {

        //arrange
        Jugador jugador1 = new Jugador("Jugador 1");
        jugador1.asignarRol(new Ciudadano());

        Jugador jugador2 = new Jugador("Jugador 2");
        jugador2.asignarRol(new Ciudadano());

        Jugador jugador3 = new Jugador("Jugador 3");
        jugador3.asignarRol(new Mafioso());

        Jugador jugador4 = new Jugador("Jugador 4");
        jugador4.asignarRol(new Medico());

        FaseNocturna fase = new FaseNocturna();

        jugador3.elegirVictima(jugador1);
        jugador4.elegirProtegido(jugador2);

        jugador3.ejecutarAccionNocturna(fase);
        jugador4.ejecutarAccionNocturna(fase);

        fase.ejecutar();

        assertFalse(jugador1.estaVivo());
        assertTrue(jugador2.estaVivo());
    }
}
