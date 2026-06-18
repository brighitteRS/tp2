package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.Roles.*;
import org.junit.jupiter.api.Test;
import edu.fiuba.algo3.modelo.*;

import static org.junit.jupiter.api.Assertions.*;

public class JugadorTest {
    @Test
    public void Test01LaCartaDelJugadorEliminadoQuedaRevelada(){
        // arrange
        Jugador jugador1 = new Jugador(new Mafioso());
        Jugador jugador2 = new Jugador(new Ciudadano());

        // act
        jugador1.cambiarEstado(new Muerto());

        //assert
        assertNotNull(jugador1.consultarBando(jugador2));
    }


    //preguntar
    @Test
    public void Test02JugadorMuertoNoPuedeActuar(){

        // arrange
        Mafioso mafioso = new Mafioso();
        Jugador jugadorMafioso = new Jugador(mafioso);
        Jugador victima = new Jugador(new Ciudadano());

        jugadorMafioso.cambiarEstado(new Muerto());

        // act
        mafioso.elegirVictima(victima);
        jugadorMafioso.actuarDeNoche();

        // assert
        assertNull(mafioso.obtenerVictima());
        }

    }
