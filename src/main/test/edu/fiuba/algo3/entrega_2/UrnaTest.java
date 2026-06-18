package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.Muerto;
import edu.fiuba.algo3.modelo.Roles.Ciudadano;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Roles.Mafioso;
import edu.fiuba.algo3.modelo.Urna.Urna;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class UrnaTest {

    @Test
    public void test01LosCandidatosSonJugadoresVivos() {

        // Arrange
        Jugador jugador1 = new Jugador(new Mafioso());
        Jugador jugador2 = new Jugador(new Ciudadano());
        Urna urna = new Urna();

        // Act
        jugador1.cambiarEstado(new Muerto());

        // Assert
        assertThrows(IllegalArgumentException.class, ()  -> {
            jugador2.nominar(urna, jugador1);
        });

    }

}
