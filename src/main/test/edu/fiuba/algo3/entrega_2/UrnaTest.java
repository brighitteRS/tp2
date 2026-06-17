package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.Ciudadano;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Mafioso;
import edu.fiuba.algo3.modelo.Urna.Urna;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class UrnaTest {

    @Test
    public void test01LosCandidatosSonJugadoresVivos() {

        // Arrange
        Jugador jugador1 = new Jugador("j1", new Mafioso(), false);
        Jugador jugador2 = new Jugador("j2", new Ciudadano(), true);
        Urna urna = new Urna();

        // Act y assert
        assertThrows(IllegalArgumentException.class, ()  -> {
            jugador2.nominar(urna, jugador1);
        });

    }

}
