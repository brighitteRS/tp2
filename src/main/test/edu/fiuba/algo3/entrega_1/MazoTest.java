package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class MazoTest {

    @Test
    public void testMazoConSeisJugadoresTieneCamposicionCorrecta() {
        Mazo mazo = new Mazo(6);

        assertEquals(1, mazo.contarRolesDe(Mafioso.class));
        assertEquals(1, mazo.contarRolesDe(Detective.class) + mazo.contarRolesDe(Medico.class));
        assertEquals(4, mazo.contarRolesDe(Ciudadano.class));
        assertEquals(6, mazo. totalDeCartas());

    }

    @Test
    public void testCadaJugadorRecibeUnRol(){

        Mazo mazo = new Mazo(6);
        List<Jugador> jugadores = new ArrayList<>();
        for (int i=0; i < 6; i++){

            jugadores.add(new Jugador("Jugador" + 1));
        }

        mazo.repartir(jugadores);

        for (Jugador jugador : jugadores) {

            assertNotNull(jugador.getRol());
        }
    }
}
